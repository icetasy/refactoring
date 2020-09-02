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
            thisAmount = each.getCharge();

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
