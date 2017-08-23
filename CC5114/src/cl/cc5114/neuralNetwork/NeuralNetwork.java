/**
 * Based on the implementation given in class in Pharo
 */
package cl.cc5114.neuralNetwork;

import java.util.ArrayList;

import cl.cc5114.neuronLayer.HiddenNeuronLayer;
import cl.cc5114.neuronLayer.NeuronLayer;
import cl.cc5114.neuronLayer.OutputNeuronLayer;

public class NeuralNetwork {
	private ArrayList<HiddenNeuronLayer> hiddenLayers;
	private OutputNeuronLayer outputLayer;
	private int numberOfInputs;
	
	public NeuralNetwork(int numberOfInputs, int[] numberOfNeuronsPerLayer) {
		this.numberOfInputs = numberOfInputs;
		int nextLayerNumberOfInputs = numberOfInputs;
		hiddenLayers = new ArrayList<>(numberOfNeuronsPerLayer.length - 1);
		
		for (int i = 0; i < numberOfNeuronsPerLayer.length - 1; i++) {
			hiddenLayers.add(new HiddenNeuronLayer(numberOfNeuronsPerLayer[i], nextLayerNumberOfInputs));
			nextLayerNumberOfInputs = numberOfNeuronsPerLayer[i-1];
		}
		
		outputLayer = new OutputNeuronLayer(numberOfNeuronsPerLayer[numberOfNeuronsPerLayer.length - 1], nextLayerNumberOfInputs);
	}
	
	public int getNumberOfInputs() {
		return this.numberOfInputs;
	}
	
	public double[] feedAndLearn(double[] inputs, double[] expectedOutputs) {
		double[] output = this.feed(inputs);
		this.propagateDeltas(expectedOutputs);
		this.updateWeightsAndBias(inputs);
		
		return output;
	}
	
	public double[] feed(double[] inputs) {
		for (NeuronLayer nl : this.hiddenLayers) {
			inputs = nl.feed(inputs);
		}
		
		return this.outputLayer.feed(inputs);
	}
	
	public void propagateDeltas(double[] expectedOutputs) {
		this.outputLayer.calculateAndSetDeltas(expectedOutputs);
		NeuronLayer nextLayer = this.outputLayer;
		
		for (int i = this.hiddenLayers.size() - 1; i >= 0; i--) {
			HiddenNeuronLayer layer = this.hiddenLayers.get(i);
			layer.calculateAndSetDeltas(nextLayer);
			nextLayer = layer;
		}
	}
	
	public void updateWeightsAndBias(double[] inputs) {
		for(int i = 0; i < this.hiddenLayers.size(); i++) {
			this.hiddenLayers.get(i).updateWeightsAndBias(inputs);
			inputs = this.hiddenLayers.get(i).getOutputs();
		}
		
		this.outputLayer.updateWeightsAndBias(inputs);
	}
}
