package org.example.creational;

import java.util.HashMap;
import java.util.Map;

abstract class Colour implements Cloneable {
    protected String color;

    abstract void addColour();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class blueColour extends Colour {
    public blueColour() {
        this.color = "blue";
    }

    @Override
    void addColour() {
        System.out.println("blue colour added");
    }
}

class redColour extends Colour {
    public redColour() {
        this.color = "red";
    }

    @Override
    void addColour() {
        System.out.println("red colour added");
    }
}

class ColourStore {
    private static Map<String, Colour> colorMap = new HashMap<>();

    static {
        colorMap.put("blue", new blueColour());
        colorMap.put("red", new redColour());
    }

    public static Colour getColor(String mColourName) {
        return (Colour) colorMap.get(mColourName).clone();
    }
}

public class Prototype {

    public static void main(String args[]) {

        ColourStore.getColor("red").addColour();
        ColourStore.getColor("blue").addColour();
    }
}
