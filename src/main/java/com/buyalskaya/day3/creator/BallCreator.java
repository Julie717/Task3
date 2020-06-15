package com.buyalskaya.day3.creator;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Color;

import java.util.ArrayList;
import java.util.List;

public class BallCreator {
    public Ball createBall(List<String> parameters) {
        Color color = Color.valueOf(parameters.get(0).toUpperCase());
        double weight = Double.parseDouble(parameters.get(1));
        return new Ball(color, weight);
    }

    public List<Ball> createListBall(List<List<String>> parameters) {
        List<Ball> balls=new ArrayList<>();
        for(List<String> parameter:parameters){
            balls.add(createBall(parameter));
        }
        return balls;
    }
}
