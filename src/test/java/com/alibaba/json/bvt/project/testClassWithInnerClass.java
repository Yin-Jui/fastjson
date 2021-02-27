
package com.alibaba.json.bvt.project;

import org.junit.*;
import com.alibaba.fastjson.JSON;

public class testClassWithInnerClass{
	
	@Test
	public void test() {
		
		Book book = new Book(4.99, "The Book Theif");
		String str = JSON.toJSONString(book);
		System.out.println(str);
		String expected = "{\"auth\":{\"first_name\":\"haha\",\"last_name\":\"hehe\"},\"price\":4.99,\"title\":\"The Book Theif\"}";
		Assert.assertEquals(str, expected);
	}

	public class Book{
		
		public double price;
		public String title;
		public author auth = new author("haha","hehe");
		
		public Book(double price, String title) {
			this.price = price;
			this.title = title;
		}
		
		public class author{
			
			public String first_name;
			public String last_name;
			
			author(String f, String l){
				first_name = f;
				last_name = l;
			}
			
		}
	}
}