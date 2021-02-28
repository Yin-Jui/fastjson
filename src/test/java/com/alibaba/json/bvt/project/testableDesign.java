package com.alibaba.json.bvt.project;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.*;

import java.lang.reflect.Field;

public class testableDesign {

    //substitute JSONParser in the parse function with customize parser.
    @Test
    public void test() {
        String JSONinput = "{\"price\":4.99,\"title\":\"The Book Theif\"}";
        int customizedFeature = 0;

        customizedFeature |= Feature.AutoCloseSource.getMask();
        customizedFeature |= Feature.InternFieldNames.getMask();
        customizedFeature |= Feature.UseBigDecimal.getMask();
        customizedFeature |= Feature.AllowUnQuotedFieldNames.getMask();
        customizedFeature |= Feature.AllowSingleQuotes.getMask();
        customizedFeature |= Feature.AllowArbitraryCommas.getMask();
        customizedFeature |= Feature.SortFeidFastMatch.getMask();
        customizedFeature |= Feature.IgnoreNotMatch.getMask();

        DefaultJSONParser customizedParser = new DefaultJSONParser(JSONinput, ParserConfig.getGlobalInstance(), customizedFeature);
        Object ob = testableParse(customizedParser);
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

//testable method
    public static Object testableParse(DefaultJSONParser stub) {
        Object value = stub.parseObject(Book.class, null);
        stub.handleResovleTask(value);
        stub.close();
        return value;
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
