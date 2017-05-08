package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServelt
 */
@WebServlet("/SecondServelt")
public class SecondServelt extends HttpServlet implements SingleThreadModel {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServelt() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		System.out.println("asdas:"+firstName);
		System.out.println("asdas:"+lastName);
		//request.
		
		response.setContentType("html/html");
		
		//response.sendError(response.);
		
//MIME		
		
		// 		JDBC
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Employee data inserted successfully</h1>");
		out.println("</body>");
		out.println("</html>");
		
		RequestDispatcher rd = request.getRequestDispatcher("./ThirdServlet");
		rd.forward(request, response);
		rd.include(request, response);
		
		ServletContext sc= null;
		sc.setAttribute("Name","Srini");
		sc.setAttribute("Name","Ramu");
		sc.removeAttribute("Name");
		RequestDispatcher rd1 = sc.getRequestDispatcher("./ThirdServlet");
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("name", "Srini");
		session.setAttribute("name", "Srini");
		
		String value = (String) session.getAttribute("Name");
		
		// Url rewring 
		// hiden
		Cookie c = new Cookie("Name", "Value");
		response.addCookie(c);
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
