package com.techpark.cm.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Locker;
import com.techpark.cm.service.LockerService;

public class LockerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Locker locker;
	
	private List<Locker> lockers;
	
	private String jsonString;
	
	private String selectIds; 
	
	private LockerService lockerService;

	public String showLockers(){
		lockers = lockerService.findAllLocker();
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("elements"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(lockers, cfg);
		jsonString = "{success:true,totalCount:" + lockers.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String deleteLocker(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			locker = lockerService.findLockerById(ids[i]);
			if(locker != null)
				lockerService.deleteLocker(locker);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addLocker(){
		if(locker != null && !locker.getId().equals("")){
			locker.setElements(null);
			locker.setNowcapacity(0);
			lockerService.addLocker(locker);
			locker = null;
		}
		jsonString = "{success:true}";
		return SUCCESS;
	} 
	
	public String getJsonString() {
		return jsonString;
	}

	public void setLockerService(LockerService lockerService) {
		this.lockerService = lockerService;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}
}
