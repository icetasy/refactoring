package com.calm.refactoring.demo01.error;


import com.calm.refactoring.demo01.error.entity.Customer;
import com.calm.refactoring.demo01.error.entity.Movie;
import com.calm.refactoring.demo01.error.entity.Rental;
import org.junit.Test;

/**
 * @Author Calm
 * @Date 2020/9/1 12:56
 * @Version 1.0
 */
public class DemoTest {

    @Test
    public void statementTest(){
        Movie movie = new Movie("电影1", 1);
        Movie movie2 = new Movie("电影2", 0);
        Rental rental = new Rental(movie, 3);
        Rental rental2 = new Rental(movie2, 8);
        Customer customer = new Customer("lili");
        customer.addRental(rental);
        customer.addRental(rental2);
        String result = customer.statement();
        System.out.println(result);
    }
}
