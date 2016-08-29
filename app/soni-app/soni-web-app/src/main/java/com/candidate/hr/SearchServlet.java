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

/**
 * @author HSONI 
 *
 * TODO Discribe the class / interface here
 */
public class SearchServlet extends HttpServlet {
	
	//for path to got the properties
        public  static String path="E:/SONI_PROJECTS_WORKSPACE/soni-app/soni-web-app/src/main/java/com/candidate/hr/";
	
	Connection con = null;
	
	
	
	public void init() throws ServletException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","soni","root123");
            
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		Statement stmt = null;
		ResultSet rs = null;
		String src = request.getParameter("Src");
		String status=request.getParameter("status");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		boolean bRecordFound = false;
		
	 	String submitTo = "FeedbackServlet";
	 	
	 	if("Edit".equalsIgnoreCase(src) ){
	 		submitTo = "Edit";
	 	}
	 	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    RequestDispatcher rd= request.getRequestDispatcher("../views/candidate/header.jsp");
	    rd.include(request, response);
	    
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Search Servlet</TITLE></HEAD>");
		out.println("<div id='lypsum'>  <BODY>");
	
		out.println("<FORM name='SearchForm' ACTION="+submitTo+">");
		try{
			stmt = con.createStatement();
			String candi_id[] =new String[100];
			out.println("Search Result: <br><br>");	
			int i=0;
			
			if(name.equals(""))
			{
				String query="select candidate_id, Name from Candidate c, status s where c.candidate_id = s.candidate_id and status='"+status+"'";
				rs=stmt.executeQuery(query);
								
				while(rs.next()){
					bRecordFound =true;
					String candidate_id = rs.getString("Candidate_ID");
					out.println("<a href="+submitTo+"?candidate_id="+ rs.getString(1)+">"+rs.getString(2)+"</a> <br>");
				}
				if(!bRecordFound){
					out.println("<b>No Matches Found for Status "+status+"</b>");
				}				
			}
			else{
				String query = "Select Candidate_ID,Name from Candidate where upper(Name) like upper('%"+name+"%')";
				rs = stmt.executeQuery(query);
					
				while(rs.next()){
					bRecordFound =true;
					String str= "<a href="+submitTo+"?candidate_id="+ rs.getString("Candidate_ID")+">"+rs.getString("Name")+"</a> <br>";
					out.println(str);
				}
				if(!bRecordFound){
					out.println("<b>No Matches Found for "+name+"</b>");
				}
			}
		}
		catch (SQLException e) {
        	   e.printStackTrace();
        }
		finally{
            try {
            	if(stmt != null)
            		stmt.close();
            	if(rs != null)
            		rs.close();
			}
            catch (Exception e1) {
				e1.printStackTrace();
			}
        }
   
        out.println("</FORM>"); 
        if(submitTo == "FeedbackServlet"){
        out.println("<a href='../views/candidate/search.jsp' class='sbLinkText'>Back to Search Page</a>&nbsp;&nbsp;&nbsp;");
        }
        if(submitTo == "Edit") {
        out.println("<a href='../views/candidate/search.jsp?edit=edit' class='sbLinkText'>Back to Search Page</a>&nbsp;&nbsp;&nbsp;");
        
        }
		out.println("</BODY></div>");
		out.println("</HTML>");
		rd= request.getRequestDispatcher("../views/candidate/footer.jsp");
	    rd.include(request, response);
		out.flush();
		out.close();
		
		
	}
	public void destroy() {
		try{
			con.close();
		}catch(Exception e)	{
			System.out.println(e);
		}
	}
}
