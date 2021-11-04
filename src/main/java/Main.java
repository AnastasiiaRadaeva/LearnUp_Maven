import ru.learnup.javaqa.learnupmvn.game.Game;
import ru.learnup.javaqa.learnupmvn.game.SpeedyGame;
import ru.learnup.javaqa.learnupmvn.game.GameManager;

public class Main {
    public static void main(String[] args) {
        int[] speedsOfPlayers = new int[]{6, 0, 6, 0};
        boolean[] isGreenLight = new boolean[]{false, false, true, true};
        int[] speedOfOnePlayer = new int[]{0, 0, 2, 3, 4, 9, 0, 1};

        Game game = new Game(true);
        SpeedyGame speedyGame = new SpeedyGame(false, 5);
        GameManager managerGame = new GameManager(game);
        GameManager managerSpeedyGame = new GameManager(speedyGame);

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
        System.out.println("_______________________________________________");
        game.setIsGreenLight(false);
        speedyGame.setIsGreenLight(false);
        speedyGame.setMaxSpeed(3);
        System.out.println("Скорости игрока 1: 0, 0, 2, 3, 4, 9, 0, 1");
        System.out.println("Количество раундов, которые продержался " +
                "игрок 1 при стандартной игре: " + managerGame.countOfRounds(speedOfOnePlayer));
        System.out.println("Количество раундов, которые продержался " +
                "игрок 1 при быстрой игре: " + managerSpeedyGame.countOfRounds(speedOfOnePlayer));
    }
}
