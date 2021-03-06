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
	ArrayList<SigmoidNeuron> neurons;
	
	/**
	 * Instances a new NeuronLayer with layerSize neurons. Each neuron will have
	 * numberOfInputs weights. The bias and weights' initial value will be 0.
	 * 
	 * @param layerSize How many neurons will this layer have
	 * @param numberOfInputs Hoy many inputs (or weights) will each neuron have
	 */
	public NeuronLayer(int layerSize, int numberOfInputs) {
		this.neurons = new ArrayList<>(layerSize);
		
		for (int i = 0; i < layerSize; i++) {
			double bias = Math.random();
			double[] weights = new double[numberOfInputs];
			for (int j = 0; j < weights.length; j++) {
				weights[j] = Math.random();
			}
			
			this.neurons.add(new SigmoidNeuron(bias, weights));
		}
	}
	
	public int getSize() {
		return this.neurons.size();
	}
	
	public double[][] getWeights() {
		double[][] weights = new double[this.neurons.size()][];
		
		for(int i = 0; i < this.neurons.size(); i++) {
			weights[i] = this.neurons.get(i).getWeights().clone();
		}
		
		return weights;
	}
	
	public double[] getDeltas() {
		double[] deltas = new double[this.neurons.size()];
		
		for(int i = 0; i < this.neurons.size(); i++) {
			deltas[i] = this.neurons.get(i).getDelta();
		}
		
		return deltas;
	}
	
	public double[] getOutputs() {
		double[] outputs = new double[this.neurons.size()];
		
		for(int i = 0; i < this.neurons.size(); i++) {
			outputs[i] = this.neurons.get(i).getLastOutput();
		}
		
		return outputs;
	}
	
	public double[] feed(double... inputs) {
		double[] outputs = new double[this.getSize()];
		
		for (int i = 0; i < this.getSize(); i++) {
			outputs[i] = this.neurons.get(i).run(inputs);
		}
		
		return outputs;
	}
	
	public double[] calculateAndSetDeltas(double[] errors) {
		double[] deltas = new double[this.neurons.size()];
		
		for (int i = 0; i < this.neurons.size(); i++) {
			deltas[i] = this.neurons.get(i).calculateAndSetDelta(errors[i]);
		}
		
		return deltas;
	}
	
	public void updateWeightsAndBias(double[] inputs) {
		for (int i = 0; i < this.neurons.size(); i++) {
			this.neurons.get(i).updateWeights(inputs);
			this.neurons.get(i).updateBias();
		}
	}
}
