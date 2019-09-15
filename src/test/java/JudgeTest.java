import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JudgeTest {
    private Board board;
    private Judge judge;
    @BeforeEach
    void setUp() {
        board = new Board(3,3);
        judge = new Judge(board);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void drawTest() {
        Pawn xPawn = new XPawn();
        Pawn oPawn = new OPawn();
        board.putPawn(1,xPawn);
        board.putPawn(2,oPawn);
        board.putPawn(3,xPawn);
        board.putPawn(4,oPawn);
        board.putPawn(5,xPawn);
        board.putPawn(6,oPawn);
        board.putPawn(7,xPawn);
        board.putPawn(8,oPawn);
        board.putPawn(9,xPawn);

        judge.setGameState(board);

        assertTrue(judge.isDraw());
    }
    @Test
    public void xPawnHorizontalWinTest(){
        Pawn xPawn = new XPawn();
        board.putPawn(1,xPawn);
        board.putPawn(2,xPawn);
        board.putPawn(3,xPawn);
        judge.setGameState(board);

        assertTrue(judge.isWinFor(xPawn));
        assertTrue(judge.isEndGame());
    }
    @Test
    public void xPawnVerticalWinTest(){
        Pawn xPawn = new XPawn();
        board.putPawn(1,xPawn);
        board.putPawn(4,xPawn);
        board.putPawn(7,xPawn);
        judge.setGameState(board);

        assertTrue(judge.isWinFor(xPawn));
        assertTrue(judge.isEndGame());
    }

    @Test
    public void xPawnCrossWinTest(){
        Pawn xPawn = new XPawn();
        board.putPawn(1,xPawn);
        board.putPawn(5,xPawn);
        board.putPawn(9,xPawn);
        judge.setGameState(board);

        assertTrue(judge.isWinFor(xPawn));
        assertTrue(judge.isEndGame());
    }

    @Test
    public void xPawnNotWin(){
        Pawn xPawn = new XPawn();
        judge.setGameState(board);
        assertFalse(judge.isWinFor(xPawn));

        board.putPawn(1,xPawn);
        board.putPawn(5,xPawn);
        assertFalse(judge.isWinFor(xPawn));

    }

}