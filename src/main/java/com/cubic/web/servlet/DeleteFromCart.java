package com.cubic.web.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteFromCart {
	
	/* protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         String name = request.getParameter("name");
           HttpSession session = request.getSession();
         cart shoppingCart;
         shoppingCart = (cart) session.getAttribute("cart");
         shoppingCart.deleteFromCart(name);
         session.setAttribute("cart", shoppingCart);
          shoppingCart = (cart) session.getAttribute("cart");
         try (PrintWriter out = response.getWriter()) {
              TODO output your page here. You may use following sample code. 
             out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Servlet deleteItem</title>");            
             out.println("</head>");
             out.println("<body>");
             HashMap<String, Integer> items = shoppingCart.getCartItems();
             out.println("<table border='1px'>");
              
             for(String key: items.keySet()){
                 out.println("<form action='deleteItem'><input type='hidden' name='name' value='"+key+"'><tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td><td><input type='submit' value='delete'></td></tr></form>");
             }
             out.println("<table>");
             out.println("</body>");
             out.println("</html>");
         }*/

}
