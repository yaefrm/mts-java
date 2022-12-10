package windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final JButton exampleButton = new JButton("Example Button");
    private final JButton rectangleButton = new JButton("Дмитрий Поздеев");


    public MainWindow() {
        super("Новое окно");
        JPanel jPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        GridLayout layout = new GridLayout(6, 1, 5, 12);
        jPanel.add(exampleButton);
        jPanel.setLayout(layout);
        jPanel.add(rectangleButton);
        jPanel.setLayout(layout);
        getContentPane().add(jPanel);


        exampleButton.addActionListener(e -> {
            ExampleWindow exampleWindow = new ExampleWindow();
            exampleWindow.setVisible(true);
        });

        rectangleButton.addActionListener(e -> {
            RectangleWindow rectangleWindow = new RectangleWindow();
            rectangleWindow.setVisible(true);
        });
    }
}
