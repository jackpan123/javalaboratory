package com.jackpan.ioc;

/**
 * @author jackpan
 * @version v1.0 2021/2/1 00:07
 */
public class Person {

    String name;

    Integer age;

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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return Value of age.
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * Sets age.
     *
     * @param age Simple param.
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}
