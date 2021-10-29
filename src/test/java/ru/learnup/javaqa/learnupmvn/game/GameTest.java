package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game firstGame = new Game(false, 4);
    Game secondGame = new Game(true, 4);

    //test of play method
    @Test
    public void positiveSpeed() {
        boolean result = firstGame.play(9);
        Assertions.assertTrue(result, "Скорость положительна - игрок выбывает");
    }

    @Test
    public void ziroSpeed() {
        boolean result = firstGame.play(0);
        Assertions.assertFalse(result, "Скорость нулевая - игрок остается в игре");
    }

    @Test
    public void greenLight() {
        boolean result = secondGame.play(6);
        Assertions.assertFalse(result, "Скорость выше максимальной, свет зелёный - игрок остается в игре");
    }

    //test of play method with MAX_SPEED
    @Test
    public void aboveMaxSpeed() {
        boolean result = firstGame.play(5);
        Assertions.assertTrue(result, "Скорость выше максимальной - игрок выбывает");
    }

    @Test
    public void maxSpeed() {
        boolean result = firstGame.play(4);
        Assertions.assertFalse(result, "Скорость равна максимальной - игрок остается в игре");
    }

    @Test
    public void underMaxSpeed() {
        boolean result = firstGame.play(3);
        Assertions.assertFalse(result, "Скорость ниже максимальной - игрок остается в игре");
    }

    //test of countOfLose method + MAX_SPEED
    @Test
    public void existLosePlayersCOL() {
        int[] speedOfPlayers = new int[]{5, 0, 0, 8, 7};
        Assertions.assertEquals(3, firstGame.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: 3");
    }

    @Test
    public void notExistLosePlayersCOL() {
        int[] speedOfPlayers = new int[]{0, 0, 3, 2, 1};
        Assertions.assertEquals(0, firstGame.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: 0");
    }

    @Test
    public void onlyLosePlayersCOL() {
        int[] speedOfPlayers = new int[]{8, 9, 7, 5};
        Assertions.assertEquals(4, firstGame.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: 0");
    }

    @Test
    public void emptyArrayCOL() {
        int[] speedOfPlayers = new int[]{};
        Assertions.assertEquals(0, firstGame.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: пустой массив");
    }

    @Test
    public void greenLightCOL() {
        int[] speedOfPlayers = new int[]{8, 9, 7, 5};
        Assertions.assertEquals(0, secondGame.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: 0");
    }

    //test of speedsOfLose method + MAX_SPEED
    @Test
    public void existLosePlayersSOL() {
        int[] speedOfPlayers = new int[]{5, 0, 0, 8, 7};
        int[] speedOfLose = new int[]{5, 8, 7};
        Assertions.assertArrayEquals(speedOfLose, firstGame.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игоков: есть выбывшие");
    }

    @Test
    public void notExistLosePlayersSOL() {
        int[] speedOfPlayers = new int[]{0, 0, 1, 2, 3};
        int[] speedOfLose = new int[0];
        Assertions.assertArrayEquals(speedOfLose, firstGame.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игороков: нет выбывших");
    }

    @Test
    public void onlyLosePlayersSOL() {
        int[] speedOfPlayers = new int[]{8, 9, 7, 5};
        Assertions.assertArrayEquals(speedOfPlayers, firstGame.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игороков: только выбывшие");
    }

    @Test
    public void emptyArraySOL() {
        int[] speedOfPlayers = new int[]{};
        int[] speedOfLose = new int[0];
        Assertions.assertArrayEquals(speedOfLose, firstGame.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игороков: пустой массив");
    }

    @Test
    public void greenLightSOL() {
        int[] speedOfPlayers = new int[]{5, 0, 0, 8, 7};
        int[] speedOfLose = new int[0];
        Assertions.assertArrayEquals(speedOfLose, secondGame.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игоков: нет выбывших");
    }

    //test of speedsOfWin method + MAX_SPEED
    @Test
    public void existWinPlayersSOW() {
        int[] speedOfPlayers = new int[]{5, 0, 0, 8, 7, 4, 1};
        int[] speedOfWin = new int[]{0, 0, 4, 1};
        Assertions.assertArrayEquals(speedOfWin, firstGame.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игоков: есть не выбывшие");
    }

    @Test
    public void notExistWinPlayersSOW() {
        int[] speedOfPlayers = new int[]{8, 8, 9, 5};
        int[] speedOfWin = new int[0];
        Assertions.assertArrayEquals(speedOfWin, firstGame.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игороков: нет не выбывших");
    }

    @Test
    public void onlyWinPlayersSOW() {
        int[] speedOfPlayers = new int[]{0, 0, 0, 1, 4, 3, 2};
        Assertions.assertArrayEquals(speedOfPlayers, firstGame.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игороков: только не выбывшие");
    }

    @Test
    public void emptyArraySOW() {
        int[] speedOfPlayers = new int[]{};
        int[] speedOfWin = new int[0];
        Assertions.assertArrayEquals(speedOfWin, firstGame.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игороков: пустой массив");
    }

    @Test
    public void greenLightSOW() {
        int[] speedOfPlayers = new int[]{0, 0, 0, 1, 6, 3, 2};
        Assertions.assertArrayEquals(speedOfPlayers, secondGame.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игороков: только не выбывшие");
    }

    //test of namesOfWin method + MAX_SPEED
    @Test
    public void existWinPlayersNOW() {
        String[] playersInfo = new String[]{"Jane 4", "Leya 0", "Sam 9", "Sara 5", "Jack 1"};
        String[] winPlayersName = new String[]{"Jane", "Leya", "Jack"};
        Assertions.assertArrayEquals(winPlayersName, firstGame.namesOfWin(playersInfo), "Проверка на верный массив имён выживших игоков: есть выжившие");
    }

    @Test
    public void notExistWinPlayersNOW() {
        String[] playersInfo = new String[]{"Jane 6", "Leya 7", "Sam 9", "Sara 5", "Jack 15"};
        String[] winPlayersName = new String[0];
        Assertions.assertArrayEquals(winPlayersName, firstGame.namesOfWin(playersInfo), "Проверка на верный массив имён выживших игоков: нет выживших");
    }

    @Test
    public void onlyWinPlayersNOW() {
        String[] playersInfo = new String[]{"Jane 4", "Leya 0", "Sam 2", "Sara 3", "Jack 1"};
        String[] winPlayersName = new String[]{"Jane", "Leya", "Sam", "Sara", "Jack"};
        Assertions.assertArrayEquals(winPlayersName, firstGame.namesOfWin(playersInfo), "Проверка на верный массив имён выживших игоков: только выжившие");
    }

    @Test
    public void emptyArrayNOW() {
        String[] playersInfo = new String[0];
        String[] winPlayersName = new String[0];
        Assertions.assertArrayEquals(winPlayersName, firstGame.namesOfWin(playersInfo), "Проверка на верный массив имён выживших игоков: пустой массив");
    }

    @Test
    public void greenLightNOW() {
        String[] playersInfo = new String[]{"Jane 8", "Leya 0", "Sam 7", "Sara 3", "Jack 1"};
        String[] winPlayersName = new String[]{"Jane", "Leya", "Sam", "Sara", "Jack"};
        Assertions.assertArrayEquals(winPlayersName, secondGame.namesOfWin(playersInfo), "Проверка на верный массив имён выживших игоков: только выжившие");
    }
}
