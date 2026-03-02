package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
  private LogicsImpl logic;
  private final int SIZE = 5;

  @BeforeEach
  void init(){
    this.logic = new LogicsImpl(SIZE);
  }

  @Test
  public void testHasOneKnight() {
    int knightCounter = 0;
    for (int i = 0; i < SIZE; i++){
      for (int j = 0; j < SIZE; j++){
        if(logic.hasKnight(i,j)) knightCounter++;
      }
    }
    assertEquals(1,knightCounter);
  }

  @Test
  public void testHasOnePawn() {
    int pawnCounter = 0;
    for (int i = 0; i < SIZE; i++){
      for (int j = 0; j < SIZE; j++){
        if(logic.hasKnight(i,j)) pawnCounter++;
      }
    }
    assertEquals(1,pawnCounter);
  }

  @Test
  public void testKnightNotOnPawnInitially() {
    int knightOnPawnCounter = 0;
    for (int i = 0; i < SIZE; i++){
      for (int j = 0; j < SIZE; j++){
        if(logic.hasKnight(i,j) && logic.hasPawn(i,j)) knightOnPawnCounter++;
      }
    }
    assertEquals(0,knightOnPawnCounter);
  }

  @Test
  public void testBoundsChecking(){
    assertThrows(IndexOutOfBoundsException.class, ()-> logic.hit(5,0));
    assertThrows(IndexOutOfBoundsException.class, ()-> logic.hit(-1,8));
  }

}
