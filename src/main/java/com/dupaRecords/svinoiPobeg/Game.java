package com.dupaRecords.svinoiPobeg;

import com.dupaRecords.svinoiPobeg.Sprites.Cactus;
import com.dupaRecords.svinoiPobeg.Sprites.Pig;
import com.dupaRecords.svinoiPobeg.Sprites.Sprite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private final MainWindow mainWindow;
    private final Timer timer;
    private final Sprite[] sprites;

    private final double dt;
    private final double GRAVITY = 900;
    private final double JUMP_IMPULSE = -700;
    private final double CACTUS_SPEED = 200;
    private final int PIG_START_POINT;

    private double pigVelocity = 0;
    private boolean isPigJumping = false;
    private final int windowWidth;

    public Game (int width, Timer timer, Sprite[] sprites, int fps, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.timer = timer;
        this.sprites = sprites;
        this.dt = 1.0 / fps;
        PIG_START_POINT = sprites[1].getY();
        windowWidth = width;
    }

    public void pigJump() {
        if (!isPigJumping && timer.isRunning()) {
            pigVelocity = JUMP_IMPULSE;
            isPigJumping = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            Pig pig = (Pig) sprites[1];
            Cactus cactus = (Cactus) sprites[2];

            if (isPigJumping) {
                pig.setY((int)(pig.getY() + pigVelocity * dt));
                pigVelocity += GRAVITY * dt;

                if (pig.getY() >= PIG_START_POINT) {
                    pig.setY(PIG_START_POINT);
                    pigVelocity = 0;
                    isPigJumping = false;
                }
            }

            cactus.setX((int)(cactus.getX() - CACTUS_SPEED * dt));
            if (cactus.getX() + cactus.getWidth() < 0) {
                cactus.setX(windowWidth);
            }

            if (pig.isCollided(cactus)) {
                timer.stop();

                Object[] options = {"Играть снова", "Выход"};

                int choice = JOptionPane.showOptionDialog(
                        null,
                        "свин погиб, ваш рекорд - " + mainWindow.getRecord(),
                        "Свиной побег 2D",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (choice == JOptionPane.YES_OPTION) {
                    mainWindow.startGame();
                } else {
                    System.exit(0);
                }
            }
        }
    }
}
