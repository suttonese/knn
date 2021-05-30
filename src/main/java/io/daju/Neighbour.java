package io.suttonese;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Neighbour implements Comparable<Neighbour> {
    public double distance;
    public double price;

    // Neighbours are compared based on distance.
    public int compareTo(Neighbour other) {
        return Double.compare(this.distance, other.distance);
    }

    public String toString() {
        String out = "Distance: " + distance + ", price: " + price;
        return out;
    }
}

