package com.pro;

import java.util.ArrayList;
import java.util.TreeSet;

import com.beans.Category;
import com.beans.Product;

public class A {
	
	TreeSet<Category> c = new TreeSet<>();

	public TreeSet<Category> getCatList(ArrayList<Product> list) {
		
			for(Product p: list) {
				int id=p.getCat().getId();
				String name  = p.getCat().getName();
				Category cat = new Category();
				cat.setId(id);
				cat.setName(name);
				c.add(cat);
			}
		
		return c;
	}

}
