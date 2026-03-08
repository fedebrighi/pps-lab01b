package it.unibo.pps.e2;

public interface RandomPositionGenerator {
    Pair<Integer,Integer> generateRandomEmpty(int size, Pair<Integer,Integer> avoidPawnPosition);
}
