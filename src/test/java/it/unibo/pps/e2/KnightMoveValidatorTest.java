package it.unibo.pps.e2;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMoveValidatorTest {
    private KnightMoveValidator validator;
    private final int SIZE = 5;

    @BeforeEach
    public void init(){
        this.validator = new KnightMoveValidatorImpl();
    }

    @Test
    public void testValidKinghtMove(){
        Pair knightPosition = new Pair(0,1);
        assertAll("Valid Knight Moves",
                ()->assertTrue(validator.isValidMove(knightPosition, new Pair<>(2,0),SIZE)),
                ()->assertTrue(validator.isValidMove(knightPosition, new Pair<>(2,2),SIZE)),
                ()->assertTrue(validator.isValidMove(knightPosition, new Pair<>(1,3),SIZE))
                );
    }
}
