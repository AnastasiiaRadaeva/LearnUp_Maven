package ru.learnup.javaqa.learnupmvn.game;

public class Game {

    static boolean isGreenLight = false;
    static int MAX_SPEED = 4; //не может быть меньше 0

    public static boolean play(int speedOfPlayer) {

        if (!isGreenLight && speedOfPlayer > MAX_SPEED) {
            return true;
        }
        return false;
    }

    public static int countOfLose(int[] speedsOfPlayers) {
        int count = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if (playerSpeed > MAX_SPEED && !isGreenLight) {
                count++;
            }
        }
        return count;
    }

    public static int[] speedsOfLose(int[] speedsOfPlayers) {
        int[] speeds = new int[countOfLose(speedsOfPlayers)];
        int index = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if (playerSpeed > MAX_SPEED && !isGreenLight) {
                speeds[index++] = playerSpeed;
            }
        }
        return speeds;
    }

    public static int[] speedsOfWin(int[] speedsOfPlayers) {
        int[] speeds = new int[speedsOfPlayers.length - countOfLose(speedsOfPlayers)];
        int index = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if ((playerSpeed <= MAX_SPEED && !isGreenLight) || isGreenLight) {
                speeds[index++] = playerSpeed;
            }
        }
        return speeds;
    }
}