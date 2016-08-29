/*
 * Created on Sep 21, 2005
 */
package com.candidate.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HSONI 
 *
 * TODO Discribe the class / interface here
 */
public class Store extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	Connection con=null;
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	//data base variable
	Statement stmt=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//get the data from feedbackservlet 
		String candidate_name=request.getParameter("cname");
		String candidate_id=request.getParameter("candidate_id");

		String skill_1=request.getParameter("skill_1");
		String rating_1=request.getParameter("rating_1");
		String remark_1=request.getParameter("remark_1");
		
		String skill_2=request.getParameter("skill_2");
		String rating_2=request.getParameter("rating_2");
		String remark_2=request.getParameter("remark_2");
		
		String skill_3=request.getParameter("skill_3");
		String rating_3=request.getParameter("rating_3");
		String remark_3=request.getParameter("remark_3");
		
		String skill_4=request.getParameter("skill_4");
		String rating_4=request.getParameter("rating_4");
		String remark_4=request.getParameter("remark_4");
		
		String skill_5=request.getParameter("skill_5");
		String rating_5=request.getParameter("rating_5");
		String remark_5=request.getParameter("remark_5");
				
		String status=request.getParameter("status");
		String conducted_by=request.getParameter("conducted_by");
		String comments=request.getParameter("comments");
		
		String query1= "update status set status='"+status+"', updatedby='"+conducted_by+"' where Candidate_id='"+candidate_id+"'";

//		 loading the data base
		try{
		stmt=con.createStatement();
		stmt.executeUpdate(query1);
		
		//delete the previous result in skill table
		String str = "delete from skills where Candidate_id='"+candidate_id+"'";
		stmt.executeUpdate(str);
			
		String str1="insert into Skills(Skill_ID,Candidate_ID,Skill,Rating,Remark)"
			+ "values(Skills_S.nextval,'"+candidate_id+"','"+skill_1+"','"+rating_1+"','"+remark_1+"')";
		stmt.executeUpdate(str1);
		
		String str2="insert into Skills(Skill_ID,Candidate_ID,Skill,Rating,Remark)"
			+ "values(Skills_S.nextval,'"+candidate_id+"','"+skill_2+"','"+rating_2+"','"+remark_2+"')";
		stmt.executeUpdate(str2);
		
		String str3="insert into Skills(Skill_ID,Candidate_ID,Skill,Rating,Remark)"
			+ "values(Skills_S.nextval,'"+candidate_id+"','"+skill_3+"','"+rating_3+"','"+remark_3+"')";
		stmt.executeUpdate(str3);
		
		String str4="insert into Skills(Skill_ID,Candidate_ID,Skill,Rating,Remark)"
			+ "values(Skills_S.nextval,'"+candidate_id+"','"+skill_4+"','"+rating_4+"','"+remark_4+"')";
		stmt.executeUpdate(str4);
		
		String str5="insert into Skills(Skill_ID,Candidate_ID,Skill,Rating,Remark)"
			+ "values(Skills_S.nextval,'"+candidate_id+"','"+skill_5+"','"+rating_5+"','"+remark_5+"')";
		stmt.executeUpdate(str5);
		
		// update the table candidate by commit
		String query="update candidate set comments='"+comments+"'where Candidate_id='"+candidate_id+"'";
		stmt.executeUpdate(query);
		String qu="update status set status='"+status+", updatedby='"+conducted_by+"'where Candidate_id='"+candidate_id+"'";
		stmt.executeUpdate(qu);
		}
		catch(Exception e)
		{System.out.println(e);
		}
		
		finally{
			try{
				if(stmt!=null)
				stmt.close();
				
				
			}catch(SQLException e){}
		}
		  RequestDispatcher rd= request.getRequestDispatcher("../views/candidate/header.jsp");
		    rd.include(request, response);
		out.println("<html><div id='lypsum'><body>Record Updated Successfully <br><br>");
		out.println("<a href='../views/candidate/search.jsp'>Back to Search Page</a>");
		out.println("</body></div></html>");
		 rd= request.getRequestDispatcher("../views/candidate/footer.jsp");
		    rd.include(request, response);
	}

				
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","soni","root123");
			}
		catch(Exception e){
				System.out.println(e);
			}
		}
	
}
