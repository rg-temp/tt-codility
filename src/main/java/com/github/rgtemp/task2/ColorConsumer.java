package com.github.rgtemp.task2;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;

public class ColorConsumer {
	// Improvements:
	// iterative with Stack<Coordinate> vs recursive
	// addCord returned from baseCoordinatePlusUp()
	// check add vs plus:
	//   plusFoo return a new Coordinate
	//   addFoo changes the Coordinate
	
	private int[][] matrix;

	private Coordinate lastConsumed;
	
	private Set<Coordinate> consumed;

	private long colorCount;
	
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
		reset();
	}
	
	private void reset() {
		if (consumed == null) {
			consumed = new HashSet<>();
		} else {
			consumed.clear();
		}
		lastConsumed = new Coordinate(-1, -1);
	}

	public void consume() {
		if (!isSizeValid()) {
			colorCount = -1l;
			return;
		}
		while(hasNextUnconsumed(lastConsumed)) {
			Coordinate next = nextUnconsumed(lastConsumed);
			consume(next);
			lastConsumed = next;
		}
	}
	
	//Add wrapper call
	private boolean hasNextUnconsumed(Coordinate coor) {
		try {
			//naive implementation
			nextUnconsumed(coor);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
	
	private Coordinate nextUnconsumed(Coordinate coor) {
		int baseX = coor.x();
		int baseY = coor.y();
		boolean contained;
		Coordinate next;
		next = new Coordinate(++baseX, baseY);
		contained = consumed.contains(next);
		//refactor
		if (!contained && withinBounds(next)) {
			return next;
		}
		next = new Coordinate(0, ++baseY);
		contained = consumed.contains(next);
		if (!contained && withinBounds(next)) {
			return next;
		}
		throw new NoSuchElementException("Cannot create succesor, all elements exhausted or out of bounds for matrix");
	}
	
	
	private boolean withinBounds(Coordinate coor) {
		//add null check, introduce explaining variable
		return coor.y() >= 0 && coor.y() < matrix.length 
				&& coor.x() >= 0 && coor.x() < matrix[0].length;
	}
	
	private boolean isSizeValid() {
		//implement null checks
		return true;
	}
	
	private void consume(Coordinate coor) {
		//--add
		consumed.add(coor);
		int color = getColor(coor);
		//--color = readColor
		//--up
		consumeIfUseful(coor, -1, 0, color);
		
		throw new RuntimeException("implement me");
	}
	
	public int getColor(Coordinate coor) {
		throw new RuntimeException("implement me");
	}

	public void consumeIfUseful(Coordinate coor, int incX, int incY, int color) {
		throw new RuntimeException("implement me");
//		if (useful(coor)) {
//			//----consume(newCoor)
//			}
			//--right...
			
//			if !inside(A, i, j) {
//		       //return;
//		    }
//		    //if (color == A[i][j]) {
//		        A[i][j] = 0;
//		        int incI, incJ;
//		        incI = 1;
//		        incJ = 0;
//		        grow(color, A, i + incI, j + incJ);
//		        incI = 0;
//		        incJ = 1;
//		        grow(color, A, i + incI, j + incJ);
//		        //...
//		    }
//		}
	}
	
	public long getCount() {
		return colorCount;
	}
}