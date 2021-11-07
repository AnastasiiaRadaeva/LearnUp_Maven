package ru.learnup.javaqa.learnupmvn.game;

public class FastPlayer implements Moveable {
    private int startSpeed;
    private int speedStep;

    public FastPlayer(int startSpeed, int speedStep) {
        this.startSpeed = Math.max(startSpeed, 0);
        this.speedStep = speedStep;
    }

    @Override
    public int getSpeed() {
        int tmp = startSpeed;
        if (startSpeed + speedStep < 0) {
            startSpeed = 0;
        } else {
            startSpeed += speedStep;
        }
        return tmp;
    }
}
