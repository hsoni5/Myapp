/*
 * Created on Sep 20, 200
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.candidate.hr;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HSONI
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 * 
 */
public class CandidateServlet extends HttpServlet
{   
	 Connection con=null;
	 /**
	  * Constructor of object
	 */
	 public CandidateServlet()
	 {
		 super();
	 }
	 
	/** Initialization of servlet
	 * @throws ServletException if occurs
     */
	@Override
	public void init() throws ServletException {
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","soni","root123");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/*
	 * Destruction of servlet. <br/>
	
	*/@Override
	public void destroy() {
		try{
			
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	/*  
	 * The doGet method of the servlet.<br>
	 * This method is called when a form has its tag value method  equals to get.
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		doGet(request, response);
	}
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("Name");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		String source = request.getParameter("Source");
		String status = request.getParameter("Status");
		String reason = request.getParameter("Reason");
		String resume = request.getParameter("Resume");
		String updatedby = request.getParameter("Updatedby");
		String comments = request.getParameter("Comments");

		String Skill = request.getParameter("Skill");
		String rating = request.getParameter("Rating");
		String remark = request.getParameter("Remark");

		
		

		
		
		// TODO Auto-generated method stub
	    response.setContentType("text/html");
	    RequestDispatcher rd= request.getRequestDispatcher("../views/common/header.jsp");
	    rd.include(request, response);
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
	    out.println("<html>");
	    out.println("<head><title>Candidate servlet</title></head>");
	    out.println("<div id='lypsum'><body>");
	    String msg="Recpord <b>"+name+"</b> updated successfully";
	    String id=null;
	    Statement stmt=null;
	    ResultSet rs=null;
	    try
	    {
	    	stmt=con.createStatement();
	    	String query="Select Name from Candidate where upper(email) =upper('"+email+"')";
	    	rs=stmt.executeQuery(query);
	    	while(rs.next())
	    	{
	    		String name1=rs.getString("name");
	    		out.println("<html><body text=\"red\">");
	    		out.println("<h3>Candidate "+" "+name1+" "+"is already exist</h3>");
				out.println("<a href='../views/candidate/candidate.jsp' class='sbLinkText'>Back</a><br><br>");
		        out.println("<a href='../views/candidate/candidate.jsp' class='sbLinkText'>Go Candidate Home</a><br>");
				out.println("</body></html>");
				return;
			}
	    
	    	String idq = "Select Candidate_S.nextval from dual";			
			rs = stmt.executeQuery(idq);
			while(rs.next()){
			id = rs.getString(1);	
			}
			
			 query = "Insert into Candidate (Candidate_ID,Name,Phone,Email,Source,Reason,Resume,UpdatedBy,Comments,LastUpdate) " +
			" values (Candidate_S.nextval,'"+name+"','"+phone+"','"+email+"','"+source+"','"+reason+"','"+resume+"','"+updatedby +"','"+comments+"',SYSDATE)";
			stmt.executeQuery(query);
			
			query = "Insert into Status (Status_ID,Candidate_ID,Status,Reason,UpdatedBy,LastUpdate) " +
			" values (Status_S.nextval,Candidate_S.nextval,'"+status+"','"+reason+"','"+updatedby +"',SYSDATE)";
			
			query="Insert into Skills(Skill_ID,Status_ID,Candidate_ID,Skills,Rating,Remark,UpdatedBy,LastUpdate)"+"values(Skills_S.nextval,Status_S.nextval,Candidate_S.nextval,'"+Skill+"','"+rating+"','"+remark +"','"+updatedby +"',SYSDATE)";
			
			stmt.executeQuery(query);
		}
		catch (SQLException e) {
        	msg = "Failed to update Record : <b>"+ name +"</b>";
            e.printStackTrace();
        }
		finally {
            try {
            	if(stmt != null)
            		stmt.close();
            	if(rs != null)
            		rs.close();
            } catch (SQLException e1) {  
                e1.printStackTrace();
            }
        }
        out.println(msg);
//		out.println("<br> <P>");
		
		out.println("<form name='myform'ACTION='../views/candidate/candidate.jsp'> ");
		out.println("<input type='Submit' value='Add Other user' ><br>");
		out.println(" <a href='../views/candidate/candidate.jsp' >Go Candidate Home</a>");
		out.println("</form>"); 
		
		out.println("  </BODY></div>");
		out.println("</HTML>");
		rd= request.getRequestDispatcher("../views/common/footer.jsp");
	    rd.include(request, response);
		out.flush();
		out.close();
		
		
		
		
		
	}

}