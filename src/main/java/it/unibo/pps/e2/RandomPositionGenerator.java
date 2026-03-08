package it.unibo.pps.e2;

public interface RandomPositionGenerator {
    /**
     * Method for generation of a Random empty position on the board
     * @param size the size of the board
     * @param avoidPawnPosition the position of the pawn to avoid
     * @return am empty position on the board different from the pawn's one
     */
    Pair<Integer,Integer> generateRandomEmpty(int size, Pair<Integer,Integer> avoidPawnPosition);
}
