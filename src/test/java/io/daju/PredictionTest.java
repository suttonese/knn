package io.daju;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class PredictionTest extends TestCase {

    Prediction prediction = new Prediction();

    @Test
    public void testDownLoadData() throws IOException {
        prediction.downLoadData("AAPL");
    }

    @Test
    public void testPredict() throws KNNException {
        prediction.predict("AAPL");
    }

}