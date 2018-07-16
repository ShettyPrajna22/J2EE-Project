package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Category;
import com.beans.Product;

public class Account {
	
	
	private String username="root";
	private String password="abc123";
	private String url="jdbc:mysql://localhost:3306/cart";
	private String driver="com.mysql.jdbc.Driver";
	
	Connection con;
	
	private void dbConnect() throws ClassNotFoundException,SQLException{
		Class.forName(driver);
		con=DriverManager.getConnection(url,username,password);
	}

	private void dbClose() throws SQLException{
		con.close();
		}
	

	public ArrayList<Product> fetchProducts() throws ClassNotFoundException, SQLException {

		dbConnect();
		
		String sql = "SELECT * FROM products,category where category.cat_id=products.cat_id";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		
		ArrayList<Product> list = new ArrayList<>();
		
		while(rst.next())
			{
				int pid = rst.getInt("pid");
				String pname = rst.getString("pname");
				String price = rst.getString("price");
				String short_desc = rst.getString("short_desc");
				String description = rst.getString("description");
				int cat_id = rst.getInt("cat_id");
				String cat_name = rst.getString("cat_name");
				
				//ArrayList
				Product p = new Product();
				Category c = new Category();
				
				p.setPid(pid);
				p.setPname(pname);
				p.setPrice(price);
				p.setShort_desc(short_desc);
				p.setDescription(description);
				c.setId(cat_id);
				c.setName(cat_name);
				
				p.setCat(c);
				list.add(p);
			}
		
		dbClose();
		return list;
	}

}
