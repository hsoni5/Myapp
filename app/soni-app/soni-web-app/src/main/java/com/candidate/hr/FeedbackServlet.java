/*
 * Created on Sep 21, 2005
 */
package com.candidate.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;


/**
 * @author HSONI 
 *
 * TODO Discribe the class / interface here
 */
public class FeedbackServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	
	Connection con = null;
	
	public void destroy() {
		try{
			con.close();
		}catch(Exception e){System.out.println(e);}
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		String name = null;
		String comments = null;
		Statement stmt = null;
		Statement stmt2 = null;
		ResultSet result =null;
		ResultSet result2 =null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String candidate_id = request.getParameter("candidate_id");
		request.setAttribute("candidate_id",candidate_id);
		try{
			stmt=con.createStatement();
			String query="select Name,comments from Candidate where Candidate_ID='"+candidate_id+"'";
			result=stmt.executeQuery(query);
			while(result.next()){
				name=result.getString("name");
			    comments=result.getString("comments");
			}

			request.setAttribute("comments",comments);
			request.setAttribute("name",name);
			String query1 ="select Skil_ID,Skills,Rating,Remark from Skills where Candidate_ID='"+candidate_id+"'";
			result = stmt.executeQuery(query1);	
		
			ArrayList skill_list = new ArrayList();
			while(result.next()){
				Skills sk = new Skills();
				sk.setSkill_id("skill_id");
				sk.setSkill(result.getString("skills"));
				sk.setRating(result.getString("rating"));
				sk.setRemark(result.getString("remark"));
				skill_list.add(sk);
			}

			request.setAttribute("skill_list",skill_list);
			stmt2=con.createStatement();
			String query2 ="select Status,Updatedby from Status where Candidate_ID='"+candidate_id+"'";
			result2 = stmt2.executeQuery(query2);

			ArrayList status_list= new ArrayList();
			while(result2.next()){
				Status st = new Status();
				st.setStatus(result2.getString("Status"));
				st.setUpdatedby(result2.getString("Updatedby"));
				status_list.add(st);
			}
			request.setAttribute("status_list",status_list);	
		}
		catch(SQLException se){
			System.out.println("error is "+se);
		    }
		finally{
			try {
				if(stmt != null)
					stmt.close();
				if(stmt2 != null)
					stmt2.close();
				if(result != null)
					result.close();
				if(result2 != null)
					result2.close();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		RequestDispatcher rd=request.getRequestDispatcher("../views/candidate/CallFeedback.jsp");
		rd.include(request,response);
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
			}catch(Exception e){
			System.out.println(e);}
			}
	}


