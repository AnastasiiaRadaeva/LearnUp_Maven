package ru.learnup.javaqa.learnupmvn.game;

public class Game {

    static boolean isGreenLight = false;

    public static boolean play(int speedOfPlayer) {

        if (!isGreenLight && speedOfPlayer > 0) {
            return true;
        }
        return false;
    }

    public static int countOfLose(int[] speedsOfPlayers) {
        int count = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if (playerSpeed > 0 && !isGreenLight) {
                count++;
            }
        }
        return count;
    }

    public static int[] speedsOfLose(int[] speedsOfPlayers) {
        int[] speeds = new int[countOfLose(speedsOfPlayers)];
        int index = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if (playerSpeed > 0 && !isGreenLight) {
                speeds[index++] = playerSpeed;
            }
        }
        return speeds;
    }

    public static int[] speedsOfWin(int[] speedsOfPlayers) {
        int[] speeds = new int[speedsOfPlayers.length - countOfLose(speedsOfPlayers)];
        int index = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if ((playerSpeed == 0 && !isGreenLight) || isGreenLight) {
                speeds[index++] = playerSpeed;
            }
        }
        return speeds;
    }
}