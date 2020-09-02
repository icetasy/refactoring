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
}
