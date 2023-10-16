package ObserverPattern;

import javax.swing.*;
import java.awt.*;

public class Dog implements TickListener {
    private Point point;
    private ImageIcon dog = new ImageIcon("src/ObserverPattern/dog.png");

    public Dog(int x, int y) {
        point = new Point(x, y);
    }

    public void dance() {
        int newX = (int) (Math.random() * 10 - 5);
        int newY = (int) (Math.random() * 10 - 5);
        point.x += newX;
        point.y += newY;
    }

    public void draw(Graphics g) {
        dog.paintIcon(null, g, point.x, point.y);
    }

    @Override
    public void tick() {
        dance();
    }
}
