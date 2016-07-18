package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Image;

/**
 * 图像处理服务
 * @author GJ
 *
 */
public interface ImageService {

	/**
	 * 修改图像信息
	 * @param image
	 */
	public void modify(Image image);
	
	/**
	 * 通过ID查找图像对象
	 * @param id
	 * @return Image
	 */
	public Image findImageById(int id);
	
	/**
	 * 查找所有图像对象
	 * @return List
	 */
	public List<Image> findAllImage();
}
