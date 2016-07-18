package com.techpark.cm.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Image;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.ImageService;

public class ImageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private File img;
	
	private String imgFileName;
	
	private String imageId;
	
	private List<Image> images;
	
	private String jsonString;
	
	private ImageService imageService;

	@Override
	public String execute() throws Exception {
		String realPath = ServletActionContext.getServletContext().getRealPath("/image");
		String imgName = UUID.randomUUID().toString() + ".png";
		if(img != null && !"".equals(imgFileName)){
			Image image = imageService.findImageById(Integer.parseInt(imageId));
			File imgSrc = new File(new File(realPath), image.getImagename());
			if(imgSrc.exists())
				imgSrc.delete();
			File imgDist = new File(new File(realPath), imgName);
			if(!imgDist.getParentFile().exists()){
				imgDist.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(img, imgDist);
				image.setImagename(imgName);
				imageService.modify(image);
			} catch (IOException e) {
				e.printStackTrace();
				jsonString = "{failure:true,errorMessage:'Í¼Æ¬ÉÏ´«Ê§°Ü£¡'}";
				throw new AppException("Í¼Æ¬ÉÏ´«Ê§°Ü£¡");
			}
		}
		
		jsonString = "{success:true, imageName:'" + imgName + "'}";
		return SUCCESS;
	}
	
	public String showAllImage(){
		images = imageService.findAllImage();
		JSONArray jsonArray = JSONArray.fromObject(images);
		jsonString = "{success:true, totalCount:5, list:" + jsonArray.toString() + "}";
		return SUCCESS;
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

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
}
