package com.alibaba.fastjson.project;

import org.junit.*;
import com.alibaba.fastjson.JSON;

public class testSimpleClass{
	
	@Test
	public void test() {
		
		Book book = new Book(4.99, "The Book Theif");
		String str = JSON.toJSONString(book);
		String expected = "{\"price\":4.99,\"title\":\"The Book Theif\"}";
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
}