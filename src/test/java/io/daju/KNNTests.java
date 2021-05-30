package io.daju;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class KNNTests {
    ArrayList<Price> trainingData = new ArrayList<>();
    KNNEngine knnEngine = new KNNEngine();

    @Before
    public void init () {
        Price priceA = new Price(5, 6.5);
        Price priceB = new Price(4.5, 4);
        Price priceC = new Price(5.5, 5);
        Price priceD = new Price(5.2, 5);
        trainingData.add(priceA);
        trainingData.add(priceB);
        trainingData.add(priceC);
        trainingData.add(priceD);
    }

    @Test
    public void testDistance() {

        Price priceA = new Price(4.5, 5);
        Price priceB = new Price(5, 5.5);

        assert (Distance.getDistance(priceA, priceB) == 0.5);
    }

    @Test
    public void testClassifyKOne() {
        Price test1 = new Price();
        test1.setClosePrice(5);

        knnEngine.classify(test1, trainingData, 1);
        assert (test1.getNextDayClosePrice() == 6.5);
    }
    @Test
    public void testClassifyKTwo() {

        Price test2 = new Price();
        test2.setClosePrice(6);
        knnEngine.classify(test2, trainingData, 2);
        assert(test2.getNextDayClosePrice() == 5);
    }

    @Test
    public void testClassifyKThree() {

        Price test3 = new Price();
        test3.setClosePrice(5.1);
        knnEngine.classify(test3, trainingData, 3);
        assert (test3.getNextDayClosePrice() == 5.5);
    }

    @Test (expected = KNNException.class)
    public void testLeastSwquareException() throws KNNException {
        ArrayList<Price> testPrices = new ArrayList<>();
        Price testA = new Price(5, 5);
        testPrices.add(testA);
        ArrayList<Price> predictions = new ArrayList<>();
        Price predictionA = new Price(5, 5.5);
        Price predictionB = new Price(4.5, 5.5);
        predictions.add(predictionA);
        predictions.add(predictionB);
        knnEngine.leastSquare(testPrices, predictions);
    }

    @Test
    public void testLeastSwquare() throws KNNException {
        ArrayList<Price> testPrices = new ArrayList<>();
        Price testA = new Price(5, 5);
        Price testB = new Price(4.5, 5);
        Price testC = new Price(6, 5);
        testPrices.add(testA);
        testPrices.add(testB);
        testPrices.add(testC);
        ArrayList<Price> predictions = new ArrayList<>();
        Price predictionA = new Price(5, 5.5);
        Price predictionB = new Price(4.5, 5.5);
        Price predictionC = new Price(6, 5.5);
        predictions.add(predictionA);
        predictions.add(predictionB);
        predictions.add(predictionC);
        assert (knnEngine.leastSquare(testPrices, predictions) == 0.75);
    }
}
