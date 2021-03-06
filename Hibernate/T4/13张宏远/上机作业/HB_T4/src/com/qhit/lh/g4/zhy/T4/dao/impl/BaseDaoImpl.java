/**
 * 
 */
package com.qhit.lh.g4.zhy.T4.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import com.qhit.lh.g4.zhy.T4.dao.BaseDao;
import com.qhit.lh.g4.zhy.T4.util.HibernateSessionFactory;

/**
 * @author 张宏远
 * 2017年12月16日下午8:23:14
 * TODO
 */
public class BaseDaoImpl implements BaseDao {
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx=session.beginTransaction();

	private List<Object> list=new ArrayList<Object>();

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.zhy.t4.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		session.save(object);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.zhy.t4.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		session.delete(object);
		tx.commit();
		HibernateSessionFactory.closeSession();

	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.zhy.t4.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		session.update(object);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.zhy.t4.dao.BaseDao#getObjectById(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public Object getObjectById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		Object object=session.get(clazz, id);
		return object;
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.zhy.t4.dao.BaseDao#queryAll(java.lang.String)
	 */
	@Override
	public List<Object> queryAll(String sql) {
		// TODO Auto-generated method stub
		list=session.createQuery(sql).list();
		tx.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}

}
