package org.example.structural;

abstract class Game {
    abstract void initialize();

    abstract void start();

    abstract void end();

    public final void play() {
        initialize();
        start();
        end();
    }
}

class Chess extends Game {

    @Override
    void initialize() {
        System.out.println("game of chess initialized");
    }

    @Override
    void start() {
        System.out.println("game of chess started");
    }

    @Override
    void end() {
        System.out.println("game of chess finished");
    }
}

class BasketBall extends Game {

    @Override
    void initialize() {
        System.out.println("game of basketBall initialized");
    }

    @Override
    void start() {
        System.out.println("game of basketBall started");
    }

    @Override
    void end() {
        System.out.println("game of basketBall finished");
    }
}

public class Template {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Class chess = Class.forName("org.example.structural.Chess");
        Game mChessGame = (Game) chess.newInstance();
        mChessGame.play();

        Class basketball = Class.forName("org.example.structural.BasketBall");
        Game mBasketballGame = (Game) basketball.newInstance();
        mBasketballGame.play();

    }
}
