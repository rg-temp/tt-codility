package com.github.rgtemp.task2;

import java.util.function.Function;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GivenSolutionTest {
	
	private static Function<int[][], Integer> codilityRuner;
	
	protected int[][] getExampleInput() {
//		A[0][0] = 5    A[0][1] = 4    A[0][2] = 4
//		A[1][0] = 4    A[1][1] = 3    A[1][2] = 4
//		A[2][0] = 3    A[2][1] = 2    A[2][2] = 4
//		A[3][0] = 2    A[3][1] = 2    A[3][2] = 2
//		A[4][0] = 3    A[4][1] = 3    A[4][2] = 4
//		A[5][0] = 1    A[5][1] = 4    A[5][2] = 4
//		A[6][0] = 4    A[6][1] = 1    A[6][2] = 1
		int[][] input = {
				{5, 4, 4,},
				{4, 3, 4,},
				{3, 2, 4,},
				{2, 2, 2,},
				{3, 3, 4,},
				{1, 4, 4,},
				{4, 1, 1,},
				};
		
		return input;
	}
	
	@BeforeClass
	public static void setUpClass() {
		codilityRuner = new GivenSolution();
	}
	
	@Test public void thatTheGivenExampleWorks() {
		int[][] in = getExampleInput();
		int actual = codilityRuner.apply(in);
		int expected = 5;
		String reason = String.format("Task description states that %d should return %d", in, expected);
		assertThat(reason, actual, is(expected));
	}
	
}
