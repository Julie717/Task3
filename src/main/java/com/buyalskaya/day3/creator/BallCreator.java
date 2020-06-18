package com.buyalskaya.day3.creator;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Color;

import java.util.ArrayList;
import java.util.List;

public class BallCreator {
    public Ball createBall(String[] ballParameter) {
        Color color = Color.valueOf(ballParameter[0].toUpperCase());
        double weight = Double.parseDouble(ballParameter[1]);
        double volume = Double.parseDouble(ballParameter[2]);
        return new Ball(color, weight, volume);
    }

    public List<Ball> createListBall(String[][] ballsParameter) {
        List<Ball> balls = new ArrayList<>();
        for (String[] parameter : ballsParameter) {
            balls.add(createBall(parameter));
        }
        return balls;
    }
}