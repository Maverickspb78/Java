package lesson8;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private static final ImageIcon ICON_X = new ImageIcon(Window.class.getResource("X.png"));
    private static final ImageIcon ICON_O = new ImageIcon(Window.class.getResource("O.png"));
    private static final ImageIcon ICON_DEFAULT = new ImageIcon(Window.class.getResource("def.png"));

    private final JButton[][] map = new JButton[3][3];
    private static int clickCount = 0;
    private final int[][] map2 = new int[3][3];
    private boolean endGame = false;

    public static void setClickCount(int clickCount) {
        Window.clickCount = clickCount;
    }

    private void initMap(JPanel panel) {

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                map2[k][l] = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                map[i][j] = new JButton();
                JButton btn = map[i][j];
                btn.setIcon(ICON_DEFAULT);
                btn.setDisabledIcon(ICON_DEFAULT);
                btn.addActionListener(a -> {
                    btn.setIcon(ICON_X);
                    btn.setDisabledIcon(ICON_X);
                    btn.setEnabled(false);
                    clickCount++;
                    checkWinPlayer(map, map2);
                    moveAI(map, map2);
                    checkWinPc(map, map2);
                    checkCount(clickCount);

                    // TODO: 05.11.2020 move PC
                    // TODO: 05.11.2020 check victory
                });
                panel.add(btn);
            }
        }
    }

    public void checkWinPlayer(JButton[][] map, int[][] map2) {
        if (endGame == false) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j].getIcon() == ICON_X) {
                        map2[i][j] = 100;
                    }
                    if (map[i][j].getIcon() == ICON_O) {
                        map2[i][j] = 10;
                    }
                }
            }

            int diag1 = 0;
            int diag2 = 0;
            for (int i = 0; i < map2.length; i++) {
                diag1 += (map2[i][i]);
                diag2 += (map2[i][(map2.length - 1) - i]);

            }

            if (diag1 == 300 || diag2 == 300) {
                menu();
                VictoryDialog v = new VictoryDialog();
                v.WindowWin("Вы выиграли");
                endGame = true;
            }
            int horizontal = 0;
            int vertical = 0;
            for (int i = 0; i < map2.length; i++) {
                for (int j = 0; j < map2.length; j++) {
                    horizontal += map2[j][i];
                    vertical += map2[i][j];

                }
                if (horizontal == 300 || vertical == 300) {
                    menu();
                    VictoryDialog v = new VictoryDialog();
                    v.WindowWin("Вы выиграли");
                    endGame = true;

                    break;
                }
                vertical = 0;
                horizontal = 0;
            }
        }

    }

    private void checkWinPc(JButton[][] map, int[][] map2) {
        if (endGame == false) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j].getIcon() == ICON_X) {
                        map2[i][j] = 100;
                    }
                    if (map[i][j].getIcon() == ICON_O) {
                        map2[i][j] = 10;
                    }
                }
            }
            int diag1 = 0;
            int diag2 = 0;
            int horizontal = 0;
            int vertical = 0;
            for (int i = 0; i < map2.length; i++) {
                diag1 += (map2[i][i]);
                diag2 += (map2[i][(map2.length - 1) - i]);
            }
            if (diag1 == 30 || diag2 == 30) {
                menu();
                VictoryDialog v = new VictoryDialog();
                v.WindowWin("Вы проиграли");
                endGame = true;

            }

            for (int i = 0; i < map2.length; i++) {
                for (int j = 0; j < map2.length; j++) {
                    horizontal += map2[j][i];
                    vertical += map2[i][j];

                }
                if (horizontal == 30 || vertical == 30) {
                    menu();
                    VictoryDialog v = new VictoryDialog();
                    v.WindowWin("Вы проиграли");
                    endGame = true;
                    break;
                }
                vertical = 0;
                horizontal = 0;

            }
        }
    }

    public void moveAI(JButton[][] map, int[][] map2) {
        if (clickCount != 9) {
            int x = (int) (Math.random() * map2.length), y = (int) (Math.random() * map2.length);
            while (map2[x][y] == 10 || map2[x][y] == 100) {
                x = (int) (Math.random() * map2.length);
                y = (int) (Math.random() * map2.length);
            }
            map2[x][y] = 10;
            map[x][y].setIcon(ICON_O);
            map[x][y].setDisabledIcon(ICON_O);
            map[x][y].setEnabled(false);
            clickCount++;

        }
    }

    public Window() throws HeadlessException {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(3, 3));
        initMap(panel);
        add(panel);
        setResizable(false);
        setVisible(true);
    }

    public void menu() {
        JFrame frameNew = new JFrame("Что дальше?");
        frameNew.setAlwaysOnTop(true);
        frameNew.setSize(250, 100);
        frameNew.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameNew.setLocationRelativeTo(null);
        frameNew.setResizable(false);
        JPanel panel1 = new JPanel();
        JButton close = new JButton("CLOSE");
        close.addActionListener(e -> {
            dispose();
            frameNew.dispose();
        });
        JButton newGame = new JButton("NEW GAME");
        newGame.addActionListener(e -> {
            clickCount = 0;
            new Window();
            dispose();
            frameNew.dispose();
        });
        panel1.add(close);
        panel1.add(newGame);
        frameNew.add(panel1);
        frameNew.setVisible(true);
        frameNew.setResizable(false);
        setVisible(true);
    }

    private void checkCount(int clickCount) {
        if (endGame ==false) {
            if (clickCount == 9) {
                JFrame frame3 = new JFrame("Ничья");
                frame3.setSize(300, 100);
                frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame3.setLocationRelativeTo(null);
                frame3.setResizable(false);
                JPanel p = new JPanel();
                JButton close = new JButton("CLOSE");
                close.addActionListener(e -> {
                    dispose();
                    frame3.dispose();
                });
                JButton newGame = new JButton("NEW GAME");
                newGame.addActionListener(e -> {
                    setClickCount(0);
                    new Window();
                    dispose();
                    frame3.dispose();
                });
                p.add(close);
                p.add(newGame);
                frame3.add(p);
                frame3.setVisible(true);
            }
        }
    }


    public static void main(String[] args) {
        new Window();

    }
}
