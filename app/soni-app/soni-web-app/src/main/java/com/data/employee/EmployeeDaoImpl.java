package com.data.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author Hari Soni
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

 @Autowired
 private SessionFactory sessionFactory;
 Session session=null;
 Transaction tx=null;
 
 public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

 
 public void addEmployee(Employee employee) {
   session= sessionFactory.openSession();
   tx=session.beginTransaction();
   session.saveOrUpdate(employee);
   tx.commit();
   session.close();
   
   
 }

 @SuppressWarnings("unchecked")
 public List<Employee> listEmployeess() {
	   session= sessionFactory.openSession();
	   tx=session.beginTransaction();
	   List<Employee> employees=session.createCriteria(Employee.class).list();
	   tx.commit();
	   session.close();
      return employees;
 }

 public Employee getEmployee(int empid) {
	 session= sessionFactory.openSession();
	   tx=session.beginTransaction();
	   Employee emp=(Employee)session.get(Employee.class, empid);
	   tx.commit();
	   session.close();
     return emp;
 }

 public void deleteEmployee(Employee employee) {
	 
	 session= sessionFactory.openSession();
	   tx=session.beginTransaction();
	   session.createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
	   tx.commit();
	   session.close();
      }
}

