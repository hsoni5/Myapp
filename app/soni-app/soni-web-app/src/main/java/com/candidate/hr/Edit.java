/*
 * Created on Sep 21, 2005
 */
package com.candidate.hr;
import java.sql.*;
import java.io.IOException;
//import java.io.PrintWriter;

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
public class Edit extends HttpServlet {
    Connection con=null;
	
	/**
	 * Destruction of the servlet. <br>
	 */
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

		String candidate_id=null;
		String name=null;
		String phone=null;
		String email=null;
		String source=null;
		String status=null;
		String reason=null;
		String resume=null;
		String updatedby=null;
		String lastUpdate=null;
		
		Statement stmt = null;
		ResultSet rs=null;
				
		candidate_id=request.getParameter("candidate_id");
		try{
			stmt=con.createStatement();
			String candidateq="select Name,Phone,Email,Source,Resume,Lastupdate from Candidate where Candidate_ID='"+candidate_id+"'";
			rs = stmt.executeQuery(candidateq);
			while(rs.next()){
				name=rs.getString("Name");
				phone=rs.getString("Phone");
				email=rs.getString("Email");	
				source=rs.getString("Source");
				resume=rs.getString("Resume");
				lastUpdate=rs.getString("Lastupdate");
			}
			
			String statusq="select Status,Reason,Updatedby from Status where Candidate_ID='"+candidate_id+"' order by lastupdate desc ";
		
			rs=stmt.executeQuery(statusq);
			while(rs.next()){
				status=rs.getString("Status");
				reason=rs.getString("Reason");
				updatedby=rs.getString("Updatedby");
				break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("exception occured:"+e);
		}
		finally{
			try{
				if(stmt != null)
					stmt.close();
				if(rs != null)
					rs.close();
			}catch(SQLException s){}
		}
		request.setAttribute("name",name);
		request.setAttribute("phone",phone);
		request.setAttribute("email",email);
		request.setAttribute("source",source);
		request.setAttribute("status",status);
		request.setAttribute("reason",reason);
		request.setAttribute("resume",resume);
		request.setAttribute("updatedby",updatedby);
		request.setAttribute("lastUpdate",lastUpdate);
		request.setAttribute("candidate_id",candidate_id);		
		RequestDispatcher rd1=request.getRequestDispatcher("../views/candidate/edit.jsp");
		rd1.forward(request,response);
		return;
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
			System.out.println(e);}
	}

}
