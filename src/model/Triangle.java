package model;

import java.awt.*;

public class Triangle extends AbstractFigure {

    private final int[] x = {200, 50, 350};
    private final int[] y = {50, 350, 350};

    private final float perimeter;
    private final float area;

    private final int number = x.length;

    private final Color color;


    public Triangle() {
        perimeter = calculatePerimeter();
        area = calculateArea();
        color = new Color(0, 127, 255);
    }

    @Override
    public int[] getXCoordinates() {
        return x;
    }

    @Override
    public int[] getYCoordinates() {
        return y;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public float getArea() {
        return area;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public float getPerimeter() {
        return perimeter;
    }

    private float calculateArea() {
        float s1;
        float s2;

        s1 = (x[1] - x[0]) * (y[2] - y[0]);
        s2 = (x[2] - x[0]) * (y[1] - y[0]);

        return (s1 - s2) / 2;
    }

    private float calculatePerimeter() {
        float perimeter = 0;
        for (int i = 0; i < x.length; i++) {

            int xDif = Math.abs(x[(i + 1) % 3] - x[i]);
            int yDif = Math.abs(y[(i + 1) % 3] - y[i]);

            float side = (float) Math.sqrt(xDif * xDif + yDif * yDif);

            perimeter += side;
        }

        return perimeter;
    }
}
