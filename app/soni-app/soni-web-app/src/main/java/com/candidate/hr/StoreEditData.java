/*
 * Created on Sep 21, 2005
 */
package com.candidate.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
public class StoreEditData extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	Connection con=null;
	public void destroy() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String Remark=null;
		String LastUpdate=null;
		String candidate_id=request.getParameter("candidate_id");
		String Name=request.getParameter("Name");
		String Phone=request.getParameter("Phone");
		String Email=request.getParameter("Email");
		String Source=request.getParameter("Source");
		String Status=request.getParameter("Status");
		String Reason=request.getParameter("Reason");
		String Resume=request.getParameter("Resume");
		String Updatedby=request.getParameter("Updatedby");
				
		try{
			Statement stmt=con.createStatement();
						
		//update the candidate table
			String query1 = "update candidate set Name='"+Name+"', Phone='"+Phone+"', Email='"+Email+"',Source='"+Source+"',Reason='"+Reason+"',Resume='"+Resume+"',Updatedby='"+Updatedby+"' where Candidate_id='"+candidate_id+"'";
			stmt.executeUpdate(query1);
		
			String query2 = "Insert into Status (Status_ID,Candidate_ID,Status,Reason,UpdatedBy,LastUpdate) " +
				" values (Status_S.nextval,'"+candidate_id+"','"+Status+"','"+Reason+"','"+Updatedby +"',SYSDATE)";
			stmt.executeQuery(query2);
		}
		catch(Exception e){
			
		}
		    response.setContentType("text/html");
		    RequestDispatcher rd= request.getRequestDispatcher("../views/candidate/header.jsp");
		    rd.include(request, response);
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		    out.println("<html>");
		    out.println("<div id='lypsum'><body>");
			out.println("<a href='../views/candidate/candidate.jsp' class='sbLinkText'>Go candidate Home</a><br><br>");
			out.println("<a href='../views/candidate/search.jsp?edit=edit' class='sbLinkText'>Back to Search Page</a><br><br>");
			out.println("<div>"+Name+"</div>");
			out.println("<div>"+Phone+"</div>");
			out.println("<div>"+Email+"</div>");
			out.println("<div>"+Source+"</div>");
			out.println("<div>"+Status+"</div>");
			out.println("<div>"+Reason+"</div>");
			out.println("<div>"+Resume+"</div>");
			out.println("<div>"+Updatedby+"</div>");
			out.println("<div>Updated success fully</div>");
			
			
			
			 out.println("</html>");
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
