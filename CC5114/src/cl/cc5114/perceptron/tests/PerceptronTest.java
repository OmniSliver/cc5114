package cl.cc5114.perceptron.tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cl.cc5114.perceptron.Perceptron;

public class PerceptronTest {
	Perceptron p0, p1, p2, p3;

	@Before
	public void setUp() throws Exception {
		this.p0 = new Perceptron(0);
		this.p1 = new Perceptron(0.2);
		this.p2 = new Perceptron(-3, 2, 2, 0);
		this.p3 = new Perceptron(0, 2, 2);
	}

	@Test
	public void test0Weights() {
		assertEquals(0, this.p0.run());
		assertEquals(0, this.p0.run(0));
		assertEquals(0, this.p0.run(1));
		
		assertEquals(1, this.p1.run());
		assertEquals(1, this.p1.run(0));
		assertEquals(1, this.p1.run(1));
	}

	@Test
	public void test3Weights() {
		assertEquals(0, this.p2.run());
		assertEquals(0, this.p2.run(0));
		assertEquals(0, this.p2.run(1));
		assertEquals(0, this.p2.run(0, 0));
		assertEquals(0, this.p2.run(0, 1));
		assertEquals(0, this.p2.run(1, 0));
		assertEquals(1, this.p2.run(1, 1));
		assertEquals(0, this.p2.run(0, 0, 0));
		assertEquals(0, this.p2.run(0, 0, 1));
		assertEquals(0, this.p2.run(0, 1, 0));
		assertEquals(0, this.p2.run(0, 1, 1));
		assertEquals(0, this.p2.run(1, 0, 0));
		assertEquals(0, this.p2.run(1, 0, 1));
		assertEquals(1, this.p2.run(1, 1, 0));
		assertEquals(1, this.p2.run(1, 1, 1));
	}
	
	@Test
	public void testTrain() {
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
		assertEquals(1, this.p3.train(new double[]{0.6, 0.7}, 0, 0.1));
	}
}
