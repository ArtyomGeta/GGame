package com.artyomgeta;

import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Newgame extends JFrame {
    private JPanel panel1;
    private JTextArea главногоГерояЗовутАртёмTextArea;
    private JRadioButton задираRadioButton;
    private JRadioButton спортсменRadioButton;
    private JRadioButton ботаникRadioButton;
    private JButton продолжитьButton;

    public Newgame(Menu parent) {
        setTitle("New Game");
        setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2, 470, 205));
        setResizable(false);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        главногоГерояЗовутАртёмTextArea.setText("Главного героя зовут Артём и поменять его имя вы не можете, \nоднако его характер находиться на вашей ответственности...\n\nВыберите его социальный статус:");
        главногоГерояЗовутАртёмTextArea.setEditable(false);
        продолжитьButton.addActionListener(e -> {
            if (задираRadioButton.isSelected() || спортсменRadioButton.isSelected() || ботаникRadioButton.isSelected()) {
                parent.dispose();
                new Story(0);
                int i = 0;
                if (задираRadioButton.isSelected()) i = 0;
                else if (спортсменRadioButton.isSelected()) i = 1;
                else if (ботаникRadioButton.isSelected()) i = 2;
                try {
                    if (i == 0) Main.saveGame(i, new int[] {Main.changeSkill(0, 20), Main.returnSkill(1), Main.returnSkill(2)});
                    else if (i == 1) Main.saveGame(i, new int[] {Main.returnSkill(0), Main.changeSkill(1, 20), Main.returnSkill(2)});
                    else if (i == 2) Main.saveGame(i, new int[] {Main.returnSkill(0), Main.returnSkill(1), Main.changeSkill(2, 20)});
                } catch (IOException | JSONException ioException) {
                    ioException.printStackTrace();
                }
                dispose();
            }
        });
        продолжитьButton.setEnabled(false);
        задираRadioButton.addActionListener(e -> {
            ботаникRadioButton.setSelected(false);
            спортсменRadioButton.setSelected(false);
            продолжитьButton.setEnabled(true);
            if (!задираRadioButton.isSelected()) задираRadioButton.setSelected(true);
        });

        спортсменRadioButton.addActionListener(e -> {
            ботаникRadioButton.setSelected(false);
            задираRadioButton.setSelected(false);
            продолжитьButton.setEnabled(true);
            if (!спортсменRadioButton.isSelected()) спортсменRadioButton.setSelected(true);
        });
        ботаникRadioButton.addActionListener(e -> {
            спортсменRadioButton.setSelected(false);
            задираRadioButton.setSelected(false);
            продолжитьButton.setEnabled(true);
            if (!ботаникRadioButton.isSelected()) ботаникRadioButton.setSelected(true);
        });
    }

}
