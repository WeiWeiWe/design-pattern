package StrategyPattern;

interface FlyStrategy {
    void fly();
}

interface QuackStrategy {
    void quack();
}

// concrete strategies
class FlyNoWay implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("不能飛");
    }
}

class FlyWithWings implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("用翅膀飛");
    }
}

class FlyWithRockets implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("用火箭飛");
    }
}

class Quack implements QuackStrategy {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}

class MuteQuack implements QuackStrategy {
    @Override
    public void quack() {
        System.out.println("無法發出聲音");
    }
}

class Duck {
    protected FlyStrategy flyStrategy;
    protected QuackStrategy quackStrategy;

    public Duck() {
        // 預設行為
        flyStrategy = new FlyWithWings();
        quackStrategy = new Quack();
    }

    public void performFly() {
        flyStrategy.fly();
    }

    public void performQuack() {
        quackStrategy.quack();
    }

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public void setQuackStrategy(QuackStrategy quackStrategy) {
        this.quackStrategy = quackStrategy;
    }
}

/**
 * 策略模式
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.performFly();
        duck.performQuack();

        System.out.println("==============");
        duck.setFlyStrategy(new FlyWithRockets());
        duck.setQuackStrategy(new MuteQuack());
        duck.performFly();
        duck.performQuack();
    }
}
