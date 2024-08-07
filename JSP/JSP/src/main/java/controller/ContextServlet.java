package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context")
public class ContextServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5099744696790972976L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("I am MANH <br/> I from Quang ninh <br/>");
		ServletContext ctx = getServletContext();
		int a = Integer.parseInt(ctx.getInitParameter("value1"));
		out.println("I am " + a + "years old");
		ServletConfig cfg = getServletConfig();
		int b = Integer.parseInt(cfg.getInitParameter("init"));
		out.println("House no" + b + "years old");
	}

}
