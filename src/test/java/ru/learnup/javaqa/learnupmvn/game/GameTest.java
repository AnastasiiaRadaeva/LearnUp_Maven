package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game(true);
    SpeedyGame speedyGame = new SpeedyGame(true, 5);
    GameManager managerGame = new GameManager(game);
    GameManager managerSpeedyGame = new GameManager(speedyGame);

    /*                                                 */
    /* --- test of getter and setter of Game class --- */
    /*                                                 */

    @Test
    public void checkOnDefaultG() {
        Assertions.assertTrue(game.getIsGreenLight(), "Проверка getIsGreenLight стандартной игры");
    }

    @Test
    public void checkWithSetG() {
        game.setIsGreenLight(false);
        Assertions.assertFalse(game.getIsGreenLight(), "Проверка getIsGreenLight " +
                "и setIsGreenLight стандартной игры");
    }

    /*                                                       */
    /* --- test of getter and setter of SpeedyGame class --- */
    /*                                                       */

    @Test
    public void checkOnDefaultLightSG() {
        Assertions.assertTrue(speedyGame.getIsGreenLight(), "Проверка getIsGreenLight быстрой игры");
    }

    @Test
    public void checkOnDefaultMaxSpeedSG() {
        int expectedMaxSpeed = 5;
        int actualMaxSpeed = speedyGame.getMaxSpeed();
        Assertions.assertEquals(expectedMaxSpeed, actualMaxSpeed, "Проверка getMaxSpeed быстрой игры");
    }

    @Test
    public void checkWithSetLightSG() {
        speedyGame.setIsGreenLight(false);
        Assertions.assertFalse(speedyGame.getIsGreenLight(), "Проверка getIsGreenLight " +
                "и setIsGreenLight быстрой игры");
    }

    @Test
    public void checkWithSetMaxSpeedSG() {
        int expectedMaxSpeed = 3;
        speedyGame.setMaxSpeed(expectedMaxSpeed);
        int actualMaxSpeed = speedyGame.getMaxSpeed();
        Assertions.assertEquals(expectedMaxSpeed, actualMaxSpeed,
                "Проверка getMaxSpeed и setIsGreenLight быстрой игры");
    }

    /*                                        */
    /* --- test of isFailed of Game class --- */
    /*                                        */

    @Test
    public void LightGreenSZeroG() {
        game.setIsGreenLight(true);
        Assertions.assertFalse(game.isFailed(0), "Проверка isFailed, " +
                "зелёный свет, скорость 0 стандартной игры");
    }

    @Test
    public void LightGreenG() {
        game.setIsGreenLight(true);
        Assertions.assertFalse(game.isFailed(3), "Проверка isFailed, " +
                "зелёный свет, скорость 3 стандартной игры");
    }

    @Test
    public void LightRedSZeroG() {
        game.setIsGreenLight(false);
        Assertions.assertFalse(game.isFailed(0), "Проверка isFailed, " +
                "красный свет, скорость 0 стандартной игры");
    }

    @Test
    public void LightRedG() {
        game.setIsGreenLight(false);
        Assertions.assertTrue(game.isFailed(3), "Проверка isFailed, " +
                "красный свет, скорость 3 стандартной игры");
    }

    /*                                              */
    /* --- test of isFailed of SpeedyGame class --- */
    /*                                              */

    @Test
    public void LightGreenSMaxSG() {
        speedyGame.setIsGreenLight(true);
        speedyGame.setMaxSpeed(3);
        Assertions.assertFalse(speedyGame.isFailed(3), "Проверка isFailed, " +
                "зелёный свет, максимальная скорость - 3, скорость 3 быстрой игры");
    }

    @Test
    public void LightGreenSG() {
        speedyGame.setIsGreenLight(true);
        speedyGame.setMaxSpeed(3);
        Assertions.assertFalse(speedyGame.isFailed(4), "Проверка isFailed, " +
                "зелёный свет, максимальная скорость - 3, скорость 4 быстрой игры");
    }

    @Test
    public void LightRedSMaxSG() {
        speedyGame.setIsGreenLight(false);
        speedyGame.setMaxSpeed(3);
        Assertions.assertFalse(speedyGame.isFailed(3), "Проверка isFailed, " +
                "красный свет, максимальная скорость - 3, скорость 3 быстрой игры");
    }

    @Test
    public void LightRedSG() {
        speedyGame.setIsGreenLight(false);
        speedyGame.setMaxSpeed(3);
        Assertions.assertTrue(speedyGame.isFailed(4), "Проверка isFailed, " +
                "красный свет, максимальная скорость - 3, скорость 4 быстрой игры");
    }

    /*                                                    */
    /* --- test of countOfRounds of GameManager class --- */
    /*                                                    */

    @Test
    public void managerGame() {
        int[] speedOfOnePlayer = new int[]{0, 0, 2, 3, 4, 9, 0, 1};
        game.setIsGreenLight(false);
        int expected = 2;
        int actual = managerGame.countOfRounds(speedOfOnePlayer);
        Assertions.assertEquals(expected, actual, "Проверка countOfRounds для стандартной игры:" +
                " игрок продержится 2 раунда");
    }

    @Test
    public void managerGameZeroRounds() {
        int[] speedOfOnePlayer = new int[]{3, 0, 0, 2, 3, 4, 9, 0, 1};
        game.setIsGreenLight(false);
        int expected = 0;
        int actual = managerGame.countOfRounds(speedOfOnePlayer);
        Assertions.assertEquals(expected, actual, "Проверка countOfRounds для стандартной игры:" +
                " игрок продержится 0 раундов");
    }

    @Test
    public void managerGameEmptyArray() {
        int[] speedOfOnePlayer = new int[]{};
        game.setIsGreenLight(false);
        int expected = 0;
        int actual = managerGame.countOfRounds(speedOfOnePlayer);
        Assertions.assertEquals(expected, actual, "Проверка countOfRounds:" +
                " пустой массив");
    }

    @Test
    public void managerSpeedyGame() {
        int[] speedOfOnePlayer = new int[]{0, 0, 2, 3, 4, 9, 0, 1};
        speedyGame.setIsGreenLight(false);
        speedyGame.setMaxSpeed(3);
        int expected = 4;
        int actual = managerSpeedyGame.countOfRounds(speedOfOnePlayer);
        Assertions.assertEquals(expected, actual, "Проверка countOfRounds для быстрой игры:" +
                " игрок продержится 4 раунда");
    }

    @Test
    public void managerSpeedyGameZeroRounds() {
        int[] speedOfOnePlayer = new int[]{5, 3, 0, 0, 2, 3, 4, 9, 0, 1};
        speedyGame.setIsGreenLight(false);
        speedyGame.setMaxSpeed(3);
        int expected = 0;
        int actual = managerSpeedyGame.countOfRounds(speedOfOnePlayer);
        Assertions.assertEquals(expected, actual, "Проверка countOfRounds для быстрой игры:" +
                " игрок продержится 0 раундов");
    }

    @Test
    public void managerSpeedyGameEmptyArray() {
        int[] speedOfOnePlayer = new int[]{0, 0, 2, 3, 4, 9, 0, 1};
        game.setIsGreenLight(false);
        speedyGame.setIsGreenLight(false);
        speedyGame.setMaxSpeed(3);
        int gameCount = managerGame.countOfRounds(speedOfOnePlayer);
        int speedyGameCount = managerSpeedyGame.countOfRounds(speedOfOnePlayer);
        Assertions.assertNotEquals(gameCount, speedyGameCount, "Проверка работы полиморфизма");
    }
}
