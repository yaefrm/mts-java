package model;

import java.awt.Color;

public class Circle extends GeomFigure {
    protected int x;
    protected int y;
    protected int radius;

    public Circle(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;

        this.color = (color);
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.sqrt(radius));
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * Math.PI * radius);
    }
}
