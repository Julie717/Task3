package com.buyalskaya.day3.service;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Basket;
import com.buyalskaya.day3.entity.Color;

public class BasketService {
    public int amountOfBallsWithColor(Basket basket, Color color) {
        int amountOfBalls = 0;
        for (Ball ball : basket.getBalls()) {
            if (ball.getColor() == color) {
                amountOfBalls++;
            }
        }
        return amountOfBalls;
    }
}
