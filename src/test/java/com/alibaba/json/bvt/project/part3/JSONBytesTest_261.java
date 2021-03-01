package com.alibaba.json.bvt.project.part3;

import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.Labels;

public class JSONBytesTest_261 {

	@Test
	public void test1() {
	Charset charset = Charset.forName("UTF-8");
	Object object = "aa";
	SerializeConfig config = new SerializeConfig();
	SerializeFilter[] filters = new SerializeFilter[1];
	filters[0] = new Labels.DefaultLabelFilter(null, null);
	int defaultFeatures = 1;
	byte[] result = JSON.toJSONBytesWithFastJsonConfig(charset, 
            object,
            config, 
            filters,
            "dd/MM/yyyy", 
            defaultFeatures);
	byte[] expected = "\"aa\"".getBytes();
	Assert.assertArrayEquals(result,expected);
	}
	@Test
	public void test2() {
	Charset charset = Charset.forName("UTF-8");
	Object object = "hahaha~~~";
	SerializeConfig config = new SerializeConfig();
	SerializeFilter[] filters = null;
	int defaultFeatures = 1;
	byte[] result = JSON.toJSONBytesWithFastJsonConfig(charset, 
            object,
            config, 
            filters,
            "", 
            defaultFeatures);
	byte[] expected = "\"hahaha~~~\"".getBytes();
	
	Assert.assertArrayEquals(result,expected);
	}
	
	@Test
	public void test3() {
	Charset charset = Charset.forName("UTF-8");
	Object object = null;
	SerializeConfig config = new SerializeConfig();
	SerializeFilter[] filters = null;
	int defaultFeatures = 1;
	byte[] result = JSON.toJSONBytesWithFastJsonConfig(charset, 
            object,
            config, 
            filters,
            null, 
            defaultFeatures);
	byte[] expected = "null".getBytes();
	Assert.assertArrayEquals(result,expected);
	}
	
}
