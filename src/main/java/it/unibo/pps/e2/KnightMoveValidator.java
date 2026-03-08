package it.unibo.pps.e2;

public interface KnightMoveValidator {
    /**
     * Method to check if a move from the knight is valid in our game
     * @param startPos the coordinates where the knight is
     * @param finalPos the coordinates where we want to move the knight
     * @param size the size of the map (to check out of bounds)
     * @return whether the knight can move in the final position knowing the start's one
     */
    boolean isValidMove(Pair<Integer,Integer> startPos, Pair<Integer,Integer> finalPos, int size);
}
