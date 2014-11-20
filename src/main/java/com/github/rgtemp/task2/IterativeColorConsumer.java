package com.github.rgtemp.task2;

import java.util.Stack;

public class IterativeColorConsumer extends ColorConsumer {
	
	private Coordinate lastColorInitialCoordinate;
	
	private Stack<Coordinate> pendingConsumption;

	@Override
	protected void reset() {
		resetConsumed();
		resetPendingConsumption();
		lastColorInitialCoordinate = new Coordinate(-1, 0);
	}

	protected void resetPendingConsumption() {
		if (pendingConsumption == null) {
			pendingConsumption = new Stack<>();
		} else {
			pendingConsumption.clear();
		}
	}

	public void consume() {
		if (!isSizeValid()) {
			colorCount = -1l;
			return;
		}
		colorCount = 0;
		while(hasNextUnconsumed(lastColorInitialCoordinate)) {
			Coordinate next = nextUnconsumed(lastColorInitialCoordinate);
			pendingConsumption.push(next);
			consumeFromPendingConsumption();
			++colorCount;
			lastColorInitialCoordinate = next;
		}
	}

	private void consumeFromPendingConsumption() {
		while (!pendingConsumption.isEmpty()) {
			Coordinate next = pendingConsumption.pop();
			consume(next);
		}
	}
	
	@Override
	public void consumeIfUseful(Coordinate coor, int incX, int incY, int color) {
		Coordinate newCoor = new Coordinate(coor.x() + incX, coor.y() + incY);
		if (useful(newCoor, color)) {
			//color will be read again
			pendingConsumption.push(newCoor);
		}
	}

}
