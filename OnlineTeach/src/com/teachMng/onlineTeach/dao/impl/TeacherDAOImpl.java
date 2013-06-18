package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.ITeacherDAO;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.util.HibernateUtil;
@Component("teacherDao")
public class TeacherDAOImpl implements ITeacherDAO {
	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> allTeacher() {
		// TODO Auto-generated method stub
		List<Teacher> list = null;
		String hql = "from Teacher";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return list;
	}

	@Override
	public Teacher findById(int tID) {
		Teacher teacher = null;
		String hql = "from Teacher where teacID=?";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		teacher = (Teacher)s.createQuery(hql).setInteger(0, tID).uniqueResult();
		//s.getTransaction().commit();
		return teacher;
	}

	@Override
	public boolean updTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(teacher);
		//s.getTransaction().commit();
		return true;
	}

}
