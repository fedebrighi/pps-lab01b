package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnHitCheckerTest {
    private PawnHitChecker checker;
    private static final Pair<Integer,Integer> SAME_POSITION = new Pair<>(1,1);
    private static final Pair<Integer,Integer> DIFFERENT_POSITION = new Pair<>(3,3);

    @BeforeEach
    public void init(){
        this.checker = new PawnHitCheckerImpl();
    }

    @Test
    public void testPawnHit(){
        assertTrue(this.checker.isPawnHit(SAME_POSITION,SAME_POSITION));
        assertFalse(this.checker.isPawnHit(SAME_POSITION,DIFFERENT_POSITION));
    }

}
