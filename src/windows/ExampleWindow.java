package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ExampleWindow extends JFrame {
    private final int height = 300;
    private final int width = 300;

    public ExampleWindow() {
        super("Главное меню");
        setSize(width, height);
        setLocationRelativeTo(null);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.red);


        //g2.drawLine(x1, y1, x2, y2);
        //g2.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);


        g2.fill(new Ellipse2D.Float(50, 50, 200, 200));
        g2.dispose();
        getContentPane();

    }
}
