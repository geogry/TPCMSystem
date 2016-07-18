package com.techpark.cm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Element;
import com.techpark.cm.domain.Locker;
import com.techpark.cm.domain.Type;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.ElementService;
import com.techpark.cm.service.LockerService;
import com.techpark.cm.service.TypeService;

public class ElementAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Element element;
	
	private File img;
	
	private String imgFileName;
	
	private File manual;
	
	private String manualFileName;
	
	private String selectIds;
	
	private List<Element> elements;
	
	private ElementService elementService;
	
	private TypeService typeService;
	
	private LockerService lockerService;
	
	private String jsonString;
	
	public String showElementDetail(){
		element = elementService.findElementById(element.getId());
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("tempElements") || name.equals("elements"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(element, cfg);
		jsonString = "{success:true,totalCount:1,list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showElements(){
		elements = elementService.findAllElement();
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("tempElements") || name.equals("elements"))
					return true;
				else
					return false;
			}
			
		});
		JSONArray jsonArray = JSONArray.fromObject(elements, cfg);
		jsonString = "{success:true,totalCount:" + elements.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String deleteElement(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		String[] ids = selectIds.split(",");
		File image = null;
		File manual = null;
		for(int i = 0; i < ids.length; i++){
			element = elementService.findElementById(ids[i]);
			if(element != null){
				image = new File(realPath + "/" + element.getImg());
				manual = new File(realPath + "/" + element.getManual());
				if(image.exists())
					image.delete();
				if(manual.exists())
					image.delete();
				elementService.deleteElement(element);
			}
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addElement(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		if(img != null && !"".equals(imgFileName)){
			String imgName = UUID.randomUUID().toString() + imgFileName.substring(imgFileName.indexOf("."));
			File imgDist = new File(new File(realPath), imgName);
			if(!imgDist.getParentFile().exists()){
				imgDist.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(img, imgDist);
				element.setImg(imgName);
			} catch (IOException e) {
				e.printStackTrace();
				jsonString = "{failure:true,errorMessage:'图片上传失败！'}";
				throw new AppException("图片上传失败！");
			}
		}
		//struts上传非图片文件只能使用此方法
		if(manual != null && !"".equals(manualFileName)){
			String manualName = UUID.randomUUID().toString() + manualFileName.substring(manualFileName.indexOf("."));
			File manualDist = new File(new File(realPath), manualName);
			if(!manualDist.getParentFile().exists()){
				manualDist.getParentFile().mkdirs();
			}
			try {
				//FileUtils.copyFile(img, manualDist);
				InputStream in = new FileInputStream(manual);
				OutputStream out = new FileOutputStream(realPath + "/" + manualName);
				byte[] buffer = new byte[8192];
				int count = 0;
				while((count = in.read(buffer)) > 0){
					out.write(buffer, 0, count);
				}
				out.close();
				in.close();
				element.setManual(manualName);
			} catch (IOException e) {
				e.printStackTrace();
				jsonString = "{failure:true,errorMessage:'手册上传失败！'}";
				throw new AppException("手册上传失败！");
			}
		}
		Type type = typeService.findTypeById(element.getType().getId());
		element.setType(type);
		Locker locker = lockerService.findLockerById(element.getLocker().getId());
		element.setLocker(locker);
		elementService.addElement(element);
		element = null;
		
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String intoStore(){
		Locker locker = lockerService.findLockerById(element.getLocker().getId());
		element.setLocker(locker);
		element.setStore(0);
		elementService.addElement(element);
		
		jsonString = "{success:true}";
		return SUCCESS;
	}

	public void setElementService(ElementService elementService) {
		this.elementService = elementService;
	}

	public String getJsonString() {
		return jsonString;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public File getManual() {
		return manual;
	}

	public void setManual(File manual) {
		this.manual = manual;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public void setManualFileName(String manualFileName) {
		this.manualFileName = manualFileName;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public String getManualFileName() {
		return manualFileName;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public void setLockerService(LockerService lockerService) {
		this.lockerService = lockerService;
	}
}
