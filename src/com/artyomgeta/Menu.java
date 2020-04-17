package com.artyomgeta;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Objects;

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

        if (Objects.requireNonNull(new File("saves/").list()).length == 1) {

        }

        продолжитьButton.setEnabled(Main.isNewGame());

        продолжитьButton.addActionListener(e -> {
            new Game().run();
            dispose();
        });

        выйтиButton.addActionListener(e -> dispose());
    }

}
