package com.buyalskaya.day3.validator;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Basket;
import com.buyalskaya.day3.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketValidatorTest {
    BasketValidator basketValidator;

    @BeforeClass
    public void setUp() {
        basketValidator = new BasketValidator();
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
    public void validateBasketWeightBearingTestPositive() {
        Basket basket = receiveTestData();
        Ball ball = new Ball(Color.RED, 0.2);
        assertTrue(basketValidator.validateBasketWeightBearing(basket, ball));
    }


    @Test
    public void validateBasketWeightBearingTestNegative() {
        Basket basket = receiveTestData();
        Ball ball = new Ball(Color.BROWN, 6.2);
        assertFalse(basketValidator.validateBasketWeightBearing(basket, ball));
    }
}
