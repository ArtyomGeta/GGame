package com.artyomgeta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Game extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar4;
    private JList<String> list1;
    public JTextArea textArea1;
    public JList<String> list2;
    private JProgressBar progressBar5;
    private JProgressBar progressBar6;
    private JProgressBar progressBar7;
    private JProgressBar progressBar3;
    private JList list3;
    private JList list4;
    public JProgressBar progressBar8;
    public JProgressBar progressBar9;
    public JProgressBar progressBar10;
    public JTextArea textArea2;
    public JProgressBar progressBar11;
    private JProgressBar progressBar12;
    private JProgressBar progressBar13;
    private JProgressBar progressBar14;
    private JTextArea textArea3;
    private JProgressBar progressBar15;
    private JTextArea textArea4;
    public JLabel nameLabel;
    public JLabel characterLabel;
    public JLabel weaponLabel;
    private JScrollPane scroll1;
    private JScrollPane scroll2;
    private JScrollPane scroll3;
    private JList list5;
    private JButton отклонитьButton;
    private JTextArea textArea5;
    private JEditorPane editorPane1;
    public DefaultListModel<String> defaultListModel1;

    public Game() {

    }


    public void run() {
        setTitle("GGame");
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        defaultListModel1 = new DefaultListModel<>();
        list2.setCellRenderer(new MyCellRenderer(list2.getWidth()));
        System.out.println(list2.getWidth());

        progressBar5.setMaximum(200);
        progressBar5.setValue(Main.returnSkill(0));
        progressBar6.setMaximum(200);
        progressBar6.setValue(Main.returnSkill(1));
        progressBar7.setMaximum(200);
        progressBar7.setValue(Main.returnSkill(2));

        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea3.setLineWrap(true);
        textArea3.setWrapStyleWord(true);
        textArea4.setLineWrap(true);
        textArea4.setWrapStyleWord(true);

        list2.setFixedCellHeight(60);

        new Triggers(this).setDescription(0, Main.returnHuman(0));

        if (Objects.requireNonNull(new File("saves/").list()).length == 1) {
            new Triggers(this).startDialog(0, Main.BOT_ANTON);
            new Triggers(this).returnClientDialog(0, 0, 1);
        }

        scroll1.getVerticalScrollBar().setValue(0);
        scroll2.getVerticalScrollBar().setValue(0);
        scroll3.getVerticalScrollBar().setValue(0);

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

    class MyCellRenderer extends DefaultListCellRenderer {
        public static final String HTML_1 = "<html><body style='width: ";
        public static final String HTML_2 = "px'>";
        public static final String HTML_3 = "</html>";
        private int width;

        public MyCellRenderer(int width) {
            this.width = width;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            String text = HTML_1 + String.valueOf(width - 200) + HTML_2 + value.toString()
                    + HTML_3;
            return super.getListCellRendererComponent(list, text, index, isSelected,
                    cellHasFocus);
        }

    }

}
