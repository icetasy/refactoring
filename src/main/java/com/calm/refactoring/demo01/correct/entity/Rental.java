package com.calm.refactoring.demo01.correct.entity;

/**
 * @Author Calm
 * @Date 2020/9/1 12:20
 * @Version 1.0
 */
// 租赁关系类
public class Rental {
    // 租赁电影
    private Movie movie;
    // 租赁天数
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        double result = 0;
        // determine amounts for each line
        switch(getMovie().getPriceCode()) {
            // 已发行电影,第一天2元,之后每天1.5元
            case Movie.REGULAR:
                result +=2;
                if(getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            // 新发行电影,每天3元
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            // 儿童电影,头2天共1.5元,之后每天1.5元
            case Movie.CHILDRENS:
                result +=1.5;
                if(getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
