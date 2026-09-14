package com.dupaRecords.svinoiPobeg.Sprites;

import java.awt.*;

public interface Sprite {
    void setX(int x);
    void setY(int y);
    void setWidth(int width);
    void setHeight(int height);

    int getX();
    int getY();
    int getWidth();
    int getHeight();

    void draw(Graphics gr);
}
