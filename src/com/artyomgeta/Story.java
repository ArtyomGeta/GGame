package com.artyomgeta;

import javax.swing.*;
import java.awt.*;

public class Story extends JFrame {
    private JPanel panel1;
    private JButton продолжитьButton;
    private JTextArea textArea1;

    public Story(int storyID) {
        setTitle("Story");
        setSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(panel1);
        textArea1.setText(Main.returnStory(storyID));
        textArea1.setEditable(false);
        продолжитьButton.addActionListener(e -> {
            if (storyID == 0) new Game().run();
            dispose();
        });
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
    }
}
