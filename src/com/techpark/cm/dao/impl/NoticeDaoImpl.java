package com.techpark.cm.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.NoticeDao;
import com.techpark.cm.domain.Notice;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	@Override
	public Notice findNoticeById(String id) {
		return (Notice) getHibernateTemplate().get(Notice.class, id);
	}

	@Override
	public List<Notice> findAllNotice() {
		return getHibernateTemplate().find("from Notice");
	}
	
	@Override
	public List<Notice> findPageNotice(final int start, final int count) {
		List<Notice> notices = new ArrayList<Notice>();
		notices = (List<Notice>) getHibernateTemplate().executeFind(new HibernateCallback(){
 
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("from Notice n order by n.time DESC")
								.setFirstResult((start - 1) * count)
								.setMaxResults(count).list();
			}
			
		});
		return notices;
		//return getHibernateTemplate().find("from Notice n order by n.time DESC");
	}

	@Override
	public void addNotice(Notice notice) {
		getHibernateTemplate().save(notice);
	}

	@Override
	public void deleteNotice(Notice notice) {
		getHibernateTemplate().delete(notice);
	}

	@Override
	public void deleteNoticeById(final String id) {
		getHibernateTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("delete from User u where u.id='" + id + "'");
			}
			
		});
	}
}
