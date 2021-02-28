package com.alibaba.json.bvt.project;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.*;
import org.mockito.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class testMockito {
    @Test
    public void testResult(){
        //State testing
        String JSONinput = "{\"price\":4.99,\"title\":\"The Book Theif\"}";
        DefaultJSONParser parser = new DefaultJSONParser(JSONinput, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        DefaultJSONParser spy = spy(parser);
        Converter c = new Converter(spy);
        Object ob = c.parse();
        int index = 0;
        for(Field f: ob.getClass().getFields()){
            try {
                Object o = f.get(ob);
                if(index == 0) Assert.assertEquals(o.toString(), "4.99");
                if(index == 1) Assert.assertEquals(o.toString(), "The Book Theif");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            index++;
        }
    }
    @Test
    public void testArgumentCaptor(){
        String JSONinput = "{\"price\":4.99,\"title\":\"The Book Theif\"}";
        DefaultJSONParser parser = new DefaultJSONParser(JSONinput, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        DefaultJSONParser spy = spy(parser);
        Converter c = new Converter(spy);
        c.parse();
        ArgumentCaptor<Type> classCaptor = ArgumentCaptor.forClass(Type.class);
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        verify(spy, times(1)).parseObject(classCaptor.capture(), objectCaptor.capture());
        assertThat(classCaptor.getAllValues()).containsExactly(Book.class);
    }

    @Test
    public void testInteraction() {
        //Interaction testing
        String JSONinput = "{\"price\":4.99,\"title\":\"The Book Theif\"}";
        DefaultJSONParser parser = new DefaultJSONParser(JSONinput, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        DefaultJSONParser spy = spy(parser);
        Converter c = new Converter(spy);
        c.parse();
        verify(spy, times(1)).parseObject(Book.class, null);
        verify(spy, times(1)).handleResovleTask(spy.parseObject(Book.class, null));
        verify(spy, times(1)).close();
    }

    @Test
    public void testOrder(){
        String JSONinput = "{\"price\":4.99,\"title\":\"The Book Theif\"}";
        DefaultJSONParser parser = new DefaultJSONParser(JSONinput, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        DefaultJSONParser spy = spy(parser);
        Converter c = new Converter(spy);
        c.parse();
        InOrder inOrder = inOrder(spy);
        inOrder.verify(spy).parseObject(Book.class, null);
        inOrder.verify(spy).close();
    }

    public class Converter{
        DefaultJSONParser parser;
        public Converter( DefaultJSONParser d){
            parser = d;
        }
        public Object parse(){
            Object value = parser.parseObject(Book.class, null);
            parser.handleResovleTask(value);
            parser.close();
            return value;
        }
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
