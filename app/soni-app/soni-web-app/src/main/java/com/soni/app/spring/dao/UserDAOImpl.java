package com.soni.app.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.soni.app.spring.bean.User;



@Repository
@Transactional
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	@Override
	public List<User> findAllUsers() {
     
		Session session=this.sessionFactory.getCurrentSession();
		List<User> userList=session.createQuery("from User").list();
		for(User p : userList){
			logger.info("User List::"+p);
		}
		
		
		return userList;
	}
	
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		Session session= this.sessionFactory.getCurrentSession();
		User user=(User)session.load(User.class, new Long(id));
		logger.info("User loaded successfully, User details="+user);
		return user;
	}
	
	@Override
	public User findByName(String name) {
	  Session session=this.sessionFactory.getCurrentSession();
	  User user=(User)session.load(User.class, name);
	  logger.info("User loaded successfully, User details="+user);
		return user;
	}
	
	
	@Override
	public void saveUser(User user) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details="+user);
	}
	
	@Override
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, User Details="+user);
		
	}
	
	@Override
	public void deleteUserById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long(id));
		if(null != user){
			session.delete(user);
		}
		logger.info("User deleted successfully, User details="+user);
		
	}
	
	@Override
	public void deleteAllUsers() {
	Session session=this.sessionFactory.getCurrentSession();
	session.clear();
		
	}	
	
	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
