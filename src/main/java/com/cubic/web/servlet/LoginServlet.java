package com.cubic.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userName = req.getParameter("un");
			String password = req.getParameter("pw");
			if ("admin".equalsIgnoreCase(userName) && "1234".equals(password)) {
				HttpSession session = req.getSession();
				// session.setMaxInactiveInterval(60);
				session.setAttribute("User", userName);
				session.setAttribute("FullName", "pratap");

				resp.sendRedirect("list");
			
				/*req.getRequestDispatcher("/WEB-INF/ItemList.jsp").forward(req, resp);*/

			} else {
				resp.sendRedirect("loginform?error=true");
			}
		} catch (Exception e) {
			resp.sendRedirect("loginform?error=true");
		}
	}

}
