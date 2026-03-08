package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
  private LogicsImpl logic;
  private final int SIZE = 5;
  private final int ZERO_POS = 0;

  @BeforeEach
  void init(){
    this.logic = new LogicsImpl(SIZE);
  }

  @Test
  public void testHasOneKnight() {
    int knightCounter = 0;
    int validNumberOfKnightsOnMap = 1;
    for (int i = 0; i < SIZE; i++){
      for (int j = 0; j < SIZE; j++){
        if(this.logic.hasKnight(i,j)) knightCounter++;
      }
    }
    assertEquals(validNumberOfKnightsOnMap,knightCounter);
  }

  @Test
  public void testHasOnePawn() {
    int pawnCounter = 0;
    for (int i = 0; i < SIZE; i++){
      for (int j = 0; j < SIZE; j++){
        if(this.logic.hasKnight(i,j)) pawnCounter++;
      }
    }
    assertEquals(1,pawnCounter);
  }

  @Test
  public void testKnightNotOnPawnInitially() {
    int knightOnPawnCounter = 0;
    for (int i = 0; i < SIZE; i++){
      for (int j = 0; j < SIZE; j++){
        if(this.logic.hasKnight(i,j) && this.logic.hasPawn(i,j)) knightOnPawnCounter++;
      }
    }
    assertEquals(0,knightOnPawnCounter);
  }

  @Test
  public void testBoundsChecking(){
    int exampleOutOfBoundsX = -1;
    int exampleOutOfBoundsY = 6;
    assertThrows(IndexOutOfBoundsException.class, ()-> this.logic.hit(SIZE,ZERO_POS));
    assertThrows(IndexOutOfBoundsException.class, ()-> this.logic.hit(exampleOutOfBoundsX,exampleOutOfBoundsY));
  }

  @Test
  public void testKnightNotOnPawnInitiallyMoreEfficient(){
    assertNotEquals(this.logic.getKnightPosition(),this.logic.getPawnPosition());
  }

}
