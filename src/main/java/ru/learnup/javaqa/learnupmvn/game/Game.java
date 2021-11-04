package ru.learnup.javaqa.learnupmvn.game;

public class Game {

    protected boolean isGreenLight;

    public Game(boolean isGreenLight) {
        this.isGreenLight = isGreenLight;
    }

    public boolean getIsGreenLight() {
        return isGreenLight;
    }

    public void setIsGreenLight(boolean isGreenLight) {
        this.isGreenLight = isGreenLight;
    }

    public boolean isFailed(int speed) {
        return speed > 0 && !isGreenLight;
    }
}