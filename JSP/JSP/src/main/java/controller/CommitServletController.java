package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sd")
public class CommitServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int k = Integer.parseInt(req.getParameter("k"));
		int a = (int) (req.getSession()).getAttribute("a");
		var cookies = req.getCookies();
		var cookieStream = Arrays.asList(cookies).stream();

		// Filter and find the first cookie with name "s"
		Optional<Cookie> optionalCookie = cookieStream.filter(cookie -> "s".equals(cookie.getName())).findFirst();

		// Retrieve the value if present, otherwise use a default value (e.g., 0)
		int s = Integer.parseInt(optionalCookie.map(Cookie::getValue).orElse("0"));
		k = k * k + a + s;

		PrintWriter out = res.getWriter();
		out.println("Result is :" + k + "Ad: " + a + "s: " + s);

	};

}
