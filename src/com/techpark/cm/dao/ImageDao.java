package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Image;

/**
 * 对图像对象进行操作
 * @author GJ
 *
 */
public interface ImageDao {

	/**
	 * 修改图像信息
	 * @param image
	 */
	public void modify(Image image);
	
	/**
	 * 根据ID找到相应的图片
	 * @param id
	 * @return Image
	 */
	public Image findImageById(int id);
	
	/**
	 * 查找到所有首页图片
	 * @return List
	 */
	public List<Image> findAllImage();
}
