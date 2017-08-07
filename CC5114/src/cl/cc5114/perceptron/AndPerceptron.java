package cl.cc5114.perceptron;

public class AndPerceptron extends Perceptron {
	private static final double AND_BIAS = -1;
	private static final double[] AND_WEIGHTS = {1, 1};

	public AndPerceptron() {
		super(AND_BIAS, AND_WEIGHTS);
	}
}
