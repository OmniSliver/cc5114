package cl.cc5114.perceptron;

/**
 * Instances of this class are Perceptrons with bias and weights that make them perform like a binary NAND gate.
 */
public class NandPerceptron extends Perceptron {
	private static final double NAND_BIAS = 2;
	private static final double[] NAND_WEIGHTS = {-1, -1};

	public NandPerceptron() {
		super(NAND_BIAS, NAND_WEIGHTS);
	}
}
