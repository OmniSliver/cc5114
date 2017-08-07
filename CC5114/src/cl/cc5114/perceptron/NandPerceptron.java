/**
 * 
 */
package cl.cc5114.perceptron;

/**
 * @author OmniSliver
 *
 */
public class NandPerceptron extends Perceptron {
	private static final double NAND_BIAS = 2;
	private static final double[] NAND_WEIGHTS = {-1, -1};

	/**
	 * 
	 */
	public NandPerceptron() {
		super(NAND_BIAS, NAND_WEIGHTS);
	}
}
