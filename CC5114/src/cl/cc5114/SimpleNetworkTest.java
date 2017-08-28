/**
 * 
 */
package cl.cc5114;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import cl.cc5114.neuralNetwork.NeuralNetwork;

/**
 * @author OmniSliver
 *
 */
public class SimpleNetworkTest {
	private NeuralNetwork network;
	private int numberOfTrainingCycles;
	private int numberOfTestingCycles;
	private Supplier<double[]> inputsGenerator;
	private UnaryOperator<double[]> outputsCalculator;
	private Comparator<double[]> outputsComparator;

	/**
	 * @param network
	 * @param numberOfTrainingCycles
	 * @param numberOfTestingCycles
	 * @param inputsGenerator
	 * @param outputsCalculator
	 * @param outputsComparator
	 */
	public SimpleNetworkTest(NeuralNetwork network, int numberOfTrainingCycles, int numberOfTestingCycles,
			Supplier<double[]> inputsGenerator, UnaryOperator<double[]> outputsCalculator,
			Comparator<double[]> outputsComparator) {
		this.network = network;
		this.numberOfTrainingCycles = numberOfTrainingCycles;
		this.numberOfTestingCycles = numberOfTestingCycles;
		this.inputsGenerator = inputsGenerator;
		this.outputsCalculator = outputsCalculator;
		this.outputsComparator = outputsComparator;
	}

	/**
	 * @param numberOfInputs
	 * @param numberOfNeuronsPerLayer
	 * @param numberOfTrainingCycles
	 * @param numberOfTestingCycles
	 * @param inputsGenerator
	 * @param outputsCalculator
	 * @param outputsComparator
	 */
	public SimpleNetworkTest(int numberOfInputs, int[] numberOfNeuronsPerLayer, int numberOfTrainingCycles,
			int numberOfTestingCycles, Supplier<double[]> inputsGenerator, UnaryOperator<double[]> outputsCalculator,
			Comparator<double[]> outputsComparator) {
		this(new NeuralNetwork(numberOfInputs, numberOfNeuronsPerLayer), numberOfTrainingCycles, numberOfTestingCycles,
				inputsGenerator, outputsCalculator, outputsComparator);
	}

	/**
	 * @param numberOfInputs
	 * @param numberOfNeuronsPerLayer
	 * @param numberOfTrainingCycles
	 * @param numberOfTestingCycles
	 * @param outputsCalculator
	 */
	public SimpleNetworkTest(int numberOfInputs, int[] numberOfNeuronsPerLayer, int numberOfTrainingCycles,
			int numberOfTestingCycles, UnaryOperator<double[]> outputsCalculator) {
		this(new NeuralNetwork(numberOfInputs, numberOfNeuronsPerLayer), numberOfTrainingCycles, numberOfTestingCycles,
				binaryInputsGenerator(numberOfInputs), outputsCalculator, SimpleNetworkTest::binaryOutputsCompare);
	}

	private void learn() {
		long startTime = System.nanoTime();
		List<Double> learningPath = new ArrayList<>(this.numberOfTrainingCycles);

		for (int i = 1, scoreSum = 0, segmentSize = this.numberOfTrainingCycles
				/ 100; i <= this.numberOfTrainingCycles; i++) {
			double[] inputs = this.inputsGenerator.get();
			double[] expectedOutputs = this.outputsCalculator.apply(inputs);

			double[] actualOutputs = this.network.feedAndLearn(inputs, expectedOutputs);

			if (this.outputsComparator.compare(expectedOutputs, actualOutputs) == 0) {
				scoreSum++;
			}

			if (i % segmentSize == 0) {
				learningPath.add(100d * scoreSum / segmentSize);
				scoreSum = 0;
			}
		}

		System.out.println("Total number of trainings: " + this.numberOfTrainingCycles);
		System.out.println("Number of trainings per point: " + (this.numberOfTrainingCycles / 100));
		System.out.println("Time taken learning: " + ((System.nanoTime() - startTime) / 1e9) + " seconds");
		
		new GraphPanel(learningPath);
	}

	private double test() {
		long startTime = System.nanoTime();
		int numberOfRightAnswers = 0;

		for (int i = 0; i < this.numberOfTestingCycles; i++) {
			double[] inputs = this.inputsGenerator.get();
			double[] expectedOutputs = this.outputsCalculator.apply(inputs);

			double[] actualOutputs = this.network.feed(inputs);

			if (this.outputsComparator.compare(expectedOutputs, actualOutputs) == 0) {
				numberOfRightAnswers++;
			}
		}

		double rightAnswersPercentage = 100d * numberOfRightAnswers / this.numberOfTestingCycles;
		
		System.out.println("Number of tests: " + this.numberOfTestingCycles);
		System.out.println("Correct answers: " + rightAnswersPercentage + "%");
		System.out.println("Time taken testing: " + ((System.nanoTime() - startTime) / 1e9) + " seconds");

		return rightAnswersPercentage;
	}

	public double run() {
		this.learn();
		return this.numberOfTestingCycles > 0 ? this.test() : 0;
	}

	public static int binaryOutputsCompare(double[] o1, double[] o2) {
		for (int i = 0; i < o1.length; i++) {
			if (o1[i] - o2[i] > 0.5) {
				return 1;
			}
			if (o2[i] - o1[i] > 0.5) {
				return -1;
			}
		}

		return 0;
	}

	public static Supplier<double[]> binaryInputsGenerator(int numberOfInputs) {
		return () -> {
			double[] inputs = new double[numberOfInputs];
			for (int i = 0; i < numberOfInputs; i++) {
				inputs[i] = Math.random() > 0.5 ? 1 : 0;
			}

			return inputs;
		};
	}
}
