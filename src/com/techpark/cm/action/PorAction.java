package com.techpark.cm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Message;
import com.techpark.cm.domain.PassPor;
import com.techpark.cm.domain.RefuseBorrow;
import com.techpark.cm.domain.RefusePor;
import com.techpark.cm.domain.TempElement;
import com.techpark.cm.domain.TempPor;
import com.techpark.cm.domain.Type;
import com.techpark.cm.domain.User;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.MessageService;
import com.techpark.cm.service.PassPorService;
import com.techpark.cm.service.RefusePorService;
import com.techpark.cm.service.TempElementService;
import com.techpark.cm.service.TempPorService;
import com.techpark.cm.service.TypeService;
import com.techpark.cm.service.UserService;
import com.techpark.cm.utils.DateUtil;

public class PorAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private TempPor tempPor;
	
	private User user;
	
	private TempElement tempElement;
	
	private File img;
	
	private String imgFileName;
	
	private File manual;
	
	private String manualFileName;
	
	private List<PassPor> passPors;
	
	private List<RefusePor> refusePors;
	
	private String jsonString;
	
	private String selectIds;
	
	private Map<String, Object> session;
	
	private UserService userService;
	
	private TempPorService tempPorService;
	
	private MessageService messageService;
	
	private RefusePorService refusePorService;
	
	private PassPorService passPorService;
	
	private TempElementService tempElementService;
	
	private TypeService typeService;

	public String por(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		if(img != null && !"".equals(imgFileName)){
			String imgName = UUID.randomUUID().toString() + imgFileName.substring(imgFileName.indexOf("."));
			File imgDist = new File(new File(realPath), imgName);
			if(!imgDist.getParentFile().exists()){
				imgDist.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(img, imgDist);
				tempElement.setImg(imgName);
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
				tempElement.setManual(manualName);
			} catch (IOException e) {
				e.printStackTrace();
				jsonString = "{failure:true,errorMessage:'手册上传失败！'}";
				throw new AppException("手册上传失败！");
			}
		}
		Type type = typeService.findTypeById(tempElement.getType().getId());
		tempElement.setType(type);
		tempElementService.addTempElement(tempElement);
		
		user = userService.findUserById(session.get("id").toString());
		tempPor.setApplicant(user);
		tempPor.setTime(DateUtil.dateFormat());
		tempPor.setTempElement(tempElement);
		tempPorService.addTempPor(tempPor);
		
		Message message = new Message();
		message.setChecked(0);
		message.setTime(DateUtil.dateFormat());
		message.setContent(user.getRelname() + "提出了购买申请，请查看详情并及时处理！");
		message.setUser(userService.findUserById("0"));
		messageService.addMessage(message);
		
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String showTempPors(){
		user = userService.findUserById(session.get("id").toString());
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
		JSONArray jsonArray = JSONArray.fromObject(user.getTempPors(), cfg);
		jsonString = "{success:true,totalCount:" + user.getTempPors().size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showAllPassPors(){
		passPors = passPorService.findAllPassPor();
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
		JSONArray jsonArray = JSONArray.fromObject(passPors, cfg);
		jsonString = "{success:true,totalCount:" + passPors.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showPassPors(){
		passPors = passPorService.findPassPorByUserId(session.get("id").toString());
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
		JSONArray jsonArray = JSONArray.fromObject(passPors, cfg);
		jsonString = "{success:true,totalCount:" + passPors.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showAllRefusePors(){
		refusePors = refusePorService.findAllRefusePor();
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
		JSONArray jsonArray = JSONArray.fromObject(refusePors, cfg);
		jsonString = "{success:true,totalCount:" + refusePors.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String showRefusePors(){
		refusePors = refusePorService.findRefusePorByUserId(session.get("id").toString());
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
		JSONArray jsonArray = JSONArray.fromObject(refusePors, cfg);
		jsonString = "{success:true,totalCount:" + refusePors.size() + ", list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String deleteRefusePor(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		String[] ids = selectIds.split(",");
		RefusePor refusePor;
		File image = null;
		File manual = null;
		for(int i = 0; i < ids.length; i++){
			refusePor = refusePorService.findRefusePorById(Integer.parseInt(ids[i]));
			if(refusePor != null){
				image = new File(realPath + "/" + refusePor.getTempElement().getImg());
				manual = new File(realPath + "/" + refusePor.getTempElement().getManual());
				if(image.exists())
					image.delete();
				if(manual.exists())
					image.delete();
				refusePorService.deleteRefusePor(refusePor);
			}
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String deletePassPor(){
		String[] ids = selectIds.split(",");
		PassPor passPor;
		for(int i = 0; i < ids.length; i++){
			passPor = passPorService.findPassPorById(Integer.parseInt(ids[i]));
			if(passPor != null){
				passPorService.deletePassPor(passPor);
			}
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String deleteTempPor(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		String[] ids = selectIds.split(",");
		TempPor tempPor;
		File image = null;
		File manual = null;
		boolean flag = false;
		for(int i = 0; i < ids.length; i++){
			tempPor = tempPorService.findTempPorById(Integer.parseInt(ids[i]));
			if(tempPor != null){
				image = new File(realPath + "/" + tempPor.getTempElement().getImg());
				manual = new File(realPath + "/" + tempPor.getTempElement().getManual());
				if(image.exists())
					image.delete();
				if(manual.exists())
					image.delete();
				tempPorService.deleteTempPor(tempPor);
				tempElementService.deleteTempElement(tempPor.getTempElement());
			}else
				flag = true;
		}
		if(flag)
			jsonString = "{success:false}";
		else
			jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public TempPor getTempPor() {
		return tempPor;
	}

	public void setTempPor(TempPor tempPor) {
		this.tempPor = tempPor;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public File getManual() {
		return manual;
	}

	public void setManual(File manual) {
		this.manual = manual;
	}

	public String getManualFileName() {
		return manualFileName;
	}

	public void setManualFileName(String manualFileName) {
		this.manualFileName = manualFileName;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTempPorService(TempPorService tempPorService) {
		this.tempPorService = tempPorService;
	}

	public TempElement getTempElement() {
		return tempElement;
	}

	public void setTempElement(TempElement tempElement) {
		this.tempElement = tempElement;
	}

	public void setTempElementService(TempElementService tempElementService) {
		this.tempElementService = tempElementService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setRefusePorService(RefusePorService refusePorService) {
		this.refusePorService = refusePorService;
	}

	public void setPassPorService(PassPorService passPorService) {
		this.passPorService = passPorService;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}
}
