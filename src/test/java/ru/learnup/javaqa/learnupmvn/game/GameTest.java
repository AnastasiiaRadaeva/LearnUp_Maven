package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game(true);
    SpeedyGame speedyGame = new SpeedyGame(true, 5);

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
}
