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
	
	public Perceptron(double[] weights, double bias) {
		this.weights = weights;
		this.bias = bias;
	}

	/**
	 * @return the weights
	 */
	public double[] getWeights() {
		return weights;
	}

	/**
	 * @param weights the weights to set
	 */
	public void setWeights(double[] weights) {
		this.weights = weights;
	}

	/**
	 * @return the bias
	 */
	public double getBias() {
		return bias;
	}

	/**
	 * @param bias the bias to set
	 */
	public void setBias(double bias) {
		this.bias = bias;
	}
}
