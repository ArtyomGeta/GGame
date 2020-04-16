package com.artyomgeta;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JPanel panel1;
    private JButton продолжитьButton;
    private JButton новаяИграButton;
    private JButton выйтиButton;
    private JButton большеButton;
    private JButton обучениеButton;

    public Menu() {
        setTitle("Menu");
        setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2, 500, 500));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();

        новаяИграButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "Вы уверены, что хотите начать новую игру?", "Подтвердите", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.YES_NO_OPTION) {
                new Newgame(this);
                dispose();
            }
        });

        выйтиButton.addActionListener(e -> dispose());
        продолжитьButton.setEnabled(false);
    }

}
