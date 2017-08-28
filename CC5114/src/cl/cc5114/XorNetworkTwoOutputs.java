/**
 * 
 */
package cl.cc5114;

import java.util.function.UnaryOperator;

/**
 * @author OmniSliver
 *
 */
public class XorNetworkTwoOutputs {
	public static void main(String[] args) {
		int numberOfInputs = 2;
		int[] numberOfNeuronsPerLayer = { 3, 2 };
		int numberOfTrainingCycles = 500_000;
		int numberOfTestingCycles = 10_000;
		UnaryOperator<double[]> outputsCalculator = inputs -> new double[] { (inputs[0] + inputs[1] == 1) ? 1 : 0,
				(inputs[0] + inputs[1] == 1) ? 0 : 1 };

		new SimpleNetworkTest(numberOfInputs, numberOfNeuronsPerLayer, numberOfTrainingCycles, numberOfTestingCycles,
				outputsCalculator).run();
	}
}
