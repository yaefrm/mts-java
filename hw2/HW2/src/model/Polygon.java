package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends GeomFigure implements WithAngles{
    protected int vertexNumber = 0;
    protected List<Integer> vertexX = new ArrayList<>();
    protected List<Integer> vertexY = new ArrayList<>();

    protected float getEdge(int v1, int v2) {
        return (float) Math.sqrt(
                Math.pow(this.vertexX.get(v1) - this.vertexX.get(v2), 2) +
                        Math.pow(this.vertexY.get(v1) - this.vertexY.get(v2), 2)
        );
    }

    public Polygon(List<Integer> vertexX, List<Integer> vertexY, Color color) {
        this.vertexNumber = vertexX.size();
        this.vertexX = vertexX;
        this.vertexY = vertexY;
        this.color = (color);
    }

    @Override
    public float getArea() {
        float area = 0;

        for(int q = 0; q < vertexNumber - 1; q++) {
            area += this.vertexX.get(q) * this.vertexY.get(q + 1);
            area += this.vertexY.get(q) * this.vertexX.get(q + 1);
        }

        return area / 2;
    }

    @Override
    public float getPerimeter() {
        float perimeter = 0;

        for(int q = 0; q < vertexNumber; q++) {
            perimeter += this.getEdge(q, (q + 1) % this.vertexNumber);
        }

        return perimeter;
    }

    @Override
    public List<Integer> getXCoordinate() {
        return this.vertexX;
    }

    @Override
    public List<Integer> getYCoordinate() {
        return this.vertexY;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void addVertex(int x, int y) {
        this.vertexNumber += 1;
        this.vertexX.add(x);
        this.vertexY.add(y);
    }
}