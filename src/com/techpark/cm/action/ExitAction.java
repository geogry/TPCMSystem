package com.techpark.cm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	@Override
	public String execute() throws Exception {
		session.remove("id");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
