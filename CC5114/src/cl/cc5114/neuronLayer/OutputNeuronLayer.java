/**
 * 
 */
package cl.cc5114.neuronLayer;

/**
 * @author Patricio
 *
 */
public class OutputNeuronLayer extends NeuronLayer {

	/**
	 * @param layerSize
	 * @param numberOfInputs
	 */
	public OutputNeuronLayer(int layerSize, int numberOfInputs) {
		super(layerSize, numberOfInputs);
	}

	@Override
	public double[] calculateAndSetDeltas(double[] expectedOutputs) {
		double[] errors = new double[this.neurons.size()];
		
		for (int i = 0; i < this.neurons.size(); i++) {
			errors[i] = expectedOutputs[i] - this.neurons.get(i).getLastOutput();
		}
		
		return super.calculateAndSetDeltas(errors);
	}

}
