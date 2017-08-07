package cl.cc5114.perceptron.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cl.cc5114.perceptron.OrPerceptron;

public class OrPerceptronTest {
	OrPerceptron p;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p = new OrPerceptron();
	}

	/**
	 * Test method for {@link cl.cc5114.perceptron.Perceptron#run(int[])}.
	 */
	@Test
	public void testRun() {
		assertEquals(0, p.run(0, 0));
		assertEquals(1, p.run(0, 1));
		assertEquals(1, p.run(1, 0));
		assertEquals(1, p.run(1, 1));
	}

}
