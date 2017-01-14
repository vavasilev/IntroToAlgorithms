package intro.algorithms.dynamic;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import intro.algorithms.dynamic.RodCut.RodCutSolution;

public class RodCutTest {

	@Test
	public void testRecursive() {
		double [] data = {1.0, 5.0, 8.0, 9.0, 10.0, 17.0, 17.0, 20.0, 24.0, 30.0};
		RodCut rc = new RodCut(data);
		for(int i=1; i<=data.length; i++) {
			RodCutSolution solution = rc.cutRodBottomUp(i);
			System.out.println(solution.getOptimalPrice()+": "+Arrays.toString(solution.getCuts()));
		}
		data = generateData(10000);
		rc = new RodCut(data);
		long start = System.currentTimeMillis();
		rc.cutRodBottomUp(data.length);
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time: "+(end-start));
	}

	private double [] generateData(int size) {
		double [] data = new double[size];
		
		double price = 4.0;
		for(int i=0; i<size; i++) {
			data[i] = price;
			price += Math.rint(Math.random()*1000.0)/100.0;
		}
		
		return data;
	}
}
