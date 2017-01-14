package intro.algorithms.dynamic;

import static org.junit.Assert.*;

import org.junit.Test;

import intro.algorithms.dynamic.MatrixMultiplicationStrategy.MatrixMultiplicationStrategySolution;

public class MatrixMultiplicationStrategyTest {

	@Test
	public void test() {
		int [] matrixSizes = {30, 35, 15, 5, 10, 20, 25};
		MatrixMultiplicationStrategy s = new MatrixMultiplicationStrategy();
		MatrixMultiplicationStrategySolution solution = s.calculate(matrixSizes);
		assertEquals(15125, solution.cost);
		assertEquals("((A1(A2A3))((A4A5)A6))", solution.toString());
	}

}
