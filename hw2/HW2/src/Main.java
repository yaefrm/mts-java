import model.Circle;
import model.Polygon;
import model.Rectangle;

import java.awt.Color;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        Circle circle = new Circle(1, 2, 3, Color.YELLOW);
        System.out.println("Circle:");
        System.out.println("Area = " + circle.getArea() + " " +  "Perimeter = " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(0, 6, 9, 7, Color.PINK);
        System.out.println("Rectangle:");
        System.out.println("Area = " + rectangle.getArea() + " " + "Perimeter = " + rectangle.getPerimeter());


    }
}


