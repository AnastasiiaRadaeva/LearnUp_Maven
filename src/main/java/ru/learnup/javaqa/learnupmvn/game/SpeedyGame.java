package ru.learnup.javaqa.learnupmvn.game;

public class SpeedyGame extends Game {

    private int maxSpeed;

    public SpeedyGame(boolean isGreenLight, int maxSpeed) {
        super(isGreenLight);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean isFailed(int speed) {
        return !isGreenLight && speed > maxSpeed;
    }
}
