package windows;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    private final int WIDTH_SIZE = 300;
    private final int HEIGHT_SIZE = 350;

    private final JButton buttonTriangleWindow = new JButton("Volkov Max");
    private final Color buttonColor = new Color(135, 206, 250);

    public MainWindow() {
        super("Main");

        JPanel jPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH_SIZE, HEIGHT_SIZE);
        setResizable(false);
        setLocationRelativeTo(null);
        GridLayout gridLayout = new GridLayout(4, 1, 0, 0);
        jPanel.setLayout(gridLayout);

        buttonTriangleWindow.setFont(new Font("Times New Roman", Font.BOLD, 25));
        buttonTriangleWindow.setBackground(buttonColor);
        jPanel.add(buttonTriangleWindow);

        getContentPane().add(jPanel);

        buttonTriangleWindow.addActionListener(e -> {
            TriangleWindow triangleWindow = new TriangleWindow();
            triangleWindow.setVisible(true);
        });
    }
}
