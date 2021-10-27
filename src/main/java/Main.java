import ru.learnup.javaqa.learnupmvn.game.Game;

public class Main {
    public static void main(String[] args) {
        int[] speedsOfPlayers = new int[]{5, 0, 0, 7, 0, 9, 4};

        if (Game.play(speedsOfPlayers[0])) {
            System.out.println("Игрок со скоростью " + speedsOfPlayers[0] + " выбыл из игры");
        } else {
            System.out.println("Игрок со скоростью " + speedsOfPlayers[0] + " остался в игре");
        }
        System.out.print("\nСкорости игроков: ");
        for (int player : speedsOfPlayers) {
            System.out.print(player + " ");
        }
        System.out.println("\nВыбыло игроков: " + Game.countOfLose(speedsOfPlayers));
        System.out.print("Скорости выбывающих игроков: ");
        for (int speed : Game.speedsOfLose(speedsOfPlayers)) {
            System.out.print(speed + " ");
        }
        System.out.print("\nСкорости не выбывающих игроков: ");
        for (int speed : Game.speedsOfWin(speedsOfPlayers)) {
            System.out.print(speed + " ");
        }
        System.out.println();
    }
}
