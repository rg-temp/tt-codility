package com.github.rgtemp.task1;

import java.util.function.Function;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class EditedSolutionTest {
	
	private static Function<Integer, Integer> codilityRuner;

	@BeforeClass
	public static void setUpClass() {
		codilityRuner = new EditedSolution();
	}
	
	@Test public void thatTheGivenExampleWorks() {
		int in = 955;
		int actual = codilityRuner.apply(in);
		int expected = 4;
		String reason = String.format("Task description states that %d should return %d", in, expected);
		assertThat(reason, actual, is(expected));
	}
	
	@Test public void thatForSomeValuesIsValid() {
		int in;
		int actual;
		int expected;
		String format = "%d should return %d";
		String reason;
		in = 1;
		actual = codilityRuner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 2;
		actual = codilityRuner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 3;
		actual = codilityRuner.apply(in);
		expected = 1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 4;
		actual = codilityRuner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 5;
		actual = codilityRuner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 6;
		actual = codilityRuner.apply(in);
		expected = 1;
		reason = String.format(format, in, expected);
//		assertThat(reason, actual, is(expected));
	}
	
	@Test public void debug1() {
		int in;
		int actual;
		int expected;
		String format = "%d should return %d";
		String reason;
		in = 2;
		actual = codilityRuner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
	}
	
}
