import java.util.ArrayList;
import java.util.List;

public class TicTacToeController {
    private Board gameState;
    private List<Player> players;
    private Judge judge;
    public TicTacToeController(Player firstPlayer, Player secondPlayer) {
        this.gameState = new Board(3, 3);
        this.gameState.displayBoard();
        players = new ArrayList<>();
        this.players.add(firstPlayer);
        this.players.add(secondPlayer);
        this.judge = new Judge(this.gameState);

    }

    public void start(){
        Player currentPlayer;
        int moveCounter = 0;
        while(!judge.isEndGame()){
            currentPlayer = players.get(moveCounter%2);
            int move = currentPlayer.getMove(gameState);
           if( !MoveValidator.validate(gameState, move)){
               System.out.println("Nieprawidłowy ruch");
               continue;
           }
            gameState.putPawn(move, currentPlayer.getPawn());
            gameState.displayBoard();
            judge.setGameState(gameState);
            moveCounter++;
        }

        System.out.println("Koniec gry");
        for(Player player : players){
            if(judge.isWinFor(player.getPawn())){
                System.out.println("Wygrał gracz " + player.getPawn().getName());
            } else if(judge.isDraw()){
                System.out.println("Remis");
            }
        }
    }
}
