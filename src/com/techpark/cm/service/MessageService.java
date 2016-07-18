package com.techpark.cm.service;

import com.techpark.cm.domain.Message;

/**
 * ��Ϣ����
 * @author GJ
 *
 */
public interface MessageService {

	/**
	 * ����id��ȡ��Ϣ
	 * @param id
	 * @return Message
	 */
	public Message findMessageById(String id);
	
	/**
	 * �����û�ID��ȡ��Ϣ����
	 * @param id
	 * @return int
	 */
	public int findSizeByUserId(String UserId);
	
	/**
	 * �����Ϣ
	 * @param message
	 */
	public void addMessage(Message message);
	
	/**
	 * ɾ����Ϣ
	 * @param message
	 */
	public void deleteMessage(Message message);
	
	/**
	 * �޸���Ϣ
	 * @param message
	 */
	public void modifyMessage(Message message);
	
	/**
	 * ����idɾ����Ϣ
	 * @param id
	 */
	public void deleteMessageById(String id);
}
