package ru.learnup.javaqa.learnupmvn.game;

public class GameManager {
    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public int countOfRounds(int[] payerSpeeds) { //подсчёт заканчивается, когда игрок выбывает
        int roundsCount = 0;

        for (int speed : payerSpeeds) {
            if (game.isFailed(speed)) {
                break;
            } else {
                roundsCount++;
            }
        }
        return roundsCount;
    }
}
