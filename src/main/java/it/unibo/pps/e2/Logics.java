package it.unibo.pps.e2;

public interface Logics{
    
    /**
     * attempt to move Knight on position row,col, if possible
     * 
     * @param row the row of the table where we want to move the knight
     * @param col the column of the table where we want to move the knight
     * @return whether the pawn has been hit 
     */
    boolean hit(int row, int col);
    
    /**
     * @param row the row of the table where we want to know if there's the knight
     * @param col the column of the table where we want to know if there's the knight
     * @return whether position row,col has the knight
     */
    boolean hasKnight(int row, int col);
    
    /**
     * @param row the row of the table where we want to know if there's a pawn
     * @param col the column of the table where we want to know if there's a pawn
     * @return whether position row,col has the pawn
     */
    boolean hasPawn(int row, int col);

    /**
     * Method to know the coordinates of the knight
     * @return the coordinates of the knight
     */
    Pair<Integer,Integer> getKnightPosition();

    /**
     * Method to know the coordinates of the pawn
     * @return the coordinates of the pawn
     */
    Pair<Integer,Integer> getPawnPosition();
}
