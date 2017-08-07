package cl.cc5114.perceptron;
/**
 * 
 */

/**
 * @author OmniSliver
 *
 */
public class Perceptron {
	private double[] weights;
	private double bias;
	
	public Perceptron(double bias, double... weights) {
		this.weights = weights;
		this.bias = bias;
	}
	
	public int run(int... inputs) {
		double sum = this.bias;
		for (int i = 0; i < this.weights.length && i < inputs.length; i++) {
			sum += inputs[i] * this.weights[i];
		}
		
		return sum > 0 ? 1 : 0;
	}
}
