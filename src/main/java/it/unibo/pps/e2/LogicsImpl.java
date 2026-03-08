package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
    private final int size;
	private final KnightMoveValidator validator = new KnightMoveValidatorImpl();
	private final PawnHitChecker checker = new PawnHitCheckerImpl();


    public LogicsImpl(int size){
    	this.size = size;
        Random random = new Random();
        RandomPositionGenerator generator = new RandomPositionGenerationImpl(random);
        this.pawn = generator.generateRandomEmpty(this.size,null);
        this.knight = generator.generateRandomEmpty(this.size,pawn);
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		Pair<Integer,Integer> target = new Pair<>(row,col);
		if(validator.isValidMove(knight,target,size)){
			knight = target;
			return this.checker.isPawnHit(this.knight,this.pawn);
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
		return this.knight;
	}

	@Override
	public Pair<Integer,Integer> getPawnPosition() {
		return this.pawn;
	}
}
