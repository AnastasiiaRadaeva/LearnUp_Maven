import ru.learnup.javaqa.learnupmvn.game.Game;
import ru.learnup.javaqa.learnupmvn.game.SpeedyGame;

public class Main {
    public static void main(String[] args) {
        int[] speedsOfPlayers = new int[]{6, 0, 6, 0};
        boolean[] isGreenLight = new boolean[]{false, false, true, true};

        Game game = new Game(true);
        SpeedyGame speedyGame = new SpeedyGame(false, 5);

        System.out.println("Стандартная игра: зелёный свет, скорость - 5: игрок " +
                (game.isFailed(5) ? "проиграл" : "выиграл"));
        System.out.println("Быстрая игра: максимальная скорость - 5, " +
                "красный свет, скорость - 7: игрок " +
                (speedyGame.isFailed(7) ? "проиграл" : "выиграл"));
        System.out.println();

        for (int i = 0; i < speedsOfPlayers.length; i++) {
            game.setIsGreenLight(isGreenLight[i]);
            speedyGame.setIsGreenLight(isGreenLight[i]);
            System.out.println("Стандартная игра: " + (isGreenLight[i] ? "зеленый" : "красный")
                    + " свет, скорость - " + speedsOfPlayers[i] + ": игрок " +
                    (game.isFailed(speedsOfPlayers[i]) ? "проиграл" : "выиграл"));
            System.out.println("Быстрая игра: максимальная скорость - 5, " +
                    (isGreenLight[i] ? "зеленый" : "красный") + " свет, скорость - "
                    + speedsOfPlayers[i] + ": игрок " +
                    (speedyGame.isFailed(speedsOfPlayers[i]) ? "проиграл" : "выиграл"));
            System.out.println();
        }
    }
}
