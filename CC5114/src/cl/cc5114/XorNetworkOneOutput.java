/**
 * 
 */
package cl.cc5114;

import java.util.function.UnaryOperator;

/**
 * @author OmniSliver
 *
 */
public class XorNetworkOneOutput {
	public static void main(String[] args) {
		int numberOfInputs = 2;
		int[] numberOfNeuronsPerLayer = { 3, 1 };
		int numberOfTrainingCycles = 500_000;
		int numberOfTestingCycles = 10_000;
		UnaryOperator<double[]> outputsCalculator = inputs -> new double[] { (inputs[0] + inputs[1] == 1) ? 1 : 0 };

		new SimpleNetworkTest(numberOfInputs, numberOfNeuronsPerLayer, numberOfTrainingCycles, numberOfTestingCycles,
				outputsCalculator).run();
	}
}
