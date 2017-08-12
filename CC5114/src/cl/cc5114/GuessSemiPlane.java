/**
 * 
 */
package cl.cc5114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cl.cc5114.perceptron.Perceptron;

/**
 * @author OmniSliver
 *
 */
public class GuessSemiPlane {
	private static double a = -2;
	private static double b = 20;
	private static double[] weights = { 0, 0 };
	private static double bias = 0;
	private static Perceptron p = new Perceptron(bias, weights);

	private static int isOnTop(double[] point) {
		return (a * point[0] + b < point[1]) ? 1 : 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int rounds = 1000;
		int segmentSize = 10;
		double[] inputs = new double[2];
		List<Double> scores = new ArrayList<Double>();

		for (int i = 0, sum = 0, expectedOutput, res; i < rounds; i++) {
			inputs[0] = (Math.random() - 0.5) * 100;
			inputs[1] = (Math.random() - 0.5) * 100;
			expectedOutput = isOnTop(inputs);
			res = p.train(inputs, expectedOutput, 0.01);
			
			if (expectedOutput == res) {
				sum++;
			}
			
			if ((i+1) % segmentSize == 0) {
				System.out.println((100d*sum/segmentSize) + "% accuracy. Current weights = " + Arrays.toString(weights));
				scores.add(100d*sum/segmentSize);
				sum = 0;
			}
		}
		
		new GraphPanel(scores);
	}

}
