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

    public int loser(Moveable p1, Moveable p2, Game game, int rounds) {
        for (int i = 0; i < rounds; i++) {
            if (game.isFailed(p1.getSpeed())) {
                return -1;
            }
            if (game.isFailed(p2.getSpeed())) {
                return 1;
            }
        }
        return 0;
    }
}
