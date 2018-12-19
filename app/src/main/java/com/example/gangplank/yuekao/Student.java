package com.example.gangplank.yuekao;

import java.util.ArrayList;

/**
 * Created by GANGPLANK on 2018/10/22.
 */

public class Student {

    private ArrayList<Person> result;

    public Student(ArrayList<Person> result) {
        this.result = result;
    }

    public ArrayList<Person> getResult() {
        return result;
    }

    public void setResult(ArrayList<Person> result) {
        this.result = result;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "result=" + result +
                '}';
    }
}
 class  Person{
    private String name;
    private String leve1;
    private String image_url;

     public Person(String name, String leve1, String image_url) {
         this.name = name;
         this.leve1 = leve1;
         this.image_url = image_url;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getLeve1() {
         return leve1;
     }

     public void setLeve1(String leve1) {
         this.leve1 = leve1;
     }

     public String getImage_url() {
         return image_url;
     }

     public void setImage_url(String image_url) {
         this.image_url = image_url;
     }

     public Person() {
         super();
     }

     @Override
     public String toString() {
         return "Person{" +
                 "name='" + name + '\'' +
                 ", leve1='" + leve1 + '\'' +
                 ", image_url='" + image_url + '\'' +
                 '}';
     }
 }

