package com.cubic.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cubic.dao.ItemDAO;
import com.cubic.dao.exception.DBException;
import com.cubic.util.SpringFactory;
import com.cubic.vo.CartVO;
import com.cubic.vo.ItemVO;


public class AddToCartServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action =req.getParameter("action");
		String id =req.getParameter("id");
		System.out.println("printing id :"+id);
		ItemVO item = new ItemVO();
		ItemDAO dao = SpringFactory.getInstance().getBean(ItemDAO.class);
		HttpSession session = req.getSession();
		if (action.equals("ordernow"))
		{

			if (session.getAttribute("cart")==null)
			{
				List<CartVO>cart = new ArrayList<CartVO>();
				
				try {
					System.out.println("enter to getItem");
					System.out.println();
					//not needed to use
					cart.add(new CartVO(dao.getItem(Long.parseLong(id)), 1));
					session.setAttribute("cart", cart);
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else
				{
				List<CartVO>cart =(List<CartVO>) session.getAttribute("cart");
				try {
					
					cart.add(new CartVO(dao.getItem(Long.parseLong(id)), 1));
					session.setAttribute("cart", cart);
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
			}
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
	
	
	
	
	/*private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext( );
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		
		
		ItemDAO dao = SpringFactory.getInstance().getBean(ItemDAO.class);

		HashMap<Integer, String> hash=new HashMap<Integer, String>();
		
		Cart shoppingCart;
        shoppingCart = (Cart) session.getAttribute("cart");
        if(shoppingCart == null){
          shoppingCart = new Cart();
          session.setAttribute("cart", shoppingCart);
        }
        String itemname = req.getParameter("ItemName");
        Integer itemprice = Integer.parseInt(req.getParameter("ItemPrice"));
        shoppingCart.addToCart(itemname, itemprice);
        session.setAttribute("cart", shoppingCart);
		
	
	

}*/
	
	
	

