package com.techpark.cm.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String filename;
	
	private String jsonString;
	
	public InputStream getDownloadFile() throws Exception  {
		return ServletActionContext.getServletContext().getResourceAsStream("uploads/" + filename);
	}
	
	@Override
	public String execute() throws Exception {
		jsonString = "{success:true}";
		return SUCCESS;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getJsonString() {
		return jsonString;
	}
}
