package cl.cc5114.perceptron;

/**
 * A Perceptron is like an artificial neuron.
 * It takes several binary inputs, weights them, and produces a single binary output.
 * The output is 1 if the bias plus the weighted sum of the inputs is greater than 0. Otherwise, it's 0.
 */
public class Perceptron {
	private double[] weights;
	private double bias;
	
	/**
	 * @param bias The bias of the Perceptron
	 * @param weights The weights used to perform the weighted sum of the inputs
	 */
	public Perceptron(double bias, double... weights) {
		this.weights = weights;
		this.bias = bias;
	}
	
	/**
	 * Wheights the inputs and returns 0 or 1 according to their weights and the bias.
	 * 
	 * @param inputs The binary (0 or 1) inputs to be weighted
	 * @return 1 if the bias plus the weighted sum of the inputs is greater than 0. Otherwise, 0.
	 */
	public int run(double... inputs) {
		double sum = this.bias;
		for (int i = 0; i < this.weights.length && i < inputs.length; i++) {
			sum += inputs[i] * this.weights[i];
		}
		
		return sum > 0 ? 1 : 0;
	}
}
