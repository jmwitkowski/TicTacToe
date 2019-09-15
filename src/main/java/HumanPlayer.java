import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(Pawn pawn) {
        super(pawn);
    }

    @Override
    public int getMove(Board board) {
        System.out.println("Wybierz pole");
        return scanner.nextInt();
    }
}
