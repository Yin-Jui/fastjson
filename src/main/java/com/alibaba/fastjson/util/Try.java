package com.alibaba.fastjson.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class Try {

    static class Person{
        private String id ;
        private String name;
        private int age ;
        private String address;
        HashMap<String, Integer> map;
        List<Integer> list;

        public Person(){

        }
        public Person(String id,String name,int age){
            this.id=id;
            this.name=name;
            this.age=age;
            this.address = "jjjjjjj";
            this.map = new HashMap<String, Integer>();
            this.list = new ArrayList<Integer>();

        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public HashMap<String, Integer> getMap() {
            return map;
        }
        public void setMap(HashMap<String, Integer> mm) {
            this.map = mm;
        }
        public int getAge() {
            return age;
        }
        public void setList(List<Integer> ll) {
            this.list = ll;
        }
        public List<Integer> getList() {
            return list;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person [age=" + age + ", id=" + id + ", name=" + name + "]";
        }


    }
    public static void main(String[] args) {
        method1();
        //method2();
    }

    static void method1(){
        System.out.println("javabean转化示例开始----------");
        Person person = new Person("1","fastjson",1);
        person.map.put("dwdfef", 1);
        person.map.put("jvfvvvv", 2);
        person.map.put("llllll", 3);

        person.list.add(4);
        person.list.add(8);

        person.address = "dasdsad";

        //这里将javabean转化成json字符串
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);
        //这里将json字符串转化成javabean对象,
        person =JSON.parseObject(jsonString,Person.class);
        System.out.println(person.toString());

        System.out.println("javabean转化示例结束----------");
    }

    static void method2(){
        System.out.println("List<javabean>转化示例开始----------");

        Person person1 = new Person("1","fastjson1",1);
        Person person2 = new Person("2","fastjson2",2);
        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        String jsonString = JSON.toJSONString(persons);
        System.out.println("json字符串:"+jsonString);

        //解析json字符串
        List<Person> persons2 = JSON.parseArray(jsonString,Person.class);
        //输出解析后的person对象，也可以通过调试模式查看persons2的结构
        System.out.println("person1对象："+persons2.get(0).toString());
        System.out.println("person2对象："+persons2.get(1).toString());

        System.out.println("List<javabean>转化示例结束----------");
    }
}
