package it.unibo.pps.e2;

import java.util.Random;

public class RandomPositionGenerationImpl implements RandomPositionGenerator{
    private final Random random;
    private final int SIZE = 5;

    public RandomPositionGenerationImpl(Random random) {
        this.random = random;
    }

    @Override
    public Pair<Integer, Integer> generateRandomEmpty(int size, Pair<Integer, Integer> avoidPawnPosition) {
        while(true){
            Pair<Integer,Integer> newPosition = new Pair<>(random.nextInt(SIZE), random.nextInt(5));
            if(!newPosition.equals(avoidPawnPosition)) return newPosition;
        }
    }
}
