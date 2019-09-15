import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.SQLOutput;

public class Main {
    public static final String NEW_AI_GAME = "Nowa gra z komputeram";
    public static final String NEW_HUMAN_GAME = "Nowa gra z drugim graczem";
    public static final String EXIT_GAME = "Wyjście";

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addElement(NEW_AI_GAME);
        menu.addElement(NEW_HUMAN_GAME);
        menu.addElement(EXIT_GAME);

        TicTacToeController game;
        mainLoop:
        while (true) {
            switch (menu.getChoice()) {
                case NEW_AI_GAME:
                    game = new TicTacToeController(new HumanPlayer(new XPawn()), new AIPlayer(new OPawn()));
                    game.start();
                    break;
                case NEW_HUMAN_GAME:
                    game = new TicTacToeController(new HumanPlayer(new XPawn()), new HumanPlayer(new OPawn()));
                    game.start();
                    break;

                case EXIT_GAME:

                    break mainLoop;
            }
        }
    }
}
