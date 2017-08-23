/**
 * 
 */
package cl.cc5114.neuronLayer;

/**
 * @author Patricio
 *
 */
public class HiddenNeuronLayer extends NeuronLayer {

	/**
	 * @param layerSize
	 * @param numberOfInputs
	 */
	public HiddenNeuronLayer(int layerSize, int numberOfInputs) {
		super(layerSize, numberOfInputs);
	}

	public double[] calculateAndSetDeltas(NeuronLayer nextLayer) {
		double[] errors = new double[this.neurons.size()];
		double[][] nextWeights = nextLayer.getWeights();
		double[] nextDeltas = nextLayer.getDeltas();
		
		for (int i = 0; i < this.neurons.size(); i++) {
			for (int j = 0; j < nextWeights.length; j++) {
				errors[i] += nextWeights[j][i] * nextDeltas[j];
			}
		}
		
		return super.calculateAndSetDeltas(errors);
	}
}
