package com.techpark.cm.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.MessageDao;
import com.techpark.cm.domain.Message;

public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

	@Override
	public Message findMessageById(String id) {
		return (Message) getHibernateTemplate().load(Message.class, id);
	}

	@Override
	public void addMessage(Message message) {
		getHibernateTemplate().save(message);
	}
	
	@Override
	public void deleteMessageById(final String id) {
		getHibernateTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.createQuery("delete Message m where m.id='" + id + "'").executeUpdate();
				return 1;
			}
			
		});
	}

	@Override
	public void deleteMessage(Message message) {
		getHibernateTemplate().delete(message);
	}

	@Override
	public void modifyMessage(Message message) {
		getHibernateTemplate().update(message);
	}

	@Override
	public int findSizeByUserId(String userId) {
		int size = getHibernateTemplate().find("from Message m join fetch m.user where m.user.id='" + userId + "' and m.checked=0").size();
		return size;
	}
}
