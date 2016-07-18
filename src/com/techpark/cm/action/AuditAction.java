package com.techpark.cm.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Message;
import com.techpark.cm.domain.PassBorrow;
import com.techpark.cm.domain.PassPor;
import com.techpark.cm.domain.RefuseBorrow;
import com.techpark.cm.domain.RefusePor;
import com.techpark.cm.domain.TempBorrow;
import com.techpark.cm.domain.TempPor;
import com.techpark.cm.domain.User;
import com.techpark.cm.service.ElementService;
import com.techpark.cm.service.MessageService;
import com.techpark.cm.service.PassBorrowService;
import com.techpark.cm.service.PassPorService;
import com.techpark.cm.service.RefuseBorrowService;
import com.techpark.cm.service.RefusePorService;
import com.techpark.cm.service.TempBorrowService;
import com.techpark.cm.service.TempPorService;
import com.techpark.cm.service.UserService;
import com.techpark.cm.utils.DateUtil;

public class AuditAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private List<User> users;
	
	private List<TempBorrow> tempBorrows;
	
	private List<TempPor> tempPors;
	
	private String jsonString;
	
	private String selectIds;
	
	private Map<String, Object> session;
	
	private UserService userService;
	
	private TempBorrowService tempBorrowService;
	
	private TempPorService tempPorService;
	
	private PassPorService passPorService;
	
	private RefusePorService refusePorService;
	
	private PassBorrowService passBorrowService;
	
	private RefuseBorrowService refuseBorrowService;
	
	private ElementService elementService;
	
	private MessageService messageService;

	public String showRegisteUsers(){
		users = userService.findRegisterUser();
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("messages") || name.equals("tempPors") || name.equals("tempBorrows") 
						|| name.equals("passBorrows") || name.equals("passPors") || name.equals("refuseBorrows")
						|| name.equals("refusePors"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(users, cfg);
		jsonString = "{success:true,totalCount:" + users.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showTempBorrows(){
		tempBorrows = tempBorrowService.findAllTempBorrow();
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
		JSONArray jsonArray = JSONArray.fromObject(tempBorrows, cfg);
		jsonString = "{success:true,totalCount:" + tempBorrows.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showTempPors(){
		tempPors = tempPorService.findAllTempPor();
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
		JSONArray jsonArray = JSONArray.fromObject(tempPors, cfg);
		jsonString = "{success:true,totalCount:" + tempPors.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String agreeUser(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			User user = userService.findUserById(ids[i]);
			user.setChecked(1);
			userService.modifyUser(user);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String refuseUser(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			userService.deleteUser(userService.findUserById(ids[i]));
		}
		jsonString = "{successd:true}";
		return SUCCESS;
	}
	
	public String agreeBorrow(){
		String[] ids = selectIds.split(",");
		PassBorrow passBorrow = new PassBorrow();
		TempBorrow tempBorrow;
		Message message = new Message();
		User user = userService.findUserById(session.get("id").toString());
		for(int i = 0; i < ids.length; i++){
			tempBorrow = tempBorrowService.findTempBorrowById(Integer.parseInt(ids[i]));
			//建立新的通过申请信息
			passBorrow.setApplicant(tempBorrow.getApplicant());
			passBorrow.setCount(tempBorrow.getCount());
			passBorrow.setElement(tempBorrow.getElement());
			passBorrow.setPurpose(tempBorrow.getPurpose());
			passBorrow.setTime(tempBorrow.getTime());
			if(tempBorrow.getElement().getType().getIselement() == 1)
				//该类型是设备类型，不需要归还，用-1进行区别
				passBorrow.setReturned(-1);
			else
				//该类型是耗材类型，需要归还，将已归还标志设置为未归还0
				passBorrow.setReturned(0);
			passBorrow.setVerifier(user);
			passBorrowService.addPassBorrow(passBorrow);
			//修改库存
			tempBorrow.getElement().setStore(tempBorrow.getElement().getStore() - tempBorrow.getCount());
			elementService.modifyElement(tempBorrow.getElement());
			//发送一条消息给申请用户
			message.setUser(tempBorrow.getApplicant());
			message.setChecked(0);
			message.setContent("你对名称为【" + tempBorrow.getElement().getElementname() + "】的器件的申请已通过管理员审核，可以到仓库领取！");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			
			//将该条临时申请删除
			tempBorrowService.deleteTempBorrow(tempBorrow);
		}
		jsonString = "{successd:true}";
		return SUCCESS;
	}
	
	public String refuseBorrow(){
		String[] ids = selectIds.split(",");
		RefuseBorrow refuseBorrow = new RefuseBorrow();
		TempBorrow tempBorrow;
		Message message = new Message();
		User user = userService.findUserById(session.get("id").toString());
		for(int i = 0; i < ids.length; i++){
			tempBorrow = tempBorrowService.findTempBorrowById(Integer.parseInt(ids[i]));
			//建立新的拒绝申请
			refuseBorrow.setApplicant(tempBorrow.getApplicant());
			refuseBorrow.setCount(tempBorrow.getCount());
			refuseBorrow.setElement(tempBorrow.getElement());
			refuseBorrow.setPurpose(tempBorrow.getPurpose());
			refuseBorrow.setTime(tempBorrow.getTime());
			refuseBorrow.setVerifier(user);
			refuseBorrowService.addRefuseBorrow(refuseBorrow);
			//发送一条消息通知用户
			message.setUser(tempBorrow.getApplicant());
			message.setChecked(0);
			message.setContent("你对名称为【" + tempBorrow.getElement().getElementname() + "】的器件的申请已被管理员拒绝！");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//删除该条申请
			tempBorrowService.deleteTempBorrow(tempBorrow);
		}
		jsonString = "{successd:true}";
		return SUCCESS;
	}
	
	public String agreePor(){
		String[] ids = selectIds.split(",");
		PassPor passPor = new PassPor();
		TempPor tempPor;
		Message message = new Message();
		User user = userService.findUserById(session.get("id").toString());
		for(int i = 0; i < ids.length; i++){
			tempPor = tempPorService.findTempPorById(Integer.parseInt(ids[i]));
			//建立新的通过申购申请
			passPor.setApplicant(tempPor.getApplicant());
			passPor.setInfo(tempPor.getInfo());
			passPor.setTempElement(tempPor.getTempElement());
			passPor.setTime(tempPor.getTime());
			passPor.setVerifier(user);
			passPorService.addPassPor(passPor);
			//发送一条消息通知用户
			message.setUser(tempPor.getApplicant());
			message.setChecked(0);
			message.setContent("你对名称为【" + tempPor.getTempElement().getElementname() + "】的器件的申请已通过管理员审核，尽请期待！");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//发送一条消息通知超级管理员
			User superAdmin = userService.findUserById("1001");
			message.setUser(superAdmin);
			message.setChecked(0);
			message.setContent(tempPor.getApplicant().getRelname() + "申请的设备或耗材" + tempPor.getTempElement().getElementname() + "被" + user.getRelname() + "审核通过");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//删除该条临时申请
			tempPorService.deleteTempPor(tempPor);
		}
		jsonString = "{successd:true}";
		return SUCCESS;
	}
	
	public String refusePor(){
		String[] ids = selectIds.split(",");
		RefusePor refusePor = new RefusePor();
		TempPor tempPor;
		Message message = new Message();
		User user = userService.findUserById(session.get("id").toString());
		for(int i = 0; i < ids.length; i++){
			tempPor = tempPorService.findTempPorById(Integer.parseInt(ids[i]));
			//建立新的拒绝申购申请
			refusePor.setApplicant(tempPor.getApplicant());
			refusePor.setInfo(tempPor.getInfo());
			refusePor.setTempElement(tempPor.getTempElement());
			refusePor.setTime(tempPor.getTime());
			refusePor.setVerifier(user);
			refusePorService.addRefusePor(refusePor);
			//发送一条消息通知用户
			message.setUser(tempPor.getApplicant());
			message.setChecked(0);
			message.setContent("你对名称为【" + tempPor.getTempElement().getElementname() + "】的器件的申请已被管理员拒绝！");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//删除该条临时申购申请
			tempPorService.deleteTempPor(tempPor);
		}
		jsonString = "{successd:true}";
		return SUCCESS;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTempBorrowService(TempBorrowService tempBorrowService) {
		this.tempBorrowService = tempBorrowService;
	}

	public void setTempPorService(TempPorService tempPorService) {
		this.tempPorService = tempPorService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setPassPorService(PassPorService passPorService) {
		this.passPorService = passPorService;
	}

	public void setRefusePorService(RefusePorService refusePorService) {
		this.refusePorService = refusePorService;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setElementService(ElementService elementService) {
		this.elementService = elementService;
	}
}
