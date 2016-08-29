package com.data;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;

import com.data.dto.Student;


public class StudentManager {
	
	private static Session session=null;
	
	public static List<Student> getStudentDetails(int studId){
		
		session=HibernateUtil.currentSession();
		Query query=session.getNamedQuery("call_GetStudentDetails_procedure").setParameter("studId", studId);
		
		List<Student> studentList=query.list(); 
		 return studentList;
	}
	public static void main(String[] args) {
		getStudentDetails(1);
	}
}
