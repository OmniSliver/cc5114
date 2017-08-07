package cl.cc5114.perceptron.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AndPerceptronTest.class, NandPerceptronTest.class, OrPerceptronTest.class, PerceptronTest.class })
public class AllTests {

}
