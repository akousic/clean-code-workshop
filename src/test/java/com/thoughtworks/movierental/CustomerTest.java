package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setup(){
        customer = new Customer("Kousic");
        customer.addRental(new Rental(new Movie("Before Sunrise",Movie.REGULAR),3));
        customer.addRental(new Rental(new Movie("Babys Dayout",Movie.CHILDRENS),2));
        customer.addRental(new Rental(new Movie("Avengers End Game",Movie.NEW_RELEASE),4));
    }


    @Test
    public void shouldReturnValidStatement(){
        assertEquals("Rental Record for Kousic\n" +
                "\tBefore Sunrise\t3.5\n" +
                "\tBabys Dayout\t1.5\n" +
                "\tAvengers End Game\t12.0\n" +
                "Amount owed is 17.0\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void shouldReturnValidHTMLStatement(){


        assertEquals("<h1>Rental Statement for <b>Kousic</b></h1><br/>"+
                        "Before Sunrise 3.5<br/>"+
                        "Babys Dayout 1.5<br/>"+
                        "Avengers End Game 12.0<br/>"+
                        "Amount owed is <b>17.0</b><br/>"+
                        "You earned <b>4</b> frequent renter points",
                customer.htmlStatement());


    }

}