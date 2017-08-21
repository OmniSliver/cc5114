/**
 * 
 */
package cl.cc5114.neuronLayer;

import java.util.ArrayList;

import cl.cc5114.sigmoidNeuron.SigmoidNeuron;

/**
 * @author Patricio
 *
 */
public class NeuronLayer {
	private ArrayList<SigmoidNeuron> neurons;
	
	/**
	 * Instances a new NeuronLayer with layerSize neurons. Each neuron will have
	 * numberOfInputs weights. The bias and weights' initial value will be 0.
	 * 
	 * @param layerSize How many neurons will this layer have
	 * @param numberOfInputs Hoy many inputs (or weights) will each neuron have
	 */
	public NeuronLayer(int layerSize, int numberOfInputs) {
		neurons = new ArrayList<>(layerSize);
		for (int i = 0; i < layerSize; i++) {
			neurons.add(new SigmoidNeuron(0, new double[numberOfInputs]));
		}
	}
	
	public int getSize() {
		return this.neurons.size();
	}
	
	public double[] feed(double... inputs) {
		double[] outputs = new double[this.getSize()];
		
		for (int i = 0; i < this.getSize(); i++) {
			outputs[i] = this.neurons.get(i).run(inputs);
		}
		
		return outputs;
	}
}
