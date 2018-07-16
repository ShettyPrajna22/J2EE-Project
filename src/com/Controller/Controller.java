package com.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Category;
import com.beans.Product;
import com.model.Account;
import com.pro.A;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private Account account;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		
		if(id==null)
		{
			//go to Account
			account = new Account();
			ArrayList<Product> list = new ArrayList<>();
			
			
			try {
				list = account.fetchProducts();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			A a=new A();
			TreeSet<Category> cat_list = a.getCatList(list);
			HttpSession session = request.getSession();
				session.setAttribute("list", list);
				session.setAttribute("cat_list",cat_list);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
			doPost(request,response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		
		if(id.equals("show_product")) {
			
			String cid = request.getParameter("cat_id");
			request.setAttribute("cid", cid);
			
			
			request.getRequestDispatcher("show_product.jsp").forward(request, response);
		}
		
		if(id.equals("show_product_details")){
			String pid = request.getParameter("pid");
			request.setAttribute("pid", pid);
			
			request.getRequestDispatcher("product_details.jsp").forward(request, response);
			
		}
	}

}
