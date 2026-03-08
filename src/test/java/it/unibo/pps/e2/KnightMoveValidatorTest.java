package it.unibo.pps.e2;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMoveValidatorTest {
    private KnightMoveValidator validator;
    private final int SIZE = 5;
    private static final Pair<Integer,Integer> KNIGHT_START = new Pair<>(0, 1);
    private static final Pair<Integer,Integer> MOVE_L1 = new Pair<>(2, 0);
    private static final Pair<Integer,Integer> MOVE_L2 = new Pair<>(2, 2);
    private static final Pair<Integer,Integer> MOVE_L3 = new Pair<>(1, 3);

    @BeforeEach
    public void init(){
        this.validator = new KnightMoveValidatorImpl();
    }

    @Test
    public void testValidKnightMove(){
        assertAll("Valid Knight Moves",
                ()->assertTrue(validator.isValidMove(KNIGHT_START, MOVE_L1, SIZE)),
                ()->assertTrue(validator.isValidMove(KNIGHT_START, MOVE_L2, SIZE)),
                ()->assertTrue(validator.isValidMove(KNIGHT_START, MOVE_L3, SIZE))
        );
    }
}
