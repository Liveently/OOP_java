package lab3.gui;

import lab3.CustomTimer;
import lab3.Model;
import lab3.View;

import javax.swing.*;
import lab3.gui.GraphicalController.GUIMenuListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class GraphicalView implements View {
    private int height;
    private int width;
    private final Model model;
    private final CustomTimer timer;
    private final GUI gui;
    private ArrayList<JButton> buttons;
    private final ImageIcon buttonIcon;
    private final ImageIcon revealedIcon;
    private final ImageIcon oneIcon;
    private final ImageIcon twoIcon;
    private final ImageIcon threeIcon;
    private final ImageIcon fourIcon;
    private final ImageIcon fiveIcon;
    private final ImageIcon sixIcon;
    private final ImageIcon sevenIcon;
    private final ImageIcon eightIcon;
    private final ImageIcon flagIcon;
    private final ImageIcon mineIcon;
    private final ImageIcon mineExplodedIcon;
    private final HashMap<Character, ImageIcon> iconMap;

    public GraphicalView(Model model) {
        this.height = model.getHeight();
        this.width = model.getWidth();
        this.model = model;

        timer = new CustomTimer(model, this);

        Thread threadTimer = new Thread(timer);
        threadTimer.start();

        gui = new GUI(height, width);

        buttonIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\button.png", "tg");


        revealedIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\revealed.png", "rv");
        oneIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\1.png", "1");
        twoIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\2.png", "2");
        threeIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\3.png", "3");
        fourIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\4.png", "4");
        fiveIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\5.png", "5");
        sixIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\6.png", "6");
        sevenIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\7.png", "7");
        eightIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\8.png", "8");
        flagIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\flag.png", "flag");
        mineIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\mine.png", "mine");
        mineExplodedIcon = new ImageIcon("D:\\myproject\\oop\\Minesweeper\\src\\main\\resources\\mine_exploded.png", "mine_exploded");

        iconMap = new HashMap<>() {{
            put('0', revealedIcon);
            put('1', oneIcon);
            put('2', twoIcon);
            put('3', threeIcon);
            put('4', fourIcon);
            put('5', fiveIcon);
            put('6', sixIcon);
            put('7', sevenIcon);
            put('8', eightIcon);
            put('B', mineIcon);
            put('M', mineExplodedIcon);
        }};

        initButtons();
    }

    void initButtons() {
        buttons = gui.getButtons();
        int size = width * height;
        for (int i = 0; i < size; i++)
            buttons.get(i).setIcon(buttonIcon);
    }

    void changeSize(int width, int height) {
        this.width = width;
        this.height = height;
        gui.changeSize(width, height);

        initButtons();
    }

    @Override
    public void update() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = i * width + j;
                if (model.isRevealed(j, i)) {
                    buttons.get(index).setIcon(iconMap.get(model.at(j, i)));
                } else {
                    if (model.isFlag(j, i))
                        buttons.get(index).setIcon(flagIcon);
                    else
                        buttons.get(index).setIcon(buttonIcon);
                }
            }
        }
    }

    @Override
    public String getInputName() {
        return gui.getInputName();
    }

    public void addListeners(ActionListener buttonListener, MouseListener mouseListener, GUIMenuListener menuListener) {
        int size = height * width;
        for (int i = 0; i < size; i++) {
            buttons.get(i).addActionListener(buttonListener);
            buttons.get(i).addMouseListener(mouseListener);
        }

        gui.addMenuListener(menuListener);
    }

    public void setTime(int value) {
        gui.getTimerPanel().setTime(value);
    }

    @Override
    public void showWinDialog() {
        JOptionPane.showMessageDialog(gui.getTimerPanel(), "Congratulations! You won the game.");
    }

    @Override
    public void showLoseDialog() {
        JOptionPane.showMessageDialog(null, "Defeat. The Game is over.", "Defeat", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showRanking(TreeMap<String, Double> rankingData) {
        gui.showRankingFrame(rankingData);
    }

    @Override
    public void showAbout() {
        JOptionPane.showMessageDialog(null, "This game was made \nby student of IT department\n - Evgeniy Ashmarin", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void startTimer() {
        timer.startTimer();
    }

    public void stopTimer() {
        timer.stop();
    }
}