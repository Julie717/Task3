package com.buyalskaya.day3.creator;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BallCreatorTest {
    BallCreator ballCreator;

    @BeforeClass
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @DataProvider(name = "dataForCreateBall")
    public Object[][] dataForCreateBall() {
        return new Object[][]{
                {Arrays.asList(new String[]{"blue", "5.0"}), new Ball(Color.BLUE, 5)},
                {Arrays.asList(new String[]{"Green", "1E-1"}), new Ball(Color.GREEN, 0.1)},
                {Arrays.asList(new String[]{"rEd", "1.4"}), new Ball(Color.RED, 1.4)}
        };
    }

    @Test(dataProvider = "dataForCreateBall")
    public void createBallTestParams(List<String> parameter, Ball expected) {
        Ball actual = ballCreator.createBall(parameter);
        assertEquals(actual, expected);
    }
}
