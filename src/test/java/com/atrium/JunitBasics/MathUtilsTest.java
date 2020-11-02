package com.atrium.JunitBasics;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Ash
 *
 */
class MathUtilsTest {

	MathUtils mathUtils;

	// method need to be static to use before all because you cannot run method before instantiating class itself
	// since static does not depend upon instantiating or initializing class class
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Running Before All ");
	}

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanUP() {
		System.out.println("Cleaning up...............");
	}
	
	@Nested
	@Tag("Math")
	class TestAdd{
		@Test
		@DisplayName("Testing add method for pos num")
		void testAddPos() {
			assertEquals(4, mathUtils.add(2, 2), "this to add two pos number");
		}	
		
		@Test
		@DisplayName("Testing add method for Neg num")
		void testAddNeg() {
			assertEquals(-4, mathUtils.add(-2, -2), "this to add two neg number");
		}
		
		@Test
		@DisplayName("Testing add method for Zero num")
		void testAddZero() {
			assertEquals(0, mathUtils.add(0, 0), "this to add two zero number");
		}
	}

	@Test
	@Tag("Circle")
	void testComputeCirleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCirleRadius(10), () -> "this to find find area of circle");
		//by using lambda here String is only asserted if test fail not if pass , its is beneficial if string is resource heavy
		//its is lazily initializing and it initialize only if test fails
	}

	@RepeatedTest(5)
	@Tag("Math")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "cannot divide by zero");
	}
	
	@Test
	@Tag("Math")
	void testMultiply() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "cannot divide by zero");
		assertAll(
				() -> assertEquals(0,mathUtils.multiply(1, 0)),
				() -> assertEquals(25,mathUtils.multiply(5, 5)),
				() -> assertEquals(-25,mathUtils.multiply(-5, 5)),
				() -> assertEquals(25,mathUtils.multiply(-5, -5))
				);
	}
	
	@Test
	@Disabled
	void disabledTest() {
		fail("disabled until i work on this method");
	}
	
	@Test
	void assumeDemo() {
		boolean isServerUP = false;
		assumeTrue(isServerUP);
		System.out.println("it ony make sense to test this method only if server is up");
		
	}
}
