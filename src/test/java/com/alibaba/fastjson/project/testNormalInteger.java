package com.alibaba.fastjson.project;


import org.junit.*;
import com.alibaba.fastjson.JSON;

public class testNormalInteger{
	
	@Test
	public void test() {
		
		SomeInteger bigint = new SomeInteger(75892);
		String str = JSON.toJSONString(bigint);
		String expected = "{\"value\":75892}";
		Assert.assertEquals(str,expected);
	}

	
	public static class SomeInteger{
			
			
			private int value;
			
			public SomeInteger(int value) {
				this.value = value;
			}
			
			public int getValue() {
				return value;
			}
	}
}