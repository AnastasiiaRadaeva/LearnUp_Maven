package ru.learnup.javaqa.learnupmvn.game;

public class Game {

    boolean isGreenLight;
    int MAX_SPEED;

    public Game(boolean isGreenLight, int MAX_SPEED) {
        this.isGreenLight = isGreenLight;
        this.MAX_SPEED = MAX_SPEED;
    }

    public boolean play(int speedOfPlayer) {
        return !isGreenLight && speedOfPlayer > MAX_SPEED;
    }

    public int countOfLose(int[] speedsOfPlayers) {
        int count = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if (playerSpeed > MAX_SPEED && !isGreenLight) {
                count++;
            }
        }
        return count;
    }

    public int[] speedsOfLose(int[] speedsOfPlayers) {
        int[] speeds = new int[countOfLose(speedsOfPlayers)];
        int index = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if (playerSpeed > MAX_SPEED && !isGreenLight) {
                speeds[index++] = playerSpeed;
            }
        }
        return speeds;
    }

    public int[] speedsOfWin(int[] speedsOfPlayers) {
        int[] speeds = new int[speedsOfPlayers.length - countOfLose(speedsOfPlayers)];
        int index = 0;

        for (int playerSpeed : speedsOfPlayers) {
            if ((playerSpeed <= MAX_SPEED && !isGreenLight) || isGreenLight) {
                speeds[index++] = playerSpeed;
            }
        }
        return speeds;
    }

    public String[] namesOfWin(String[] playersInfo) {
        int[] speeds = new int[playersInfo.length];

        for (int i = 0; i < playersInfo.length; i++) {
            speeds[i] = Integer.parseInt((playersInfo[i].split(" "))[1]);
        }

        String[] playerInfo = new String[2];
        String[] Winners = new String[playersInfo.length - countOfLose(speeds)];
        int index = 0;

        for (String player : playersInfo) {
            playerInfo = player.split(" ");
            if ((Integer.parseInt(playerInfo[1]) <= MAX_SPEED && !isGreenLight) || isGreenLight) {
                Winners[index++] = playerInfo[0];
            }
        }
        return Winners;
    }
}