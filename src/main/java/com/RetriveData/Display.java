package com.RetriveData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("uid"));
		
		
		Connection con=ConnectionDB.getConnection();
		String str="select * from product where p_id=" + id;
		Statement stm=con.createStatement();
		
		ResultSet rs=stm.executeQuery(str);
		PrintWriter out=response.getWriter();
		out.println("Your Product Details"+"<br>");

		out.println("<table border=2>");
		out.println("<tr><th>P_id</th><th>P_Name</th><th>P_cost</th></tr>");
		
		while(rs.next()) {
			
			out.println("<tr>");
			out.print("<td>"+rs.getInt("p_id")+"</td>");
			out.print("<td>"+rs.getString("p_name")+"</td>");
			out.print("<td>"+rs.getInt("p_cost")+"</td>");
			out.println("</tr>");

		}
		out.println("</table>");

		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
