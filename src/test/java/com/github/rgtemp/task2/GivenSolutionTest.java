package com.github.rgtemp.task2;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GivenSolutionTest {
	
	private static Function<int[][], Long> codilityRuner;
	
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
		long actual = codilityRuner.apply(in);
		long expected = 11;
		String inAsString = Arrays.deepToString(in);
		String reason = String.format("Task description states that %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
	}
	
	@Test public void thatForEmptyMatrixOcolorsAreFound() {
		int[][] in = {{}};
		long actual = codilityRuner.apply(in);
		long expected = 0;
		String inAsString = Arrays.deepToString(in);
		String reason = String.format("For 1 column and one row %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
	}
	
	@Test public void thatFor1c1rSolutionIsValid() {
		int[][] in = {{1}};
		long actual = codilityRuner.apply(in);
		long expected = 1;
		String inAsString = Arrays.deepToString(in);
		String reason = String.format("For 1 column and one row %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
	}
	
	@Test public void thatFor1by2SolutionIsValid() {
		int[][] in;
		int[][] m1b2c1 = {{1,1}};
		int[][] m1b2c2 = {{1,2}};
		int[][] m2b1c1 = {
				{1,},
				{1,},};
		int[][] m2b1c2 = {
				{1,},
				{2,},};
		long actual;
		long expected;
		String inAsString;
		String reason;
		in = m1b2c1;
		actual = codilityRuner.apply(in);
		expected = 1;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 1 by 2 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
		in = m1b2c2;
		actual = codilityRuner.apply(in);
		expected = 2;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 1 by 2 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
		in = m2b1c1;
		actual = codilityRuner.apply(in);
		expected = 1;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 2 by 1 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
		in = m2b1c2;
		actual = codilityRuner.apply(in);
		expected = 2;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 2 by 1 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
	}
	
	@Test public void thatForSomeMatricesSolutionIsValid() {
		int[][] in;
		int[][] m2b2c4 = {
				{5, 4, },
				{4, 3, },
				};
		int[][] m3b3c4 = {
				{5, 4, 4,},
				{4, 3, 4,},
				};
		int[][] m5b3c8 = {
				{5, 4, 4,},
				{4, 3, 4,},
				{3, 2, 4,},
				{2, 2, 2,},
				{3, 3, 4,},
				};
		
//		int[][] input = {
//				{5, 4, 4,},
//				{4, 3, 4,},
//				{3, 2, 4,},
//				{2, 2, 2,},
//				{3, 3, 4,},
//				{1, 4, 4,},
//				{4, 1, 1,},
//				};
		long actual;
		long expected;
		String inAsString;
		String reason;
		in = m2b2c4;
		actual = codilityRuner.apply(in);
		expected = 4;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 2 by 2 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
		in = m3b3c4;
		actual = codilityRuner.apply(in);
		expected = 4;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 3 by 3 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
		in = m5b3c8;
		actual = codilityRuner.apply(in);
		expected = 8;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 5 by 3 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
	}
	
	@Test public void debug1() {
		int[][] in;
		int[][] m5b3c8 = {
				{5, 4, 4,},
				{4, 3, 4,},
				{3, 2, 4,},
				{2, 2, 2,},
				{3, 3, 4,},
				};
		
//		int[][] input = {
//				{5, 4, 4,},
//				{4, 3, 4,},
//				{3, 2, 4,},
//				{2, 2, 2,},
//				{3, 3, 4,},
//				{1, 4, 4,},
//				{4, 1, 1,},
//				};
		long actual;
		long expected;
		String inAsString;
		String reason;
		in = m5b3c8;
		actual = codilityRuner.apply(in);
		expected = 8;
		inAsString = Arrays.deepToString(in);
		reason = String.format("For 5 by 3 %s should return %d", inAsString, expected);
		assertThat(reason, actual, is(expected));
	}

}
