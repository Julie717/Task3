package com.buyalskaya.day3.service;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Basket;
import com.buyalskaya.day3.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketServiceTest {
    BasketService basketService = new BasketService();

    @BeforeClass
    public void setUp() {
        basketService = new BasketService();
    }

    @BeforeMethod
    public Basket createTestBasket() {
        Basket basket = new Basket(20, 40);
        Ball ball1 = new Ball(Color.GREEN, 2.0, 3.2);
        Ball ball2 = new Ball(Color.BLUE, 2.1, 4.1);
        Ball ball3 = new Ball(Color.RED, 7.4, 9);
        Ball ball4 = new Ball(Color.BLUE, 6.2, 8.7);
        Ball ball5 = new Ball(Color.BLUE, 1.1, 2.3);
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        basket.addBall(ball4);
        basket.addBall(ball5);
        return basket;
    }

    @Test
    public void amountOfBallsWithColorTest() {
        Basket basket = createTestBasket();
        int actual = basketService.amountOfBallsWithColor(basket, Color.BLUE);
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void amountOfBallsWithColorTestBallNull() {
        Basket basket = new Basket(20, 40);
        int actual = basketService.amountOfBallsWithColor(basket, Color.BLUE);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void amountOfBallsWithColorTestBasketNull() {
        Basket basket = null;
        int actual = basketService.amountOfBallsWithColor(basket, Color.BLUE);
        int expected = 0;
        assertEquals(actual, expected);
    }
}