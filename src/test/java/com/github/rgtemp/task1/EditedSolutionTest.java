package com.github.rgtemp.task1;

import java.util.function.Function;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class EditedSolutionTest {
	
	private static Function<Integer, Integer> codilityRunner;

	@BeforeClass
	public static void setUpClass() {
		// TODO: find out how to make the member codilityRunner work with a 
		//generic BaseTest<T, U> and be static. @BeforeClass needs to be
		//static, thus BaseTest.thatTheGivenExampleWorks() needs to 
		//know <T, U> which only are know after instantiation.
		codilityRunner = new EditedSolution();
	}
	
	@Test public void thatTheGivenExampleWorks() {
		int in = 955;
		int actual = codilityRunner.apply(in);
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
		actual = codilityRunner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 2;
		actual = codilityRunner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 3;
		actual = codilityRunner.apply(in);
		expected = 1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 4;
		actual = codilityRunner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 5;
		actual = codilityRunner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
		in = 6;
		actual = codilityRunner.apply(in);
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
		actual = codilityRunner.apply(in);
		expected = -1;
		reason = String.format(format, in, expected);
		assertThat(reason, actual, is(expected));
	}
	
}
