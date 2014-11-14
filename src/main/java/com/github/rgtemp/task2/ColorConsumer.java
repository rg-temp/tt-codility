package com.github.rgtemp.task2;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ColorConsumer {
	// Improvements:
	// iterative with Stack<Coordinate> vs recursive
	// addCord returned from baseCoordinatePlusUp()
	// check add vs plus:
	//   plusFoo return a new Coordinate
	//   addFoo changes the Coordinate
	
	private static final Logger logger = LogManager.getLogger(ColorConsumer.class.getName());

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
		lastConsumed = new Coordinate(-1, 0);
	}

	public void consume() {
		if (!isSizeValid()) {
			colorCount = -1l;
			return;
		}
		colorCount = 0;
		while(hasNextUnconsumed(lastConsumed)) {
			Coordinate next = nextUnconsumed(lastConsumed);
			logger.error(String.format("\tnext: (%s)", next));
			consume(next);
			++colorCount;
			lastConsumed = next;
		}
	}
	
	//Add wrapper call
	private boolean hasNextUnconsumed(Coordinate coor) {
		try {
			//naive implementation
			nextUnconsumed(coor);
			logger.error(String.format("hasNext(%s): TR", coor));
		} catch (NoSuchElementException e) {
			logger.error(String.format("hasNext(%s): FL", coor));
			return false;
		}
		return true;
	}
	
	private Coordinate nextUnconsumed(Coordinate coor) {
		Coordinate next = coor;
		do {
			next = suc(next);
 		} while(consumed.contains(next));
 		if(withinBounds(next)) {
			return next;
		}
		throw new NoSuchElementException("All elements inside of the matrix have been exhausted");
	}
	
	private Coordinate suc(Coordinate coor) {
		int baseX = coor.x();
		int baseY = coor.y();
		Coordinate next;
		next = new Coordinate(++baseX, baseY);
		//refactor
		if (withinBounds(next)) {
			return next;
		}

		return new Coordinate(0, ++baseY);
	}
	
	
	private boolean withinBounds(Coordinate coor) {
		//there is no null check, and not introduce explaining variable
		return coor.y() >= 0 && coor.y() < matrix.length 
				&& coor.x() >= 0 && coor.x() < matrix[0].length;
	}
	
	private boolean isSizeValid() {
		//implement null checks
		return true;
	}
	
	private void consume(Coordinate coor) {
		consumed.add(coor);
		int color = getColor(coor);
		//up
		consumeIfUseful(coor, 0, -1, color);
		//right
		consumeIfUseful(coor, 1, 0, color);
		//down
		consumeIfUseful(coor, 0, 1, color);
		//left
		consumeIfUseful(coor, -1, 0, color);
	}
	
	public int getColor(Coordinate coor) {
		return matrix[coor.y()][coor.x()];
	}

	public void consumeIfUseful(Coordinate coor, int incX, int incY, int color) {
		Coordinate newCoor = new Coordinate(coor.x() + incX, coor.y() + incY);
		if (useful(newCoor, color)) {
			//color will be read again
			consume(newCoor);
		}
	}
	
	public boolean useful(Coordinate coor, int color) {
		return !consumed.contains(coor) && withinBounds(coor)
				&& getColor(coor) == color;
	}
	
	public long getCount() {
		return colorCount;
	}
}