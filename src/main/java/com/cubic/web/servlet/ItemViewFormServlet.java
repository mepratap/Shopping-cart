package com.cubic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.cubic.dao.ItemDAO;

//import org.apache.commons.lang3.StringUtils;

import com.cubic.util.SpringFactory;
import com.cubic.vo.ItemVO;

public class ItemViewFormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("pk");

		System.out.println("Printing id from form servlet: " + id);

		ItemVO vo = getItem(id);

		System.out.println("Printing item from form servlet: " + vo);
		
		String productName=(vo!=null&&vo.getItemName()!=null)?vo.getItemName():"";
		int productQuantity=(vo!=null&& vo.getQuantity()!=0)?vo.getQuantity():0;
		int productPrice=(vo!=null&& vo.getItemPrice()!=0)?vo.getItemPrice():0;
		//Double productPrice=(Double) ((vo!=null&&vo.getItemPrice()!=0)?vo.getItemPrice():0);

		/*String firstName = (vo != null && vo.getFirstName() != null) ? vo.getFirstName() : "";
		String lastName = (vo != null && vo.getLastName() != null) ? vo.getLastName() : "";*/

		out.println("<HTML><BODY>");
		out.println("<h2>Create Item</h2><br/></br>");
		out.println("<form method=\"POST\" action=\"create\">");
		if (vo != null) {
			out.println("<input type=\"hidden\" name=\"pk\" value=\"" + id + "\">");
		}
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("<td width=\"100\">Product Name:</td><TD><input type=\"text\" name=\"pname\" value=\"" + productName
				+ "\"  maxlength=\"100\" size=\"30\"></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<td width=\"100\">Product Quantity:</td><TD><input type=\"text\" name=\"pquantity\" value=\"" + productQuantity
				+ "\" maxlength=\"100\" size=\"30\"></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<td width=\"100\">Product Price:</td><TD><input type=\"text\" name=\"pprice\" value=\"" + productPrice
				+ "\" maxlength=\"100\" size=\"30\"></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD colspan=\"2\" align=\"right\"><input type=\"submit\" value=\"SUBMIT\"></TD></TD>");
		out.println("</TR>");
		out.println("</TABLE>");
		out.println("</form>");
		out.println("</BODY></HTML>");
		out.close();

	}

	private ItemVO getItem(String id) {
		ItemVO vo = null;

		if ((!StringUtils.isEmpty(id)) && id.trim().matches("\\d+")) {
			ItemDAO dao = SpringFactory.getInstance().getBean(ItemDAO.class);
			try {
				
				vo = dao.getItem(new Long(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}

}