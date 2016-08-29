package com.data.daoImp;


import org.hibernate.Session;

import com.data.HibernateUtil;
import com.data.dto.Person;





public class PersonManager {
	public static void main(String[] args) {
		test();
	}

	
	public static void test()
	{
		Person p1=new Person();
		p1.setFirstName("Hari");
		p1.setLastName("soni");
		p1.setAge(24);
		
		Session s1=HibernateUtil.getSessionFactory().openSession();
		s1.beginTransaction();
		s1.save(p1);
		s1.getTransaction().commit();
		s1.flush();
		s1.close();
		System.out.println("ssss done");
	
	}

}
