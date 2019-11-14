package GUI2;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
public interface Drawable
{
    void drawSelf(Graphics2D g2);
    void changeXY(int a, int b);
    void changeY(int b);
    void defaultXY();
    void drawSelf(Graphics2D g2,int x1, int y1, int width1, int height1);
}
 