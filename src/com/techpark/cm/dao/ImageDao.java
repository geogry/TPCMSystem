package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Image;

/**
 * ��ͼ�������в���
 * @author GJ
 *
 */
public interface ImageDao {

	/**
	 * �޸�ͼ����Ϣ
	 * @param image
	 */
	public void modify(Image image);
	
	/**
	 * ����ID�ҵ���Ӧ��ͼƬ
	 * @param id
	 * @return Image
	 */
	public Image findImageById(int id);
	
	/**
	 * ���ҵ�������ҳͼƬ
	 * @return List
	 */
	public List<Image> findAllImage();
}
