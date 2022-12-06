package model;

import java.util.List;
import java.awt.Color;

public class Rectangle extends GeomFigure implements WithAngles{
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.color =  (Color.YELLOW);
    }

    @Override
    public float getArea() {

        return width * height;
    }

    @Override
    public float getPerimeter() {

        return (width + height) * 2;
    }


    @Override
    public List<Integer> getXCoordinate() {

        return List.of(this.x);
    }

    @Override
    public List<Integer> getYCoordinate() {

        return List.of(this.y);
    }
}
