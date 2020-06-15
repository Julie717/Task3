package com.buyalskaya.day3.service;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Basket;
import com.buyalskaya.day3.entity.Color;
import com.buyalskaya.day3.exception.InputDataException;
import com.buyalskaya.day3.validator.BasketValidator;

public class BasketService {
    public static final String SIZE_BASKET_EXCEPTION = "This ball cannot fit into the basket";

    public void putBallInBasket(Basket basket, Ball ball) throws InputDataException {
        BasketValidator basketValidator = new BasketValidator();
        if (basketValidator.validateBasketWeightBearing(basket, ball)) {
            basket.addBall(ball);
        } else {
            throw new InputDataException(SIZE_BASKET_EXCEPTION);
        }
    }

    public void pullBallFromBasket(Basket basket, Ball ball) {
        basket.removeBall(ball);
    }

    public double weightBallsInBasket(Basket basket) {
        double weight = 0;
        for (Ball ball : basket.getBalls()) {
            weight = weight + ball.getWeight();
        }
        return weight;
    }

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
