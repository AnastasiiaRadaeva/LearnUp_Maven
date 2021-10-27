package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    //test of play method
    @Test
    public void positiveSpeed() {
        boolean result = Game.play(9);
        Assertions.assertTrue(result, "Скорость положительна - игрок выбывает");
    }

    @Test
    public void ziroSpeed() {
        boolean result = Game.play(5);
        Assertions.assertFalse(result, "Скорость нулевая - игрок остается в игре");
    }

    //test of countOfLose method
    @Test
    public void existLosePlayersCOL() {
        int[] speedOfPlayers = new int[]{5, 0, 0, 8, 7};
        Assertions.assertEquals(3, Game.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: 3");
    }

    @Test
    public void notExistLosePlayersCOL() {
        int[] speedOfPlayers = new int[]{0, 0};
        Assertions.assertEquals(0, Game.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: 0");
    }

    @Test
    public void onlyLosePlayersCOL() {
        int[] speedOfPlayers = new int[]{8, 9, 7};
        Assertions.assertEquals(3, Game.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: 0");
    }

    @Test
    public void emptyArrayCOL() {
        int[] speedOfPlayers = new int[]{};
        Assertions.assertEquals(0, Game.countOfLose(speedOfPlayers), "Проверка на верный подсчёт выбывающих игроков: пустой массив");
    }

    //test of speedsOfLose method
    @Test
    public void existLosePlayersSOL() {
        int[] speedOfPlayers = new int[]{5, 0, 0, 8, 7};
        int[] speedOfLose = new int[]{5, 8, 7};
        Assertions.assertArrayEquals(speedOfLose, Game.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игоков: есть выбывшие");
    }

    @Test
    public void notExistLosePlayersSOL() {
        int[] speedOfPlayers = new int[]{0, 0};
        int[] speedOfLose = new int[0];
        Assertions.assertArrayEquals(speedOfLose, Game.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игороков: нет выбывших");
    }

    @Test
    public void onlyLosePlayersSOL() {
        int[] speedOfPlayers = new int[]{8, 9, 7};
        Assertions.assertArrayEquals(speedOfPlayers, Game.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игороков: только выбывшие");
    }

    @Test
    public void emptyArraySOL() {
        int[] speedOfPlayers = new int[]{};
        int[] speedOfLose = new int[0];
        Assertions.assertArrayEquals(speedOfLose, Game.speedsOfLose(speedOfPlayers), "Проверка на верный массив выбывших игороков: пустой массив");
    }

    //test of speedsOfWin method
    @Test
    public void existWinPlayersSOW() {
        int[] speedOfPlayers = new int[]{5, 0, 0, 8, 7};
        int[] speedOfWin = new int[]{0, 0};
        Assertions.assertArrayEquals(speedOfWin, Game.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игоков: есть не выбывшие");
    }

    @Test
    public void notExistWinPlayersSOW() {
        int[] speedOfPlayers = new int[]{8, 8, 9};
        int[] speedOfWin = new int[0];
        Assertions.assertArrayEquals(speedOfWin, Game.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игороков: нет не выбывших");
    }

    @Test
    public void onlyWinPlayersSOW() {
        int[] speedOfPlayers = new int[]{0, 0, 0};
        Assertions.assertArrayEquals(speedOfPlayers, Game.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игороков: только не выбывшие");
    }

    @Test
    public void emptyArraySOW() {
        int[] speedOfPlayers = new int[]{};
        int[] speedOfWin = new int[0];
        Assertions.assertArrayEquals(speedOfWin, Game.speedsOfWin(speedOfPlayers), "Проверка на верный массив не выбывших игороков: пустой массив");
    }
}
