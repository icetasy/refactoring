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
        // 租赁积分
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";

        Enumeration rentalsEnumeration = rentals.elements();
        while(rentalsEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalsEnumeration.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentalsEnumeration = rentals.elements();
        while(rentalsEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalsEnumeration.nextElement();
            result += each.getCharge();
        }
        return result;
    }
}
