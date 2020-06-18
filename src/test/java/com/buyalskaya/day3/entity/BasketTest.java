package com.buyalskaya.day3.entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketTest {

    @Test
    public void addBallTestPositive() {
        Basket basket = new Basket(20.5, 47.8);
        Ball ball = new Ball(Color.ORANGE, 1.2, 1.4);
        assertTrue(basket.addBall(ball));
    }

    @Test
    public void addBallTestNegative() {
        Basket basket = new Basket(4.5, 7.8);
        Ball ball = new Ball(Color.ORANGE, 11.2, 1.4);
        assertFalse(basket.addBall(ball));
    }

    @Test
    public void addBallTestNull() {
        Basket basket = new Basket(4.5, 3.8);
        Ball ball = null;
        assertFalse(basket.addBall(ball));
    }

    @BeforeMethod
    public List<Ball> createBalls() {
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(Color.ORANGE, 1.2, 1.4));
        balls.add(new Ball(Color.RED, 2.2, 6.4));
        balls.add(new Ball(Color.BROWN, 4.2, 8.4));
        return balls;
    }

    @Test
    public void addBallsTestPositive() {
        Basket basket = new Basket(20.5, 47.8);
        assertTrue(basket.addBalls(createBalls()));
    }

    @Test
    public void addBallsTestNegative() {
        Basket basket = new Basket(4.5, 3.8);
        assertFalse(basket.addBalls(createBalls()));
    }

    @Test
    public void addBallsTestNull() {
        Basket basket = new Basket(4.5, 3.8);
        List<Ball> balls = null;
        assertFalse(basket.addBalls(balls));
    }

    @Test
    public void addBallsTestOneNull() {
        Basket basket = new Basket(4.5, 3.8);
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(Color.ORANGE, 1.2, 1.4));
        balls.add(null);
        balls.add(new Ball(Color.BROWN, 4.2, 8.4));
        assertFalse(basket.addBalls(balls));
    }

    @Test
    public void weightTest() {
        Basket basket = new Basket(20.5, 47.8);
        List<Ball> balls = createBalls();
        basket.addBalls(balls);
        double actual = basket.weight();
        double expected = 7.6;
        assertEquals(actual, expected,1E-4);
    }

    @Test
    public void weightTestNull() {
        Basket basket = new Basket(20.5, 47.8);
        double actual = basket.weight();
        double expected = 0;
        assertEquals(actual, expected,1E-4);
    }

    @Test
    public void volumeTest() {
        Basket basket = new Basket(20.5, 47.8);
        List<Ball> balls = createBalls();
        basket.addBalls(balls);
        double actual = basket.volume();
        double expected = 16.2;
        assertEquals(actual, expected,1E-4);
    }

    @Test
    public void volumeTestNull() {
        Basket basket = new Basket(20.5, 47.8);
        double actual = basket.volume();
        double expected = 0;
        assertEquals(actual, expected,1E-4);
    }

    @Test
    public void removeBallTestPositive() {
        Basket basket = new Basket(20.5, 47.8);
        List<Ball> balls = createBalls();
        basket.addBalls(balls);
        assertTrue(basket.removeBall(balls.get(0)));
    }

    @Test
    public void removeBallTestNegative() {
        Basket basket = new Basket(20.5, 47.8);
        List<Ball> balls = createBalls();
        basket.addBalls(balls);
        Ball ball=new Ball(Color.GREEN,1.5,2.5);
        assertFalse(basket.removeBall(ball));
    }

    @Test
    public void removeBallTestBasketNull() {
        Basket basket = new Basket(20.5, 47.8);
        Ball ball=new Ball(Color.GREEN,1.5,2.5);
        assertFalse(basket.removeBall(ball));
    }

    @Test
    public void removeBallTestBallNull() {
        Basket basket = new Basket(20.5, 47.8);
        List<Ball> balls = createBalls();
        basket.addBalls(balls);
        Ball ball=null;
        assertFalse(basket.removeBall(ball));
    }
}
