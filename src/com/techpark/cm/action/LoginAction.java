package com.techpark.cm.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Message;
import com.techpark.cm.domain.User;
import com.techpark.cm.service.MessageService;
import com.techpark.cm.service.UserService;
import com.techpark.cm.utils.MD5Util;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	
	private User user;
	
	private UserService userService;
	
	private MessageService messageService;
	
	@Override
	public String execute() throws Exception {
		user.setPassword(MD5Util.encode(user.getPassword()));
		List<User> users = userService.login(user);
		if(users != null && !users.isEmpty()){
			user = users.get(0);
			
			if(user.getChecked() == 1){
				int messageSize = 0;
				Set<Message> messages = user.getMessages();
				for(Message message : messages){
					if(message.getChecked() == 0)
						messageSize++;
				}
				
				session.put("id", user.getId());
				session.put("username", user.getUsername());
				session.put("messageSize", messageSize);
				if(user.getPost().getId() == 1)
					return "super_success";
				else if(user.getPost().getId() == 2){
					messageSize = messageService.findSizeByUserId("0");
					session.put("messageSize", messageSize);
					return "admin_success";
				}
				else
					return "user_success";
			}else{
				session.put("loginError", user.getUsername() + "<br/>对不起，你的信息还没有通过审核！");
				return ERROR;
			}
		} else {
			session.put("loginError", user.getUsername() + "<br/>用户名或密码错误");
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
