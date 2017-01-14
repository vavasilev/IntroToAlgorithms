package intro.algorithms.dynamic;

import java.util.Arrays;

public class RodCut {

	private double [] priceList;
	
	public RodCut(double [] priceList) {
		this.priceList = priceList;
	}
	
	public double cutRodRecursive(int size) {
		if(size == 0) {
			return 0;
		}
		double max = Double.MIN_VALUE;
		
		for(int i=1; i<=size; i++) {
			double p = priceList[i-1]+ cutRodRecursive(size - i);
			if(p > max) {
				max = p;
			}
		}
		
		return max;
	}
	
	public double cutRodMemoized(int size) {
		double [] optimalPrices = new double[size];
		
		return cutRodMemoized(size, optimalPrices);
	}
	
	private double cutRodMemoized(int size, double [] optimalPrices) {
		if(size == 0) {
			return 0;
		}
		if(optimalPrices[size-1] > 0.0) {
			return optimalPrices[size-1];
		}
		double max = Double.MIN_VALUE;
		
		for(int i=1; i<=size; i++) {
			double p = priceList[i-1]+ cutRodMemoized(size - i, optimalPrices);
			if(p > max) {
				max = p;
			}
		}
		
		optimalPrices[size-1] = max;
		
		return max;
	}
	
	public RodCutSolution cutRodBottomUp(int size) {
		double [] optimalPrices = new double[size];
		int [] optimalFirstCut = new int[size];
		
		for(int i=1; i<=size; i++) {
			double max = Double.MIN_VALUE;
			int cut = -1;
			for(int j=1; j<=i; j++) {
				double p = priceList[j-1] + (i-j > 0 ? optimalPrices[i - j - 1] : 0);
				if(p > max) {
					cut = j;
					max = p;
				}
			}
			optimalPrices[i-1] = max;
			optimalFirstCut[i-1] = cut;
		}
		
		int [] optimalCuts = new int[size];
		
		int n = size;
		int i=0;
		while(n > 0) {
			optimalCuts[i] = optimalFirstCut[n-1];
			n = n - optimalFirstCut[n-1];
			i++;
		}
		
		return new RodCutSolution(optimalPrices[size-1], Arrays.copyOf(optimalCuts, i));
	}
	
	public static class RodCutSolution {
		private double optimalPrice;
		private int [] cuts;
		
		public RodCutSolution(double optimalPrice, int[] cuts) {
			this.optimalPrice = optimalPrice;
			this.cuts = cuts;
		}
		public double getOptimalPrice() {
			return optimalPrice;
		}
		public int[] getCuts() {
			return cuts;
		}
	}
}
