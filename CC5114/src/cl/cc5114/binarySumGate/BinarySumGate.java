package cl.cc5114.binarySumGate;

import cl.cc5114.perceptron.NandPerceptron;

/**
 * This class has a static sum method, which performs a binary sum on two bits (0 or 1), returning the sum bit and the carry bit.
 */
public class BinarySumGate {
	// The NAND gate used to build the sum gate
	private static final NandPerceptron NAND = new NandPerceptron();
	
	/**
	 * Instances of this class contain the result of the sum gate: A sum bit and a carry bit.
	 */
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
		
		a = NAND.run(bit1, bit2);
		b = NAND.run(bit1, a);
		c = NAND.run(a, a);
		d = NAND.run(a, bit2);
		e = NAND.run(b, d);
		
		return new Result(e, c);
	}
}
