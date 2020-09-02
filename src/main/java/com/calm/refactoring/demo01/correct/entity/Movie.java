package com.calm.refactoring.demo01.correct.entity;

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

    double getCharge(int daysRented) {
        double result = 0;
        // determine amounts for each line
        switch(getPriceCode()) {
            // 已发行电影,第一天2元,之后每天1.5元
            case Movie.REGULAR:
                result +=2;
                if(daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            // 新发行电影,每天3元
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            // 儿童电影,头2天共1.5元,之后每天1.5元
            case Movie.CHILDRENS:
                result +=1.5;
                if(daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(int dayRenteds) {
        // add frequent renter points
        // 积分:一部电影 +1分
        // add bonus for a two day new release rental
        // 积分:如果是新发行电影,且租2天及以上 +2分
        if((getPriceCode() == Movie.NEW_RELEASE) && dayRenteds > 1) {
            return 2;
        }
        return 1;
    }
}
