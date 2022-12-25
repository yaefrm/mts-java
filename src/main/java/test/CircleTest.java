package test;

import model.CircleFigure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;


public class CircleTest {
    private final CircleFigure circle = new CircleFigure(120, 120, 100, new Color(10, 38, 73));

    @Test
    public void testGetX() {
        Assertions.assertEquals(circle.getX(), 120);
    }

    @Test
    public void testGetY() {
        Assertions.assertEquals(circle.getY(), 120);
    }

    @Test
    public void testGetWidth() {
        Assertions.assertEquals(circle.getWidth(), 100);
    }

    @Test
    public void testGetHeight() {
        Assertions.assertEquals(circle.getHeight(), 100);
    }

    @Test
    public void testGetColor() {
        Assertions.assertEquals(circle.getColor(), Color.blue);
    }

    @Test
    public void testGetArea() {
        float area = (float) (Math.PI * Math.sqrt(100));
        Assertions.assertEquals(circle.getArea(), area);
    }

    @Test
    public void testGetPerimeter() {
        float perimeter = (float) (2 * Math.PI * 100);
        Assertions.assertEquals(circle.getPerimeter(), perimeter);
    }

    @Test
    public void testGetXCoordinates() {
        int[] xs =  new int[]{20, 120, 220};
        Assertions.assertArrayEquals(circle.getXCoordinates(), xs);
    }

    @Test
    public void testGetYCoordinates() {
        int[] ys =  new int[]{20, 120,220};
        Assertions.assertArrayEquals(circle.getYCoordinates(), ys);
    }

    @Test
    public void testNoArgsConstructor() {
        CircleFigure circleWithNoArgs = new CircleFigure();
        Assertions.assertEquals(circleWithNoArgs.getX(), 0);
        Assertions.assertEquals(circleWithNoArgs.getY(), 0);
        Assertions.assertEquals(circleWithNoArgs.getWidth(), 0);
        Assertions.assertEquals(circleWithNoArgs.getHeight(), 0);
    }

    @Test
    public void testEquals() {
        CircleFigure circleFirst = new CircleFigure();
        CircleFigure circleSecond = new CircleFigure(0, 0, 0, 0, null);
        Assertions.assertEquals(circleFirst, circleSecond);
    }


}
