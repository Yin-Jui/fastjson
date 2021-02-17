package com.alibaba.fastjson.project;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.*;
import org.json.*;
import org.junit.*;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class testFunctionalModel {

    private Object SerializerFeature;

    //Test the transition from JSON String to Java Object
    @Test
    public void test1() {

        String expected = "{\"price\":4.99,\"title\":\"The Book Theif\"}";
        String JSONinput = "{\"price\":4.99,\"title\":\"The Book Theif\"}";

        /*
        inside the parseObject implementation, the input string is first added
        with JSON.DEFAULT_PARSER_FEATURE feature, and then added with getGlobalInstance()
        configuration in parse method. Finally pass the string with those features to DefaultJSONParser.
        */
        DefaultJSONParser parser = new DefaultJSONParser(JSONinput, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Object value = parser.parse();

        parser.handleResovleTask(value);

        parser.close();

        Assert.assertEquals(value.toString(), expected);

    }
//test the transition from Object to Json string
    @Test
    public void test2() {

        Book book = new Book(4.99, "The Book Theif");
        String expected = "{\"price\":4.99,\"title\":\"The Book Theif\"}";

        Assert.assertEquals(JSON.toJSONString(book), expected);
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
