package com.buyalskaya.day3.entity;

import java.util.StringJoiner;

public class Ball {
    private Color color;
    private double weight;

    public Ball() {
    }

    public Ball(Color color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Ball ball = (Ball) obj;
        return (ball.weight == weight) && (color.equals(ball.color));
    }

    @Override
    public int hashCode() {
        return (int) (31 * weight + color.hashCode());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ball.class.getSimpleName() + "[", "]")
                .add("color='" + color + "'")
                .add("weight=" + weight)
                .toString();
    }
}
