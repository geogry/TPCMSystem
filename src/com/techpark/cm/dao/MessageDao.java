package com.techpark.cm.dao;

import com.techpark.cm.domain.Message;

/**
 * 对消息表进行操作
 * @author GJ
 *
 */
public interface MessageDao {

	/**
	 * 按照id查找消息
	 * @param String
	 * @return Message
	 */
	public Message findMessageById(String id);
	
	/**
	 * 按照用户ID查找消息的数量
	 * @param String
	 * @return Message
	 */
	public int findSizeByUserId(String userId);
	
	/**
	 * 添加消息
	 * @param Message
	 */
	public void addMessage(Message message);
	
	/**
	 * 删除消息
	 * @param Message
	 */
	public void deleteMessage(Message message);
	
	/**
	 * 修改消息
	 * @param Message
	 */
	public void modifyMessage(Message message);
	
	/**
	 * 根据id删除消息
	 * @param String
	 */
	public void deleteMessageById(String id);
}
