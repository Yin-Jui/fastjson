
package com.alibaba.json.bvt.project;

import org.junit.*;
import com.alibaba.fastjson.JSON;

public class testClassWithInheritance{
	
	@Test
	public void test() {
		
		Book book = new Novel(4.99, "The Book Theif","Sci-Fi");
		String str = JSON.toJSONString(book);
		System.out.println(str);
		String expected = "{\"genre\":\"Sci-Fi\",\"price\":4.99,\"title\":\"The Book Theif\"}";
		Assert.assertEquals(str, expected);
	}

	public class Book{
		
		public double price;
		public String title;
		
		public Book(double price, String title) {
			this.price = price;
			this.title = title;
		}
		
	}
	
	public class Novel extends Book{
		
		public String genre;
		
		public Novel(double price, String title, String genre) {
			
			super(price, title);
			this.genre = genre;
		}
		
		
	}
}