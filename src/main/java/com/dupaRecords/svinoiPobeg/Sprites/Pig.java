package com.dupaRecords.svinoiPobeg.Sprites;

import java.awt.*;

public class Pig implements Sprite {

    private int x;
    private int y;
    private int width;
    private int height;

    public Pig(int x, int y, int width, int height) {
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

        // пятак
        g.setColor(Color.PINK);
        g.fillRect(x + width - width * 15 / 100,
                y +(height - height * 6 / 10) / 2,
                width * 15 / 100, height * 6 / 10);
        g.setColor(Color.BLACK);
        g.drawRect(x + width - width * 15 / 100,
                y + (height - height * 6 / 10) / 2,
                width * 15 / 100, height * 6 / 10);

        // ноги
        g.setColor(Color.PINK);
        g.fillRect(x + width / 10, y + height / 2,
                width * 2 / 10, height / 2);
        g.fillRect(x + width * 7 / 10, y + height / 2,
                width * 2 / 10, height / 2);
        g.setColor(Color.BLACK);
        g.drawRect(x + width / 10, y + height / 2,
                width * 2 / 10, height / 2);
        g.drawRect(x + width * 7 / 10, y + height / 2,
                width * 2 / 10, height / 2);

        // тело
        g.setColor(Color.PINK);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);

        // глаз
        g.setColor(Color.GREEN);
        g.fillOval(x + width * 7 / 10, y + height * 3 / 10,
                width / 10, height / 10);
        g.setColor(Color.BLACK);
        g.drawOval(x + width * 7 / 10, y + height * 3 / 10,
                width / 10, height / 10);
    }

    public boolean isCollided (Sprite other) {
        if (other == null) return false;

        return x < other.getX() + other.getWidth() &&
                x + width > other.getX() &&
                y < other.getY() + other.getHeight() &&
                y + height > other.getY();
    }
}