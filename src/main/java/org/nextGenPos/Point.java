package org.nextGenPos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Point {
    private final int point;

    public Point add(Point other) {
        return new Point(this.point + other.point);
    }

    public Point minus(Point total) {
        return new Point(this.point - total.point);
    }
}