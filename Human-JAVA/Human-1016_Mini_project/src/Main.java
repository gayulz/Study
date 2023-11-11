import minigame.*;
import java.util.Scanner;

import static minigame.Emoji.RollBook;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RollBook();
        new miniKeyGame(in.nextLine());
    }
}
