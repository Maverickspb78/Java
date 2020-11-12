package lesson8;

import javax.swing.*;
import java.awt.*;

public class VictoryDialog extends JFrame {
    public static void main(String[] args) {

    }


    public void WindowWin(String word) throws HeadlessException {

        if (word.equals("Вы проиграли")) {
            JFrame frame2 = new JFrame("Вы проиграли");
            frame2.setAlwaysOnTop(true);
            frame2.setSize(350, 100);
            frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame2.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            JButton close = new JButton("CLOSE");
            close.addActionListener(e -> {
                dispose();
                frame2.dispose();


            });
            panel.add(close);
            frame2.add(panel);
            frame2.setVisible(true);
        }
        if (word.equals("Вы выиграли")) {

            JFrame frame2 = new JFrame("Вы выиграли");
            frame2.setAlwaysOnTop(true);
            frame2.setSize(350, 100);
            frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame2.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            JButton close = new JButton("CLOSE");
            close.addActionListener(e -> {
                dispose();
                frame2.dispose();


            });
            panel.add(close);
            frame2.add(panel);
            frame2.setVisible(true);
        }
    }


}


