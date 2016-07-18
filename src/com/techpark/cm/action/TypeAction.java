package com.techpark.cm.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Type;
import com.techpark.cm.domain.User;
import com.techpark.cm.service.TypeService;

public class TypeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Type type;

	private List<Type> types;
	
	private String selectIds;

	private String jsonString;
	
	private TypeService typeService;
	
	public String showTypes(){
		types = typeService.findAllType();
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("elements") || name.equals("tempElements"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(types, cfg);
		jsonString = "{success:true, totalCount:" + types.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String deleteType(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			type = typeService.findTypeById(ids[i]);
			if(type != null)
				typeService.deleteType(type);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addType(){
		if(type != null && !type.getId().equals("")){
			type.setElements(null);
			typeService.addType(type);
			type = null;
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}
}
