package com.calm.refactoring.demo01.error.entity;

/**
 * @Author Calm
 * @Date 2020/9/1 12:17
 * @Version 1.0
 */
// 电影类
public class Movie {
    // 儿童
    public static final int CHILDRENS = 2;
    // 已发行
    public static final int REGULAR = 0;
    // 新发行
    public static final int NEW_RELEASE = 1;
    // 电影名
    private String title;
    // 价格编码
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode(){
       return this.priceCode;
    }

    public void setPriceCode(int arg) {
        this.priceCode = arg;
    }

    public String getTitle() {
        return this.title;
    }
}
