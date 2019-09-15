public abstract class Player {
    public Pawn getPawn() {
        return pawn;
    }

    private Pawn pawn;

    public Player(Pawn pawn) {
        this.pawn = pawn;
    }

    public abstract int getMove(Board board);

}
