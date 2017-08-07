/**
 * 
 */
package cl.cc5114.binarySumGate;

import cl.cc5114.perceptron.NandPerceptron;

/**
 * @author OmniSliver
 *
 */
public class BinarySumGate {
	private static final NandPerceptron nand = new NandPerceptron();
	
	public static class Result {
		public int sum;
		public int carry;
		
		/**
		 * @param sum The sum bit
		 * @param carry The carry bit
		 */
		public Result(int sum, int carry) {
			this.sum = sum;
			this.carry = carry;
		}
	}

	/**
	 * Sums two bits and return a Result object with the sum bit and the carry bit.
	 * 
	 * @param bit1 The first bit to sum
	 * @param bit2 The second bit to sum
	 * @return The result of the sum. The sum bit is in result.sum and the carry bit is in result.carry
	 */
	public static Result sum(int bit1, int bit2) {
		int a, b, c, d ,e;
		
		/*
		 * The gate used to perform the sum is composed of five NAND gates:
		 * (Inputs on the left, outputs on the right)
		 * 
		 * bit1 ----- b
		 *      \   /   \
		 *       \ /     \
		 *        a = c   e
		 *       / \     /
		 *      /   \   /
		 * bit2 ----- d
		 * 
		 * Gate "e" outputs the sum bit.
		 * Gate "c" outputs the carry bit.
		 */
		
		a = nand.run(bit1, bit2);
		b = nand.run(bit1, a);
		c = nand.run(a, a);
		d = nand.run(a, bit2);
		e = nand.run(b, d);
		
		return new Result(e, c);
	}
}
