package io.daju.model;

public class Distance {
    public static double getDistance(Price a, Price b){
        return Math.abs(a.getClosePrice() - b.getClosePrice());
    }

}
