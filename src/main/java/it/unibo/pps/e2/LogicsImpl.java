package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	private final KnightMoveValidator validator = new KnightMoveValidatorImpl();
	private final RandomPositionGenerator generator = new RandomPositionGenerationImpl(random);
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.generator.generateRandomEmpty(this.size,null);
        this.knight = this.generator.generateRandomEmpty(this.size,pawn);
    }
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		Pair<Integer,Integer> target = new Pair<>(row,col);
		if(validator.isValidMove(knight,target,size)){
			knight = target;
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

	@Override
	public Pair<Integer,Integer> getKnightPosition() {
		for(int i = 0; i < this.size; i++){
			for (int j = 0; j < this.size; j++){
				if (hasKnight(i,j)) return new Pair<>(i,j);
			}
		}
		return null;
	}

	@Override
	public Pair<Integer,Integer> getPawnPosition() {
		for(int i = 0; i < this.size; i++){
			for (int j = 0; j < this.size; j++){
				if (hasPawn(i,j)) return new Pair<>(i,j);
			}
		}
		return null;
	}
}
