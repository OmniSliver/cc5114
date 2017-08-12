/**
 * 
 */
package cl.cc5114.sigmoidNeuron.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cl.cc5114.sigmoidNeuron.SigmoidNeuron;

/**
 * @author OmniSliver
 *
 */
public class SigmoidNeuronTest {
	SigmoidNeuron sn1, sn2, sn3, sn4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sn1 = new SigmoidNeuron(0, 1, -1);
	}

	/**
	 * Test method for {@link cl.cc5114.sigmoidNeuron.SigmoidNeuron#run(double[])}.
	 */
	@Test
	public void testRun() {
		assertEquals(0, sn1.run(0, 100), 0.01);
		assertEquals(1, sn1.run(100, 0), 0.01);
		assertEquals(0.5, sn1.run(100, 100), 0.01);
		assertEquals(0.5, sn1.run(0, 0), 0.01);
	}

}
