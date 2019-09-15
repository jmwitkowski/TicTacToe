public class MoveValidator {
    public static boolean validate(Board board, int move) {
        try {
            if (board.getPawn(move) != null) {
                return false;
            }
        } catch (InvalidFieldEeception e) {
            return false;
        }
        return true;
    }
}
