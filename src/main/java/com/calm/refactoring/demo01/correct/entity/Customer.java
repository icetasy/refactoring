package com.calm.refactoring.demo01.correct.entity;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author Calm
 * @Date 2020/9/1 12:15
 * @Version 1.0
 */
public class Customer {
    // 客户名字
    private String name;
    // 客户租的电影
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    // 添加租赁
    public void addRental(Rental arg) {
        this.rentals.addElement(arg);
    }

    public String getName() {
        return  this.name;
    }

    public String statement() {
        // 总价格
        double totalAmount = 0;
        // 租赁积分
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";

        Enumeration rentalsEnumeration = rentals.elements();
        while(rentalsEnumeration.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentalsEnumeration.nextElement();

            // determine amounts for each line
            switch(each.getMovie().getPriceCode()) {
                // 已发行电影,第一天2元,之后每天1.5元
                case Movie.REGULAR:
                    thisAmount +=2;
                    if(each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                // 新发行电影,每天3元
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                // 儿童电影,头2天共1.5元,之后每天1.5元
                case Movie.CHILDRENS:
                    thisAmount +=1.5;
                    if(each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            // add frequent renter points
            // 积分:一部电影 +1分
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            // 积分:如果是新发行电影,且租2天及以上 +1分
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints ++;
            }

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
