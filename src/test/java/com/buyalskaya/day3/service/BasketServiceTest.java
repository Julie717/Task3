package com.buyalskaya.day3.service;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Basket;
import com.buyalskaya.day3.entity.Color;
import com.buyalskaya.day3.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketServiceTest {
    public static final String EXCEPTION_PUT_MESSAGE = "Ball isn't correctly placed in the basket";
    BasketService basketService = new BasketService();

    @BeforeClass
    public void setUp() {
        basketService = new BasketService();
    }

    @Test
    public void putBallInBasketTestPositive() {
        Basket basket = new Basket(7);
        Ball ball = new Ball(Color.GREEN, 4.0);
        try {
            basketService.putBallInBasket(basket, ball);
            System.out.println(basket);
            Basket basketExpected = new Basket(7);
            basketExpected.addBall(ball);
            assertEquals(basket, basketExpected);
        } catch (InputDataException ex) {
            fail(EXCEPTION_PUT_MESSAGE);
        }
    }

    @Test
    public void putBallInBasketTestNegative() {
        Basket basket = new Basket(3);
        Ball ball = new Ball(Color.GREEN, 7.0);
        assertThrows(InputDataException.class, () -> basketService.putBallInBasket(basket, ball));
    }

    @BeforeMethod
    public Basket receiveTestData() {
        Basket basket = new Basket(20);
        Ball ball1 = new Ball(Color.GREEN, 2.0);
        Ball ball2 = new Ball(Color.BLUE, 2.1);
        Ball ball3 = new Ball(Color.RED, 7.4);
        Ball ball4 = new Ball(Color.BLUE, 6.2);
        Ball ball5 = new Ball(Color.BLUE, 1.1);
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        basket.addBall(ball4);
        basket.addBall(ball5);
        return basket;
    }

    @Test
    public void weightBallsInBasketTest() {
        Basket basket = receiveTestData();
        double actual = basketService.weightBallsInBasket(basket);
        double expected = 18.8;
        assertEquals(actual, expected);
    }

    @Test
    public void amountOfBallsWithColorTest() {
        Basket basket = receiveTestData();
        int actual = basketService.amountOfBallsWithColor(basket,Color.BLUE);
        int expected = 3;
        assertEquals(actual, expected);
    }
}
