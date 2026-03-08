package it.unibo.pps.e2;


public interface PawnHitChecker {
    /**
     * Method to check if the pawn has been hit by the knight
     * @param knight the coordinates of the knight after the move
     * @param pawn the coordinates of the pawn
     * @return whether the pawn has been hit by the knight (end game)
     */
    boolean isPawnHit(Pair<Integer,Integer> knight, Pair<Integer,Integer> pawn);
}
