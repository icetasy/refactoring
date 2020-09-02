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
        String result = "Rental Record for " + getName() + "\n";

        Enumeration rentalsEnumeration = rentals.elements();
        while(rentalsEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalsEnumeration.nextElement();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
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

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentalsEnumeration = rentals.elements();
        while(rentalsEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalsEnumeration.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
