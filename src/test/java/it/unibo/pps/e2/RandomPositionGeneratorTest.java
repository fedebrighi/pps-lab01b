package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomPositionGeneratorTest {
    private RandomPositionGenerator generator;
    private static final int SIZE = 5;
    private static final Pair<Integer,Integer> PAWN = new Pair<>(2,2);
    private static final int ZERO_POS = 0;

    @BeforeEach
    public void init(){
        this.generator = new RandomPositionGenerationImpl(new Random());
    }

    @Test
    public void testGenerateRandomEmptyWithoutOverlap(){
        Pair<Integer,Integer> newPosition = this.generator.generateRandomEmpty(SIZE,PAWN);
        assertNotEquals(PAWN,newPosition);
        assertTrue(newPosition.getX() >= ZERO_POS && newPosition.getX() < SIZE);
        assertTrue(newPosition.getY() >= ZERO_POS && newPosition.getY() < SIZE);
    }
}
