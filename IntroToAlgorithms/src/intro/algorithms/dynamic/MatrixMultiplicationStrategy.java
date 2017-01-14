package intro.algorithms.dynamic;

public class MatrixMultiplicationStrategy {

	public MatrixMultiplicationStrategySolution calculate(int [] matrixSizes) {
		int n = matrixSizes.length - 1;
		int [][] costs = new int [n][n];
		int [][] cuts = new int [n][n];
		
		for(int l = 1; l < n; l++) {
			for(int i = 0; i < n-l; i++) {
				int j = i + l;
				costs[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) {
					int newCost = costs[i][k] + costs[k+1][j] + matrixSizes[i]*matrixSizes[k+1]*matrixSizes[j+1];
					if(newCost < costs[i][j]) {
						costs[i][j] = newCost;
						cuts[i][j] = k;
					}
				}
			}
		}
		
		return new MatrixMultiplicationStrategySolution(costs[0][n-1], cuts);
	}
	
	public static class MatrixMultiplicationStrategySolution {
		int cost;
		int [][] cuts;
		
		public MatrixMultiplicationStrategySolution(int cost, int[][] cuts) {
			super();
			this.cost = cost;
			this.cuts = cuts;
		}
		public int getCost() {
			return cost;
		}
		public int[][] getCuts() {
			return cuts;
		}
		@Override
		public String toString() {
			return toString(0, cuts[0].length-1);
		}
		
		private String toString(int i, int j) {
			if(i == j) {
				return "A"+(i+1);
			} else {
				return "("+toString(i, cuts[i][j])+toString(cuts[i][j]+1, j)+")";
			}
		}
	}
}
