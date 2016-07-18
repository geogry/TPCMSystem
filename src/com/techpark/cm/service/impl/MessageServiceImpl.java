package com.techpark.cm.service.impl;

import com.techpark.cm.dao.MessageDao;
import com.techpark.cm.domain.Message;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.MessageService;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao;
	
	@Override
	public Message findMessageById(String id) {
		try{
			return messageDao.findMessageById(id);
		} catch(Exception e){
			throw new AppException("��ѯID=��" + id + "������Ϣʧ�ܣ�");
		}
	}

	@Override
	public void addMessage(Message message) {
		try{
			messageDao.addMessage(message);
		} catch(Exception e){
			throw new AppException("�����Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteMessage(Message message) {
		try{
			messageDao.deleteMessage(message);
		} catch(Exception e){
			throw new AppException("ɾ��ID=��" + message.getId() + "��ʧ�ܣ�");
		}
	}

	@Override
	public void deleteMessageById(String id) {
		try{
			messageDao.deleteMessageById(id);
		} catch(Exception e){
			throw new AppException("ɾ��ID=��" + id + "��ʧ�ܣ�");
		}
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void modifyMessage(Message message) {
		messageDao.modifyMessage(message);
	}

	@Override
	public int findSizeByUserId(String userId) {
		return messageDao.findSizeByUserId(userId);
	}
}
