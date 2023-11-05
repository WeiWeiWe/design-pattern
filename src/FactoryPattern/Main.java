package FactoryPattern;

import java.util.Scanner;

abstract class Cake {
    public abstract void aboutCake();
}

class BlueBerry extends Cake {
    @Override
    public void aboutCake() {
        System.out.println("Blue Berry cake");
    }
}

class BlackForest extends Cake {
    @Override
    public void aboutCake() {
        System.out.println("Black Forest cake");
    }
}

class PineApple extends Cake {
    @Override
    public void aboutCake() {
        System.out.println("Pine Apple cake");
    }
}

interface Factory {
    Cake createCake(String cakeName);
}

class CakeFactory implements Factory {
    @Override
    public Cake createCake(String cakeName) {
        Cake cake = null;
        if (cakeName.equals("BlueBerry")) {
            cake = new BlueBerry();
        } else if (cakeName.equals("BlackForest")) {
            cake = new BlackForest();
        } else if (cakeName.equals("PineApple")) {
            cake = new PineApple();
        }
        return cake;
    }
}

public class Main {
    public static void main(String[] args) {
        Cake cake = null;

        System.out.println("What cake would you like?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        scanner.close();

        CakeFactory cakeFactory = new CakeFactory();
        cake = cakeFactory.createCake(choice);
        if (cake != null) {
            cake.aboutCake();
        }
    }
}
