package com.alibaba.json.bvt.project.part3;

import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.junit.*;


public class WriteStringWithDoubleQuoteTest {
	
	@Test
	public void test1() {
		String str = "hahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldfhahaha just for funjklksjdflkjfksdlsjfkslfjskldjfskldfslkdjfksldjskldf!";
		char[] chars = str.toCharArray();
		SerializeWriter writer = new SerializeWriter();
		writer.writeStringWithDoubleQuote(chars,'a');
		Assert.assertEquals(writer.toString(),"\""+str+"\"a");
	}

	@Test
	public void test2() {
		
		char[] chars = null;
		SerializeWriter writer = new SerializeWriter();
		writer.writeStringWithDoubleQuote(chars,'a');
		Assert.assertEquals(writer.toString(),"nulla");
	}
	@Test
	public void test3() {
		
		String str = "jaja";
		char[] chars = str.toCharArray();
		SerializeWriter writer = new SerializeWriter(new OutputStreamWriter(System.out));
		writer.writeStringWithDoubleQuote(chars,'a');
		Assert.assertEquals(writer.toString(),"\""+str+"\"a");
	}
}
