package com.buyalskaya.day3.entity;

import java.util.StringJoiner;

public class Ball {
    private Color color;
    private double weight;
    private double volume;

    public Ball() {
    }

    public Ball(Color color, double weight, double volume) {
        this.color = color;
        this.weight = weight;
        this.volume = volume;
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

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
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
        return (color.equals(ball.color)) && (ball.weight == weight) && (volume == ball.volume);
    }

    @Override
    public int hashCode() {
        return (int) (31 * weight + color.hashCode() + volume);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ball.class.getSimpleName() + "[", "]")
                .add("color=" + color)
                .add("weight=" + weight)
                .add("volume=" + volume)
                .toString();
    }
}
