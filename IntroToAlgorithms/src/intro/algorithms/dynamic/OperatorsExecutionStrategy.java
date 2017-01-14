package intro.algorithms.dynamic;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OperatorsExecutionStrategy {
	
	public static final String PATTERN = "[\\+\\-\\*]";
	
	public OperatorsExecutionStrategySolution calculate(Double [] numbers, Operator [] operators) {
		int n = numbers.length;
		if(operators.length != numbers.length - 1) {
			throw new IllegalArgumentException("Number of oprators should be equal to number of numbers - 1");
		}
		double [][] values = new double [n][n];
		int [][] cuts = new int [n][n];
		
		for(int l = 0; l < n; l++) {
			for(int i = 0; i < n-l; i++) {
				int j = i + l;
				values[i][j] = i==j ? numbers[i] : Double.NEGATIVE_INFINITY;
				for(int k = i; k < j; k++) {
					double newValue = performOperator(values[i][k], values[k+1][j], operators[k]);
					if(newValue > values[i][j]) {
						values[i][j] = newValue;
						cuts[i][j] = k;
					}
				}
			}
		}
		
		return new OperatorsExecutionStrategySolution(values[0][n-1], cuts, numbers, operators);
	}
	
	public String calculate(String expression) {
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(expression);
		List<Double> numbersList = new LinkedList<Double>();
		List<Operator> operatorsList = new LinkedList<Operator>();
		int i = 0;
		while(matcher.find()) {
			String numberStr = expression.substring(i, matcher.start()).trim();
			numbersList.add(Double.parseDouble(numberStr));
			String operatorStr = expression.substring(matcher.start(), matcher.end()).trim();
			operatorsList.add(Operator.fromString(operatorStr));
			i = matcher.end();
		}
		String numberStr = expression.substring(i).trim();
		numbersList.add(Double.parseDouble(numberStr));
		
		Double [] numbers = numbersList.toArray(new Double [] {});
		Operator [] operators = operatorsList.toArray(new Operator [] {});
		OperatorsExecutionStrategySolution solution = calculate(numbers, operators);
		return solution.toString();
	}
	
	private double performOperator(double value1, double value2, Operator operator) {
		switch(operator) {
		case PLUS:
			return value1 + value2;
		case MINUS:
			return value1 - value2;
		case TIMES:
			return value1 * value2;
		}
		return 0.0;
	}
	
	public static enum Operator { 
		PLUS, MINUS, TIMES;

		@Override
		public String toString() {
			switch(this) {
			case PLUS:
				return "+";
			case MINUS:
				return "-";
			case TIMES:
				return "*";
			}
			return "";
		}
		
		public static Operator fromString(String str) {
			if("+".equals(str)) {
				return PLUS;
			} else if("-".equals(str)) {
				return MINUS;
			} else if("*".equals(str)) {
				return TIMES;
			}
			return null;
		}
	}

	public static class OperatorsExecutionStrategySolution {
		private double value;
		private int [][] cuts;
		Double [] numbers;
		Operator [] operators;
		
		public OperatorsExecutionStrategySolution(double value, int[][] cuts, Double [] numbers, Operator [] operators) {
			super();
			this.value = value;
			this.cuts = cuts;
			this.numbers = numbers;
			this.operators = operators;
		}
		
		public double getValue() {
			return value;
		}
		public int[][] getCuts() {
			return cuts;
		}

		public Double[] getNumbers() {
			return numbers;
		}

		public Operator[] getOperators() {
			return operators;
		}

		@Override
		public String toString() {
			return toString(0, cuts[0].length-1)+" = "+value;
		}
		
		private String toString(int i, int j) {
			if(i == j) {
				return ""+numbers[i];
			} else {
				return "("+toString(i, cuts[i][j])+" "+operators[cuts[i][j]]+" "+toString(cuts[i][j]+1, j)+")";
			}
		}
	}
}
