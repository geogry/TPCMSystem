package com.techpark.cm.dao;

import com.techpark.cm.domain.Message;

/**
 * ����Ϣ����в���
 * @author GJ
 *
 */
public interface MessageDao {

	/**
	 * ����id������Ϣ
	 * @param String
	 * @return Message
	 */
	public Message findMessageById(String id);
	
	/**
	 * �����û�ID������Ϣ������
	 * @param String
	 * @return Message
	 */
	public int findSizeByUserId(String userId);
	
	/**
	 * �����Ϣ
	 * @param Message
	 */
	public void addMessage(Message message);
	
	/**
	 * ɾ����Ϣ
	 * @param Message
	 */
	public void deleteMessage(Message message);
	
	/**
	 * �޸���Ϣ
	 * @param Message
	 */
	public void modifyMessage(Message message);
	
	/**
	 * ����idɾ����Ϣ
	 * @param String
	 */
	public void deleteMessageById(String id);
}
