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
			//�����µ�ͨ��������Ϣ
			passBorrow.setApplicant(tempBorrow.getApplicant());
			passBorrow.setCount(tempBorrow.getCount());
			passBorrow.setElement(tempBorrow.getElement());
			passBorrow.setPurpose(tempBorrow.getPurpose());
			passBorrow.setTime(tempBorrow.getTime());
			if(tempBorrow.getElement().getType().getIselement() == 1)
				//���������豸���ͣ�����Ҫ�黹����-1��������
				passBorrow.setReturned(-1);
			else
				//�������ǺĲ����ͣ���Ҫ�黹�����ѹ黹��־����Ϊδ�黹0
				passBorrow.setReturned(0);
			passBorrow.setVerifier(user);
			passBorrowService.addPassBorrow(passBorrow);
			//�޸Ŀ��
			tempBorrow.getElement().setStore(tempBorrow.getElement().getStore() - tempBorrow.getCount());
			elementService.modifyElement(tempBorrow.getElement());
			//����һ����Ϣ�������û�
			message.setUser(tempBorrow.getApplicant());
			message.setChecked(0);
			message.setContent("�������Ϊ��" + tempBorrow.getElement().getElementname() + "����������������ͨ������Ա��ˣ����Ե��ֿ���ȡ��");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			
			//��������ʱ����ɾ��
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
			//�����µľܾ�����
			refuseBorrow.setApplicant(tempBorrow.getApplicant());
			refuseBorrow.setCount(tempBorrow.getCount());
			refuseBorrow.setElement(tempBorrow.getElement());
			refuseBorrow.setPurpose(tempBorrow.getPurpose());
			refuseBorrow.setTime(tempBorrow.getTime());
			refuseBorrow.setVerifier(user);
			refuseBorrowService.addRefuseBorrow(refuseBorrow);
			//����һ����Ϣ֪ͨ�û�
			message.setUser(tempBorrow.getApplicant());
			message.setChecked(0);
			message.setContent("�������Ϊ��" + tempBorrow.getElement().getElementname() + "���������������ѱ�����Ա�ܾ���");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//ɾ����������
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
			//�����µ�ͨ���깺����
			passPor.setApplicant(tempPor.getApplicant());
			passPor.setInfo(tempPor.getInfo());
			passPor.setTempElement(tempPor.getTempElement());
			passPor.setTime(tempPor.getTime());
			passPor.setVerifier(user);
			passPorService.addPassPor(passPor);
			//����һ����Ϣ֪ͨ�û�
			message.setUser(tempPor.getApplicant());
			message.setChecked(0);
			message.setContent("�������Ϊ��" + tempPor.getTempElement().getElementname() + "����������������ͨ������Ա��ˣ������ڴ���");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//����һ����Ϣ֪ͨ��������Ա
			User superAdmin = userService.findUserById("1001");
			message.setUser(superAdmin);
			message.setChecked(0);
			message.setContent(tempPor.getApplicant().getRelname() + "������豸��Ĳ�" + tempPor.getTempElement().getElementname() + "��" + user.getRelname() + "���ͨ��");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//ɾ��������ʱ����
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
			//�����µľܾ��깺����
			refusePor.setApplicant(tempPor.getApplicant());
			refusePor.setInfo(tempPor.getInfo());
			refusePor.setTempElement(tempPor.getTempElement());
			refusePor.setTime(tempPor.getTime());
			refusePor.setVerifier(user);
			refusePorService.addRefusePor(refusePor);
			//����һ����Ϣ֪ͨ�û�
			message.setUser(tempPor.getApplicant());
			message.setChecked(0);
			message.setContent("�������Ϊ��" + tempPor.getTempElement().getElementname() + "���������������ѱ�����Ա�ܾ���");
			message.setTime(DateUtil.dateFormat());
			messageService.addMessage(message);
			//ɾ��������ʱ�깺����
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
