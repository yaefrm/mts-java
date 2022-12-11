package windows;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    private final int width = 300;
    private final int height = 500;

    private final JButton button = new JButton("Volkov Max");

    public MainWindow()  {
        super("Main");

        JPanel jPanel = new JPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);

        GridLayout gridLayout = new GridLayout(4, 1, 0, 0);
        jPanel.setLayout(gridLayout);

        jPanel.add(button);

        getContentPane().add(jPanel);

        button.addActionListener(e -> {
            TriangleWindow triangleWindow = new TriangleWindow();
            triangleWindow.setVisible(true);
        });
    }
}
