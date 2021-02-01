package com.alibaba.fastjson.project;


import org.junit.*;
import com.alibaba.fastjson.JSON;

public class testIntegerCloseToUpperBound{
	
	@Test
	public void test() {
		
		SomeInteger bigint = new SomeInteger(2147483647);
		String str = JSON.toJSONString(bigint);
		String expected = "{\"value\":2147483647}";
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