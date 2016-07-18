package com.techpark.cm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Message;
import com.techpark.cm.domain.User;
import com.techpark.cm.service.MessageService;
import com.techpark.cm.service.UserService;

public class MessageAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private User user;
	
	private String selectIds;
	
	private String jsonString;
	
	private MessageService messageService;
	
	private List<Message> messages;
	
	private UserService userService;
	
	private Map<String, Object> session;
	
	public String deleteMessage(){
		String[] ids = selectIds.split(",");
		
		for(int i = 0; i < ids.length; i++){
			messageService.deleteMessageById(ids[i]);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String showOldMessage(){
		user = userService.findUserById(session.get("id").toString());
		if(user.getPost().getId() == 2)
			user = userService.findUserById("0");
		messages = new ArrayList<Message>();
		for(Message message : user.getMessages()){
			if(message.getChecked() == 1)
				messages.add(message);
		}
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("user"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(messages, cfg);
		jsonString = "{success:true,totalCount:" + messages.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showNewMessage(){
		user = userService.findUserById(session.get("id").toString());
		if(user.getPost().getId() == 2)
			user = userService.findUserById("0");
		messages = new ArrayList<Message>();
		for(Message message : user.getMessages()){
			if(message.getChecked() == 0)
				messages.add(message);
		}
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("user"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(messages, cfg);
		jsonString = "{success:true,totalCount:" + messages.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String checkMessage(){
		String[] ids = selectIds.split(",");
		Message message;
		for(int i = 0; i < ids.length; i++){
			message = messageService.findMessageById(ids[i]);
			message.setChecked(1);
			messageService.modifyMessage(message);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String getJsonString() {
		return jsonString;
	}

	public String getSelectIds() {
		return selectIds;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
