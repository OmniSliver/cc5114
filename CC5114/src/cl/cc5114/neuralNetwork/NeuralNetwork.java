/**
 * Based on the implementation given in class in Pharo
 */
package cl.cc5114.neuralNetwork;

import java.util.ArrayList;

import cl.cc5114.neuronLayer.NeuronLayer;

public class NeuralNetwork {
	private ArrayList<NeuronLayer> layers;
	private int numberOfInputs;
	
	public NeuralNetwork(int numberOfInputs, int[] numberOfNeuronPerLayer) {
		this.numberOfInputs = numberOfInputs;
		layers = new ArrayList<>(numberOfNeuronPerLayer.length);
		layers.add(new NeuronLayer(numberOfNeuronPerLayer[0], numberOfInputs));
		for (int i = 1; i < numberOfNeuronPerLayer.length; i++) {
			layers.add(new NeuronLayer(numberOfNeuronPerLayer[i], numberOfNeuronPerLayer[i-1]));
		}
	}
	
	public int getNumberOfInputs() {
		return this.numberOfInputs;
	}
	
	public double[] feed(double[] inputs) {
		for (NeuronLayer nl : layers) {
			inputs = nl.feed(inputs);
		}
		
		return inputs;
	}
}
