package windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final JButton exampleButton = new JButton("Example Button");
    private final JButton circleButton = new JButton("Efremova Yana");


    public MainWindow() {
        super("Новое окно");
        JPanel jPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        GridLayout layout = new GridLayout(6, 1, 5, 12);
        jPanel.add(exampleButton);
        jPanel.add(circleButton);
        jPanel.setLayout(layout);
        getContentPane().add(jPanel);


        exampleButton.addActionListener(e -> {
            ExampleWindow exampleWindow = new ExampleWindow();
            exampleWindow.setVisible(true);
        });

        circleButton.addActionListener(e -> {
            CircleWindow circleWindow = new CircleWindow();
            circleWindow.setVisible(true);
        });
    }
}
