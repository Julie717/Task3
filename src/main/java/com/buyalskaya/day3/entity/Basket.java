package com.buyalskaya.day3.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Basket {
    private double weightBearing;
    private List<Ball> balls;

    public Basket(double weightBearing) {
        this.weightBearing = weightBearing;
        balls = new ArrayList<>();
    }

    public double getWeightBearing() {
        return weightBearing;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public void removeBall(Ball ball) {
        balls.remove(ball);
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
        return (basket.weightBearing == weightBearing) && (balls.equals(basket.balls));
    }

    @Override
    public int hashCode() {
        return (int) (31 * weightBearing + balls.hashCode());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Basket.class.getSimpleName() + "[", "]")
                .add("weightBearing=" + weightBearing)
                .add("balls=" + balls)
                .toString();
    }
}
