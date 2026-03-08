package it.unibo.pps.e2;

public class KnightMoveValidatorImpl implements KnightMoveValidator{

    @Override
    public boolean isValidMove(Pair<Integer, Integer> startPos, Pair<Integer, Integer> finalPos, int size) {
        int dx = Math.abs(startPos.getX() - finalPos.getX());
        int dy = Math.abs(startPos.getY() - finalPos.getY());
        return dx != 0 && dy != 0 && dx+dy == 3 &&
                finalPos.getX() >= 0 && finalPos.getX() < size && finalPos.getY() >= 0 && finalPos.getY() < size;
    }
}
