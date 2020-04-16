package com.artyomgeta;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar4;
    private JList<String> list1;
    private JTextArea textArea1;
    private JList<String> list2;
    private JProgressBar progressBar5;
    private JProgressBar progressBar6;
    private JProgressBar progressBar7;
    private JProgressBar progressBar3;
    private JList list3;
    private JList list4;
    private JProgressBar progressBar8;
    private JProgressBar progressBar9;
    private JProgressBar progressBar10;
    private JTextArea textArea2;
    private JProgressBar progressBar11;
    private JProgressBar progressBar12;
    private JProgressBar progressBar13;
    private JProgressBar progressBar14;
    private JTextArea textArea3;
    private JProgressBar progressBar15;
    private JTextArea textArea4;

    public Game() {

    }


    public void run() {
        setTitle("GGame");
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        progressBar5.setMaximum(200);
        progressBar5.setValue(Main.returnSkill(0));
        progressBar6.setMaximum(200);
        progressBar6.setValue(Main.returnSkill(1));
        progressBar7.setMaximum(200);
        progressBar7.setValue(Main.returnSkill(2));


        DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
        defaultListModel.addElement("Дальше");
        defaultListModel.addElement("Назад");
        list2.setModel(defaultListModel);
        list2.setCellRenderer(new WhiteYellowCellRenderer());
        list2.setFixedCellHeight(60);
    }

    static class WhiteYellowCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
            if ( index % 2 == 0 ) {
                c.setBackground(new Color(0, 255, 255, 30));  //yellow every even row
            }
            else {
                c.setBackground(new Color(255, 0, 0, 30));
            }

            return c;
        }
    }
}
