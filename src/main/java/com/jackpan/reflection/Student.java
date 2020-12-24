package com.jackpan.reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jackpan
 * @version v1.0 2020/12/7 16:29
 */
public class Student {

    private String name;

    private String number;

    public Student(String name) {
        this.name = name;
    }
    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name Simple param.
     */
    public void setName(String name, String age) {
        System.out.println(name);
        System.out.println(age);
        this.name = name;
    }

    public static void eat(String name, String age) {
        System.out.println(name);
        System.out.println(age);
    }

    /**
     * Gets number.
     *
     * @return Value of number.
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Sets number.
     *
     * @param number Simple param.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public List<String> stringList = new ArrayList<>();

    public List<String> getStringList(){
        return this.stringList;
    }



}
