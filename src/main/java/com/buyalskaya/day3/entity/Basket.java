package com.buyalskaya.day3.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Basket {
    public final static double BASKET_MIN_WEIGHT = 0.1;
    public final static double BASKET_MAX_WEIGHT = 100;
    public final static double BASKET_MIN_VOLUME = 0.1;
    public final static double BASKET_MAX_VOLUME = 150;

    private double weightCapacity;
    private double volumeCapacity;
    private List<Ball> balls;

    public Basket(double weightCapacity, double volumeCapacity) {
        this.weightCapacity = checkWeightCapacity(weightCapacity);
        this.volumeCapacity = checkVolumeCapacity(volumeCapacity);
        balls = new ArrayList<>();
    }


    private double checkWeightCapacity(double weight) {
        if (weight > BASKET_MAX_WEIGHT) {
            weight = BASKET_MAX_WEIGHT;
        }
        if (weight < BASKET_MIN_WEIGHT) {
            weight = BASKET_MIN_WEIGHT;
        }
        return weight;
    }

    private double checkVolumeCapacity(double volume) {
        if (volume > BASKET_MAX_VOLUME) {
            volume = BASKET_MAX_VOLUME;
        }
        if (volume < BASKET_MIN_VOLUME) {
            volume = BASKET_MIN_VOLUME;
        }
        return volume;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public double getVolumeCapacity() {
        return volumeCapacity;
    }

    public List<Ball> getBalls() {

        return Collections.unmodifiableList(balls);
    }

    public boolean addBall(Ball ball) {
        if (ball == null) {
            return false;
        }
        double ballWeight = ball.getWeight();
        double ballVolume = ball.getVolume();
        double basketFreeWeight = weightCapacity - weight();
        double basketFreeVolume = volumeCapacity - volume();
        boolean isCanPlaceInBasket = (basketFreeWeight >= ballWeight) && (basketFreeVolume >= ballVolume);
        if (isCanPlaceInBasket) {
            balls.add(ball);
        }
        return isCanPlaceInBasket;
    }

    public boolean addBalls(List<Ball> balls) {
        if (balls == null) {
            return false;
        }
        double ballsWeight = 0;
        double ballsVolume = 0;
        for (Ball ball : balls) {
            if (ball == null) {
                return false;
            }
            ballsWeight = ballsWeight + ball.getWeight();
            ballsVolume = ballsVolume + ball.getVolume();
        }
        double basketFreeWeight = weightCapacity - weight();
        double basketFreeVolume = volumeCapacity - volume();
        boolean isCanPlaceInBasket = (basketFreeWeight >= ballsWeight) && (basketFreeVolume >= ballsVolume);
        if (isCanPlaceInBasket) {
            this.balls.addAll(balls);
        }
        return isCanPlaceInBasket;
    }

    public boolean removeBall(Ball ball) {
        return balls.remove(ball);
    }

    public double weight() {
        double weightBalls = 0;
        for (Ball ball : balls) {
            weightBalls = weightBalls + ball.getWeight();
        }
        return weightBalls;
    }

    public double volume() {
        double volume = 0;
        for (Ball ball : balls) {
            volume = volume + ball.getVolume();
        }
        return volume;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Basket basket = (Basket) obj;
        return (basket.weightCapacity == weightCapacity) &&
                (basket.volumeCapacity == volumeCapacity) &&
                (balls.equals(basket.balls));
    }

    @Override
    public int hashCode() {
        return (int) (31 * weightCapacity + volumeCapacity + balls.hashCode());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Basket.class.getSimpleName() + "[", "]")
                .add("weightBearing=" + weightCapacity)
                .add("balls=" + balls)
                .toString();
    }
}
