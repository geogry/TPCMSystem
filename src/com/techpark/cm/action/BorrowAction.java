package com.techpark.cm.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Element;
import com.techpark.cm.domain.Message;
import com.techpark.cm.domain.PassBorrow;
import com.techpark.cm.domain.RefuseBorrow;
import com.techpark.cm.domain.TempBorrow;
import com.techpark.cm.domain.User;
import com.techpark.cm.service.ElementService;
import com.techpark.cm.service.MessageService;
import com.techpark.cm.service.PassBorrowService;
import com.techpark.cm.service.RefuseBorrowService;
import com.techpark.cm.service.TempBorrowService;
import com.techpark.cm.service.UserService;
import com.techpark.cm.utils.DateUtil;

public class BorrowAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Element element;
	
	private User user;
	
	private String selectIds;
	
	private TempBorrow tempBorrow;
	
	private List<PassBorrow> passBorrows;
	
	private List<RefuseBorrow> refuseBorrows;
	
	private ElementService elementService;
	
	private UserService userService;
	
	private TempBorrowService tempBorrowService;
	
	private PassBorrowService passBorrowService;
	
	private RefuseBorrowService refuseBorrowService;
	
	private MessageService messageService;
	
	private Map<String, Object> session;
	
	private String jsonString;

	public String borrow(){
		element = elementService.findElementById(element.getId());
		if(element.getStore() >= tempBorrow.getCount()){
			user = userService.findUserById(session.get("id").toString());
			
			tempBorrow.setApplicant(user);
			tempBorrow.setElement(element);
			tempBorrow.setTime(DateUtil.dateFormat());
			tempBorrowService.addTempBorrow(tempBorrow);
			
			Message message = new Message();
			message.setChecked(0);
			message.setTime(DateUtil.dateFormat());
			message.setContent(user.getRelname() + "对器件" + element.getElementname() + "提出了申请，请及时处理！");
			message.setUser(userService.findUserById("0"));
			messageService.addMessage(message);
			
			jsonString = "{success:true}";
		}else {
			Message message = new Message();
			message.setChecked(0);
			message.setTime(DateUtil.dateFormat());
			message.setContent(element.getElementname() + "库存量已经不能满足用户的需要，请及时购买该设备或耗材！");
			message.setUser(userService.findUserById("1001"));
			messageService.addMessage(message);
			
			jsonString = "{success:false, errorMessage:'申领数量超过了库存<br/>我们将尽快通知管理员'}";
		}
		return SUCCESS;
	}
	
	public String showTempBorrows(){
		user = userService.findUserById(session.get("id").toString());
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("messages") || name.equals("elements") || name.equals("tempElements") 
						|| name.equals("tempPors") || name.equals("tempBorrows") || name.equals("passBorrows") 
						|| name.equals("passPors") || name.equals("refuseBorrows") || name.equals("refusePors"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(user.getTempBorrows(), cfg);
		jsonString = "{success:true, totalCount : " + user.getTempBorrows().size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showAllPassBorrows(){
		passBorrows = passBorrowService.findAllPassBorrow();
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("messages") || name.equals("elements") || name.equals("tempElements") 
						|| name.equals("tempPors") || name.equals("tempBorrows") || name.equals("passBorrows") 
						|| name.equals("passPors") || name.equals("refuseBorrows") || name.equals("refusePors"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(passBorrows, cfg);
		jsonString = "{success:true, totalCount : " + passBorrows.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showPassBorrows(){
		passBorrows = passBorrowService.findPassBorrowByUserId(session.get("id").toString());
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("messages") || name.equals("elements") || name.equals("tempElements") 
						|| name.equals("tempPors") || name.equals("tempBorrows") || name.equals("passBorrows") 
						|| name.equals("passPors") || name.equals("refuseBorrows") || name.equals("refusePors"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(passBorrows, cfg);
		jsonString = "{success:true, totalCount : " + passBorrows.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showReturnPassBorrows(){
		passBorrows = passBorrowService.findPassBorrowByUserId(session.get("id").toString());
		for(PassBorrow passBorrow : passBorrows){
			if(!(passBorrow.getElement().getType().getIselement() == 0 && passBorrow.getReturned() == 0)){
				passBorrows.remove(passBorrow);
			}
		}
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("messages") || name.equals("elements") || name.equals("tempElements") 
						|| name.equals("tempPors") || name.equals("tempBorrows") || name.equals("passBorrows") 
						|| name.equals("passPors") || name.equals("refuseBorrows") || name.equals("refusePors"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(passBorrows, cfg);
		jsonString = "{success:true, totalCount : " + passBorrows.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String returnElement(){
		String[] ids = selectIds.split(",");
		PassBorrow passBorrow;
		for(int i = 0; i < ids.length; i++){
			passBorrow = passBorrowService.findPassBorrowById(Integer.parseInt(ids[i]));
			passBorrow.setReturned(1);
			passBorrow.getElement().setStore(passBorrow.getCount() + passBorrow.getElement().getStore());
			elementService.modifyElement(passBorrow.getElement());
			passBorrowService.modifyPassBorrow(passBorrow);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String deleteTempBorrow(){
		boolean flag = false;
		String[] ids = selectIds.split(",");
		TempBorrow tempBorrow;
		for(int i = 0; i < ids.length; i++){
			tempBorrow = tempBorrowService.findTempBorrowById(Integer.parseInt(ids[i]));
			if(tempBorrow != null)
				tempBorrowService.deleteTempBorrow(tempBorrow);
			else
				flag = true;
		}
		if(flag){
			jsonString = "{success:false, errorMessage:'申请可能已通过'}";
		}else{
			jsonString = "{success:true}";
		}
		return SUCCESS;
	}
	
	public String deletePassBorrow(){
		String[] ids = selectIds.split(",");
		PassBorrow passBorrow;
		for(int i = 0; i < ids.length; i++){
			passBorrow = passBorrowService.findPassBorrowById(Integer.parseInt(ids[i]));
			if(passBorrow != null){
				passBorrowService.deletePassBorrow(passBorrow);
			}
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String deleteRefuseBorrow(){
		String[] ids = selectIds.split(",");
		RefuseBorrow refuseBorrow;
		for(int i = 0; i < ids.length; i++){
			refuseBorrow = refuseBorrowService.findRefuseBorrowById(Integer.parseInt(ids[i]));
			if(refuseBorrow != null){
				refuseBorrowService.deleteRefuseBorrow(refuseBorrow);
			}
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String showAllRefuseBorrows(){
		refuseBorrows = refuseBorrowService.findAllRefuseBorrow();
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("messages") || name.equals("elements") || name.equals("tempElements") 
						|| name.equals("tempPors") || name.equals("tempBorrows") || name.equals("passBorrows") 
						|| name.equals("passPors") || name.equals("refuseBorrows") || name.equals("refusePors"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(refuseBorrows, cfg);
		jsonString = "{success:true, totalCount : " + refuseBorrows.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showRefuseBorrows(){
		refuseBorrows = refuseBorrowService.findRefuseBorrowByUserId(session.get("id").toString());
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("messages") || name.equals("elements") || name.equals("tempElements") 
						|| name.equals("tempPors") || name.equals("tempBorrows") || name.equals("passBorrows") 
						|| name.equals("passPors") || name.equals("refuseBorrows") || name.equals("refusePors"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(refuseBorrows, cfg);
		jsonString = "{success:true, totalCount : " + refuseBorrows.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public TempBorrow getTempBorrow() {
		return tempBorrow;
	}

	public void setTempBorrow(TempBorrow tempBorrow) {
		this.tempBorrow = tempBorrow;
	}

	public void setElementService(ElementService elementService) {
		this.elementService = elementService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTempBorrowService(TempBorrowService tempBorrowService) {
		this.tempBorrowService = tempBorrowService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setPassBorrowService(PassBorrowService passBorrowService) {
		this.passBorrowService = passBorrowService;
	}

	public void setRefuseBorrowService(RefuseBorrowService refuseBorrowService) {
		this.refuseBorrowService = refuseBorrowService;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}
}
