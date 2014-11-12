package com.github.rgtemp.task2;

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
	}

	public void consume() {
		if (!isSizeValid()) {
			colorCount = -1l;
			return;
		}
		grow();
	}
	
	private boolean isSizeValid() {
		//implement null checks
		return true;
	}
	
	private void grow() {
		grow(matrix[0][0], 0, 0);
	}
	
	private void grow(int color, int c, int r) {
//		if !inside(A, i, j) {
//	       //return;
//	    }
//	    //if (color == A[i][j]) {
//	        A[i][j] = 0;
//	        int incI, incJ;
//	        incI = 1;
//	        incJ = 0;
//	        grow(color, A, i + incI, j + incJ);
//	        incI = 0;
//	        incJ = 1;
//	        grow(color, A, i + incI, j + incJ);
//	        //...
//	    }
//	}
		throw new RuntimeException("implement me");
	}
	
	public long getCount() {
		return colorCount;
	}
}