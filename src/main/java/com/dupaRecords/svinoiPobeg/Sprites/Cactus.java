package com.dupaRecords.svinoiPobeg.Sprites;

import java.awt.*;

public class Cactus implements Sprite {

    private int x;
    private int y;
    private int width;
    private int height;

    public Cactus(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        // левая ветка
        g.setColor(Color.GREEN);
        g.fillRect(x, y + height / 2,
                width / 2, height / 10);
        g.setColor(Color.BLACK);
        g.drawRect(x, y + height / 2,
                width / 2, height / 10);

        g.setColor(Color.GREEN);
        g.fillRect(x, y + height / 5,
                width / 5, height * 4 / 10);
        g.setColor(Color.BLACK);
        g.drawRect(x, y + height / 5,
                width / 5, height * 4 / 10);

        // правая ветка
        g.setColor(Color.GREEN);
        g.fillRect(x + width / 2, y + height * 6 / 10,
                width / 2, height / 10);
        g.setColor(Color.BLACK);
        g.drawRect(x + width / 2, y + height * 6 / 10,
                width / 2, height / 10);

        g.setColor(Color.GREEN);
        g.fillRect(x + width * 4 / 5, y + height * 3 / 10,
                width / 5, height * 4 / 10);
        g.setColor(Color.BLACK);
        g.drawRect(x + width * 4 / 5, y + height * 3 / 10,
                width / 5, height * 4 / 10);

        // ствол
        g.setColor(Color.GREEN);
        g.fillRect(x + width / 3, y, width / 3, height);
        g.setColor(Color.BLACK);
        g.drawRect(x + width / 3, y, width / 3, height);
    }
}
