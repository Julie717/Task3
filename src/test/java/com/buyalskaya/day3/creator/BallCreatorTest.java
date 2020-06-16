package com.buyalskaya.day3.creator;

import com.buyalskaya.day3.entity.Ball;
import com.buyalskaya.day3.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
                {new String[]{"blue", "5.0", "14.0"}, new Ball(Color.BLUE, 5, 14)},
                {new String[]{"Green", "2E-1", "0.2"}, new Ball(Color.GREEN, 0.2, 0.2)},
                {new String[]{"rEd", "1.4", "2.6"}, new Ball(Color.RED, 1.4, 2.6)}
        };
    }

    @Test(dataProvider = "dataForCreateBall")
    public void createBallTestParams(String[] ballParameter, Ball expected) {
        Ball actual = ballCreator.createBall(ballParameter);
        assertEquals(actual, expected);
    }

    @Test
    public void createListBallTest() {
        String[][] ballsParameter = {{"blue", "5.0", "14.0"},
                {"Green", "2E-1", "0.2"},
                {"rEd", "1.4", "2.6"}};
        Ball ball1 = new Ball(Color.BLUE, 5, 14);
        Ball ball2 = new Ball(Color.GREEN, 0.2, 0.2);
        Ball ball3 = new Ball(Color.RED, 1.4, 2.6);
        List<Ball> expected = new ArrayList<>();
        expected.add(ball1);
        expected.add(ball2);
        expected.add(ball3);
        List<Ball> actual = ballCreator.createListBall(ballsParameter);
        assertEquals(actual, expected);
    }
}
