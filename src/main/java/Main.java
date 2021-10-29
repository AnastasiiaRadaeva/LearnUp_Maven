import ru.learnup.javaqa.learnupmvn.game.Game;

public class Main {
    public static void main(String[] args) {
        int[] speedsOfPlayers = new int[]{5, 0, 0, 7, 0, 9, 4};
        String[] playersInfo = new String[]{"Jane 4", "Leya 0", "Sam 9", "Sara 5", "Jack 1"};
        Game firstGame = new Game(false, 4);

        if (firstGame.play(speedsOfPlayers[0])) {
            System.out.println("Игрок со скоростью " + speedsOfPlayers[0] + " выбыл из игры");
        } else {
            System.out.println("Игрок со скоростью " + speedsOfPlayers[0] + " остался в игре");
        }
        System.out.print("\nСкорости игроков: ");
        for (int player : speedsOfPlayers) {
            System.out.print(player + " ");
        }
        System.out.println("\nВыбыло игроков: " + firstGame.countOfLose(speedsOfPlayers));
        System.out.print("Скорости выбывающих игроков: ");
        for (int speed : firstGame.speedsOfLose(speedsOfPlayers)) {
            System.out.print(speed + " ");
        }
        System.out.print("\nСкорости не выбывающих игроков: ");
        for (int speed : firstGame.speedsOfWin(speedsOfPlayers)) {
            System.out.print(speed + " ");
        }
        System.out.println();

        System.out.print("\nИмена и скорости игроков: ");
        for (int i = 0; i < playersInfo.length - 1; i++) {
            System.out.print(playersInfo[i] + ", ");
        }
        System.out.println(playersInfo[playersInfo.length - 1]);
        System.out.print("\nИмена выживших игроков: ");
        for (String name : firstGame.namesOfWin(playersInfo)) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}
