package com.buyalskaya.day3.validator;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Basket;
import com.buyalskaya.day3.service.BasketService;

public class BasketValidator {
    public boolean validateBasketWeightBearing(Basket basket, Ball ball) {
        double ballWeight = ball.getWeight();
        double basketWeightBearing = basket.getWeightBearing();
        BasketService basketService = new BasketService();
        double weightBallsInBasket = basketService.weightBallsInBasket(basket);
        return (weightBallsInBasket + ballWeight <= basketWeightBearing);
    }
}
