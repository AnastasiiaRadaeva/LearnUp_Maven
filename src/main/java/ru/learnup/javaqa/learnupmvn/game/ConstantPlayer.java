package ru.learnup.javaqa.learnupmvn.game;

public class ConstantPlayer implements Moveable {
    private int speed;

    public ConstantPlayer(int speed) {
        this.speed = Math.max(speed, 0);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
