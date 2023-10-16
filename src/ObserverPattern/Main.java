package ObserverPattern;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;

public class Main extends JPanel implements TickListener {
    private ArrayList<RedPanda> redPandas = new ArrayList<>();
    private ArrayList<Dog> dogs = new ArrayList<>();
    private Timer timer;
    private int speed = 100;
    private TimerMission tm1 = new TimerMission(); // subject
    private TimerMission tm2 = new TimerMission(); // subject

    public Main() {
        timer = new Timer();
        timer.scheduleAtFixedRate(tm1, 0, speed);
        timer.scheduleAtFixedRate(tm2, 150, speed + 500);

        redPandas.add(new RedPanda(30,30));
        redPandas.add(new RedPanda(230,230));
        redPandas.add(new RedPanda(90,100));
        for (RedPanda rp : redPandas) {
            tm1.register(rp);
        }
        tm1.register(this);


        dogs.add(new Dog(200, 100));
        dogs.add(new Dog(300, 50));
        dogs.add(new Dog(400, 400));
        for (Dog dog : dogs) {
            tm2.register(dog);
        }
        tm2.register(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (RedPanda rp : redPandas) {
            rp.draw(g);
        }
        for (Dog dog : dogs) {
            dog.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setContentPane(new Main());
        window.setVisible(true);
    }

    @Override
    public void tick() {
        repaint();
    }
}
