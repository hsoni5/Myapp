package com.soni.app.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soni.app.spring.bean.User;
import com.soni.app.spring.dao.UserDAO;



@Service("userService")

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	
	private static List<User> users;
	

	public UserDAO getuserDAO() {
		return userDAO;
	}

	public void setuserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		UserServiceImpl.users = users;
	}
	@Transactional
	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}
	
	public User findById(long id) {
		
		return userDAO.findById(id);
	}
	
	public User findByName(String name) {
		
		return userDAO.findByName(name);
	}
	
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUserById(long id) {
		
		userDAO.deleteUserById(id);
	}

	public boolean isUserExist(User user) {
		return false ;
		
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	

}
