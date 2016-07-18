package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Image;

/**
 * ͼ�������
 * @author GJ
 *
 */
public interface ImageService {

	/**
	 * �޸�ͼ����Ϣ
	 * @param image
	 */
	public void modify(Image image);
	
	/**
	 * ͨ��ID����ͼ�����
	 * @param id
	 * @return Image
	 */
	public Image findImageById(int id);
	
	/**
	 * ��������ͼ�����
	 * @return List
	 */
	public List<Image> findAllImage();
}
