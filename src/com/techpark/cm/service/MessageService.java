package com.techpark.cm.service;

import com.techpark.cm.domain.Message;

/**
 * 消息服务
 * @author GJ
 *
 */
public interface MessageService {

	/**
	 * 根据id获取消息
	 * @param id
	 * @return Message
	 */
	public Message findMessageById(String id);
	
	/**
	 * 根据用户ID获取消息数量
	 * @param id
	 * @return int
	 */
	public int findSizeByUserId(String UserId);
	
	/**
	 * 添加消息
	 * @param message
	 */
	public void addMessage(Message message);
	
	/**
	 * 删除消息
	 * @param message
	 */
	public void deleteMessage(Message message);
	
	/**
	 * 修改消息
	 * @param message
	 */
	public void modifyMessage(Message message);
	
	/**
	 * 根据id删除消息
	 * @param id
	 */
	public void deleteMessageById(String id);
}
