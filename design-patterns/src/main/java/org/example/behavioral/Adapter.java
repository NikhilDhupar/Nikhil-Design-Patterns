package org.example.behavioral;

interface Bird {
    void birdMakeSound();
}

class Sparrow implements Bird {

    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void birdMakeSound() {
        System.out.println("Chirp...");
    }
}

interface Duck {
    void squeakk();
}

class PlasticDuck implements Duck {

    @Override
    public void squeakk() {
        System.out.println("Squeakk...");
    }
}

class BirdAdapter implements Duck {
    Bird bird;

    public BirdAdapter(Bird b) {
        this.bird = b;
    }

    @Override
    public void squeakk() {
        bird.birdMakeSound();
    }
}

public class Adapter {
    public static void main(String args[]) {
        Sparrow sparrow = new Sparrow();
        Duck duck = new PlasticDuck();
        Duck birdAdapt = new BirdAdapter(sparrow);

        System.out.println("Sparrow");
        sparrow.fly();
        sparrow.birdMakeSound();

        System.out.println("Duck");
        duck.squeakk();

        System.out.println("Bird Adapter");
        birdAdapt.squeakk();
    }
}
