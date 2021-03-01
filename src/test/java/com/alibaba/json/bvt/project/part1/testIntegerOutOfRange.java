package com.alibaba.json.bvt.project.part1;


import org.junit.*;
import com.alibaba.fastjson.JSON;

public class testIntegerOutOfRange{
	
	@Test
	public void test() {
		
		BigInteger bigint = new BigInteger((int)Math.pow(2, 35));
		String str = JSON.toJSONString(bigint);
		String expected = "{\"value\":2147483647}";
		Assert.assertEquals(str,expected);
	}

	
	public static class BigInteger{
			
			
			private int value;
			
			public BigInteger(int value) {
				this.value = value;
			}
			
			public int getValue() {
				return value;
			}
	}
}