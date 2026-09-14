package com.dupaRecords.svinoiPobeg.Sprites;

import java.awt.*;

public class Background implements Sprite {

    private int x;
    private int y;
    private int width;
    private int height;
    private final Color skyColor = new Color(0, 220, 255);
    private final Color sunColor = new Color(255, 180, 0);
    private final Color groundColor = new Color(255, 255, 128);

    public Background(int x, int y, int width, int height) {
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

        // небо
        g.setColor(skyColor);
        g.fillRect(x, y, width, height);

        // солнце
        g.setColor(sunColor);
        g.fillOval(height / 20, height / 20, height * 25 / 100, height * 25 / 100);
        g.setColor(Color.BLACK);
        g.drawOval(height / 20, height / 20, height * 25 / 100, height * 25 / 100);

        // земля
        g.setColor(groundColor);
        g.fillRect(x,height - height * 3 / 10,
                width, height * 3 / 10);
        g.setColor(Color.BLACK);
        g.fillRect(x,height - height * 3 / 10 - 2,
                width, 4);
    }
}
