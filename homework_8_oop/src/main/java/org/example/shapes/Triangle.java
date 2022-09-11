package org.example.shapes;

import org.example.point.Point;

import java.util.List;

public class Triangle extends Polygon {
    public Triangle(String name, List<Point> vertices) {
        super(name, vertices);
        if(vertices.size() != 3) { //you can add additional check if points aren't collinear
            throw new IllegalArgumentException("Wrong count of points provided for Triangle");
        }
    }
}
