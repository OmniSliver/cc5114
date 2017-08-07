package cl.cc5114.perceptron;

/**
 * Instances of this class are Perceptrons with bias and weights that make them perform like a binary OR gate.
 */
public class OrPerceptron extends Perceptron {
	private static final double OR_BIAS = 0;
	private static final double[] OR_WEIGHTS = {1, 1};

	public OrPerceptron() {
		super(OR_BIAS, OR_WEIGHTS);
	}
}
