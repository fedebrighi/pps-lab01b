package it.unibo.pps.e2;

public interface KnightMoveValidator {
    boolean isValidMove(Pair<Integer,Integer> startPos, Pair<Integer,Integer> finalPos, int size);
}
