package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		 PrintWriter out = res.getWriter();
		 out.println("result is " + k);
		/* req.setAttribute("k", k); */

		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("sd"); rd.forward(req,res );
		 */
		/*
		 * Cookie cookie = new Cookie("s", k + ""); res.addCookie(cookie);
		 * 
		 * HttpSession hs = req.getSession(); hs.setAttribute("a", k);
		 * res.sendRedirect("sd?k=32");
		 */

	}

}
