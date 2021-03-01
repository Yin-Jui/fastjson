package com.alibaba.json.bvt.project;

import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSON.*;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.*;

public class finiteStateMachineTest {

	@Test
	public void testSerializeWriter() {
		SerializeWriter writer = new SerializeWriter();
		writer.write("Is this writer working?");
		Assert.assertEquals("Is this writer working?",writer.toString());
	}
	
	@Test
	public void testSerializer() {
		
		
		SerializeWriter writer = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(writer);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("one",1);
		map.put("two", 2);
		serializer.write((Object) map);
		Assert.assertEquals(writer.toString(), "{\"one\":1,\"two\":2}");
		
	}
	
	@Test
	public void testDefaultJSONParser() {
		
		
		DefaultJSONParser parser = new DefaultJSONParser("Construct a new parser!");
		Assert.assertEquals("Construct a new parser!",parser.getInput());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDefaultJSONParserParseObject() throws NoSuchFieldException, 
						SecurityException, IllegalArgumentException, IllegalAccessException {
		
		DefaultJSONParser parser = new DefaultJSONParser("{\"one\":1,\"two\":\"2\"}",ParserConfig.global,
				JSON.DEFAULT_PARSER_FEATURE);
		T value = (T) parser.parseObject(test.class,null);
		parser.close();
		test t = new test();
		int i = 1;
		for(Field s : value.getClass().getFields()) {
			Object o = s.get(value);
			Assert.assertEquals(o.toString(), Integer.toString(i));
			i++;
		}
	}
	
	public static class test {
		public int one ;
		public String two  ;
		
	}
	
	
	
}
