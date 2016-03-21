package com.cubic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cubic.dao.ItemDAO;
import com.cubic.dao.exception.DBException;
import com.cubic.util.SpringFactory;
import com.cubic.vo.ItemVO;



public class ItemListServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession(true);
	
				ItemDAO dao = SpringFactory.getInstance().getBean(ItemDAO.class);
				try {
					out.println("entered");
					List<ItemVO> results = dao.getAllItem();
					req.setAttribute("results", results);
					
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				req.getRequestDispatcher("/WEB-INF/ItemList.jsp").forward(req, resp);
	}
	
}
		
