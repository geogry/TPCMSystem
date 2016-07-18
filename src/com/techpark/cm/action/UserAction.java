package com.techpark.cm.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Message;
import com.techpark.cm.domain.Post;
import com.techpark.cm.domain.User;
import com.techpark.cm.domain.UserDTO;
import com.techpark.cm.service.MessageService;
import com.techpark.cm.service.UserService;
import com.techpark.cm.utils.DateUtil;
import com.techpark.cm.utils.MD5Util;

public class UserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private User user;
	
	private List<User> users;
	
	private UserDTO userDTO;
	
	private String jsonString;
	
	private String selectIds;
	
	private UserService userService;
	
	private MessageService messageService;
	
	private Map<String, Object> session;

	public String addUser(){
		user.setChecked(0);
		user.setRegtime(DateUtil.dateFormat());
		user.setPassword(MD5Util.encode(user.getPassword()));
		userService.addUser(user);
		
		Message message = new Message();
		message.setChecked(0);
		message.setContent(user.getRelname() + "注册了自己的信息，请及时处理！");
		message.setTime(DateUtil.dateFormat());
		message.setUser(userService.findUserById("0"));
		messageService.addMessage(message);
		
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addAdmin(){
		user.setChecked(1);
		Post post = new Post();
		post.setId(2);
		post.setPostname("admin");
		user.setPost(post);
		user.setRegtime(DateUtil.dateFormat());
		user.setPassword(MD5Util.encode(user.getPassword()));
		user.setPassBorrows(null);
		user.setMessages(null);
		user.setPassPors(null);
		user.setRefuseBorrows(null);
		user.setRefusePors(null);
		user.setTempBorrows(null);
		user.setTempPors(null);
		userService.addUser(user);
		user = null;
		
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String deleteUser(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			user = userService.findUserById(ids[i]);
			if(user != null)
				userService.deleteUser(user);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String showUser(){
		user = userService.findUserById(session.get("id").toString());
		
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
		
		JSONArray jsonData = JSONArray.fromObject(user, cfg);
		jsonString = "{success:true,totalCount:1,list:" + jsonData.toString() + "}";
		return SUCCESS;
	}
	
	public String modifyUser(){
		userService.modifyUser(user);
		
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String modifyPass(){
		user = userService.findUserById(session.get("id").toString());
		if(user.getPassword().equals(MD5Util.encode(userDTO.getPrepass()))){
			user.setPassword(MD5Util.encode(userDTO.getNewpass()));
			userService.modifyUser(user);
			jsonString = "{success:true}";
		} else {
			jsonString = "{success:false, errorMessage:'原始密码错误，请重新输入！'}";
		}
		return SUCCESS;
	}
	
	public String showUsers(){
		users = userService.findAllUser();
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
	
	public String showAdmins(){
		users = userService.findAllAdmin();
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getJsonString() {
		return jsonString;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}
}
