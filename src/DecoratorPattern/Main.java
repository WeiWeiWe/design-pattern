package DecoratorPattern;

abstract class Beverage {
    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public void style() {
        System.out.println("This is a Taiwanese style coffee.");
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 250;
    }
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 150;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 300;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 125;
    }
}

abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    @Override
    public abstract String getDescription();
}

class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
     return this.beverage.cost() + 50;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    @Override
    public void style() {
        super.style();
        System.out.println("Also, it has italian style...");
    }
}

class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 25;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Soy";
    }
}

class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 15;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Whip";
    }
}

class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 75;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Milk";
    }
}

public class Main {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        espresso = new Milk(espresso);
        espresso = new Mocha(espresso);
        System.out.println(espresso.getDescription());
        System.out.println(espresso.cost());
        espresso.style();
    }
}
