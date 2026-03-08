package it.unibo.pps.e2;

public class PawnHitCheckerImpl implements PawnHitChecker{
    @Override
    public boolean isPawnHit(Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
        return(knight.equals(pawn));
    }
}
