package com.data.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.data.HibernateUtil;
import com.data.dto.Survey;

public class SurveyManager {
public static void main(String[] args) throws Exception{
	
	String sql="create table survey(id int,name varchar2(23)";
	//hibernateUtil.executeSqlCommand(sql);
	SessionFactory sf =HibernateUtil.getSessionFactory();
	Session session=sf.openSession();
	Survey survey=new Survey();
	survey.setName("survey");
	System.out.println(survey.getId());
	session.beginTransaction();
	session.save(survey);
    
	session.getTransaction().commit();
	session.flush();
	
	System.out.println(survey.getId());
	Survey srveyInSession=(Survey)session.get(Survey.class,survey.getId());
	
	System.out.println(srveyInSession.getName());
	session.close();
	
}
}
