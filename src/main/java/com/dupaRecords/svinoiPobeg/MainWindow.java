package com.dupaRecords.svinoiPobeg;

import com.dupaRecords.svinoiPobeg.Sprites.Background;
import com.dupaRecords.svinoiPobeg.Sprites.Cactus;
import com.dupaRecords.svinoiPobeg.Sprites.Pig;
import com.dupaRecords.svinoiPobeg.Sprites.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
    private DrawPanel drawPanel;
    private Game game;
    private Timer timer;
    private Sprite[] sprites;
    private int width;
    private int height;
    private int fps;
    private int record;

    public MainWindow(int width, int height, int fps) throws HeadlessException {
        super("Свиной побег 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);

        this.width = width;
        this.height = height;
        this.fps = fps;

        Object[] options = {"Играть", "Выход"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Игра свиной побег 2D задумана как реализация игры свиной побег только не в 3д",
                "Свиной побег 2D",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == JOptionPane.YES_OPTION) {
            startGame();
        } else {
            System.exit(0);
        }
    }

    public int getRecord () {
        return record;
    }

    public void setRecord() {
        int newRecord = drawPanel.getSecondsFromStart();
        if (newRecord > record) {
            record = newRecord;
        }
    }

    public void startGame() {
        sprites = new Sprite[3];

        sprites[0] = new Background(0, 0, width, height);
        sprites[1] = new Pig(0, height * 55 / 100, width / 8, height / 6);
        sprites[2] = new Cactus(width, height * 45 / 100, width / 8, height / 4);

        timer = new Timer(1000 / fps, null);

        drawPanel = new DrawPanel(timer, sprites, fps, this);
        add(drawPanel);

        game = new Game(width, timer, sprites, fps, this);

        timer.addActionListener(drawPanel);
        timer.addActionListener(game);

        drawPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "jump");
        drawPanel.getActionMap().put("jump", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { game.pigJump(); }
        });

        setVisible(true);
        timer.start();
    }
}
