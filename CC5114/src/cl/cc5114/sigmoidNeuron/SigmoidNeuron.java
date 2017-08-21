package cl.cc5114.sigmoidNeuron;

/**
 * A sigmoid neuron is similar to a perceptron, but a small changes in its weight and bias cause only a small change in its output.
 * 
 * It takes several inputs, weights them, and produces a single output.
 * The output is σ(w⋅x+b), where σ is the Sigmoid function, i.e. σ(z) = 1/(1 + exp(-z))
 */
public class SigmoidNeuron {
	private double[] weights;
	private double bias;
	private double lastOutput;
	
	/**
	 * @param bias The bias of the SigmoidNeuron
	 * @param weights The weights of the SigmoidNeuron
	 */
	public SigmoidNeuron(double bias, double... weights) {
		this.weights = weights;
		this.bias = bias;
		this.lastOutput = Double.NaN;
	}
	
	/**
	 * @return the weights
	 */
	public double[] getWeights() {
		return weights;
	}

	/**
	 * @return the bias
	 */
	public double getBias() {
		return bias;
	}

	/**
	 * Wheights the inputs and returns a double between 0 and 1 according to their weights and the bias.
	 * 
	 * @param inputs The inputs to be weighted
	 * @return The output according to a Sigmoid function
	 */
	public double run(double... inputs) {
		double sum = this.bias;
		for (int i = 0; i < this.weights.length && i < inputs.length; i++) {
			sum += inputs[i] * this.weights[i];
		}
		
		this.lastOutput = 1 / (1 + Math.exp(-sum));
		
		return this.lastOutput;
	}
}
