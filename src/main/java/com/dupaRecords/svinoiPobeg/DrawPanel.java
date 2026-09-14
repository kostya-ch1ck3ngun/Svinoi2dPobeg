package com.dupaRecords.svinoiPobeg;

import com.dupaRecords.svinoiPobeg.Sprites.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel implements ActionListener {
    private final MainWindow mainWindow;
    private final Timer timer;
    private final Sprite[] sprites;
    private final int fps;
    private final Font font = new Font("Impact", Font.BOLD, 30);
    private int ticksFromStart = 0;
    private int secondsFromStart = 0;

    public DrawPanel(Timer timer, Sprite[] sprites, int fps, MainWindow mainWindow) {
        this.timer = timer;
        this.sprites = sprites;
        this.fps = fps;
        this.mainWindow = mainWindow;
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        for (Sprite sprite : sprites) {
            sprite.draw(gr);
        }
        gr.setColor(Color.BLACK);
        gr.setFont(font);
        gr.drawString("Время: " + secondsFromStart + ", Ваш рекорд: " + mainWindow.getRecord(), 10, 35);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;

            if (ticksFromStart % fps == 0) {
                secondsFromStart++;
                mainWindow.setRecord();
            }
        }
    }

    public int getSecondsFromStart () {
        return secondsFromStart;
    }
}