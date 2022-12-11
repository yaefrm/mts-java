package windows;

import model.Triangle;

import javax.swing.*;
import java.awt.*;

public class TriangleWindow extends JFrame {

    private final int width = 400;
    private final int height = 400;

    private final Triangle triangle = new Triangle();


    public TriangleWindow() throws HeadlessException {
        super("Triangle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(triangle.getColor());
        Polygon polygon =
                new Polygon(
                        triangle.getXCoordinates(),
                        triangle.getYCoordinates(),
                        3);

        g2d.fillPolygon(polygon);
    }
}
