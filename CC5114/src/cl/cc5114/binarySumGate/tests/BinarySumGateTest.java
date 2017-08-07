/**
 * 
 */
package cl.cc5114.binarySumGate.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cl.cc5114.binarySumGate.BinarySumGate;

/**
 * @author OmniSliver
 *
 */
public class BinarySumGateTest {
	/**
	 * Test method for {@link cl.cc5114.binarySumGate.BinarySumGate#sum(int, int)}.
	 */
	@Test
	public void testSum() {
		BinarySumGate.Result sum00 = BinarySumGate.sum(0, 0);
		BinarySumGate.Result sum10 = BinarySumGate.sum(0, 1);
		BinarySumGate.Result sum01 = BinarySumGate.sum(1, 0);
		BinarySumGate.Result sum11 = BinarySumGate.sum(1, 1);

		assertEquals(0, sum00.sum);
		assertEquals(0, sum00.carry);
		assertEquals(1, sum01.sum);
		assertEquals(0, sum01.carry);
		assertEquals(1, sum10.sum);
		assertEquals(0, sum10.carry);
		assertEquals(0, sum11.sum);
		assertEquals(1, sum11.carry);
	}

}
