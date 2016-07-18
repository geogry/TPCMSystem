package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.ImageDao;
import com.techpark.cm.domain.Image;
import com.techpark.cm.exception.AppException;

public class ImageServiceImpl implements com.techpark.cm.service.ImageService {

	private ImageDao imageDao;
	
	@Override
	public void modify(Image image) {
		try {
			imageDao.modify(image);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("修改图片信息失败！");
		}
	}

	@Override
	public Image findImageById(int id) {
		try {
			return imageDao.findImageById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找ID=【" + id + "】的图片信息失败！");
		}
	}

	@Override
	public List<Image> findAllImage() {
		try {
			return imageDao.findAllImage();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有图片失败！");
		}
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
}
