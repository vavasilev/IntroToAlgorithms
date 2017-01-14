package amazonprep.algorithms.other;

public class MaxSubarray {

	public Subarray maxSubarrayRec(int [] A) {
		return maxSubarrayRec(A, 0, A.length-1);
	}
	
	private Subarray maxSubarrayRec(int [] A, int start, int end) {
		if(start == end) {
			return new Subarray(start, end, A[start]);
		}
		
		int middle = (end + start)/2;
		
		Subarray leftSubarray = maxSubarrayRec(A, start, middle);
		Subarray rightSubarray = maxSubarrayRec(A, middle+1, end);
		Subarray crossSubarray = crossSubarray(A, start, middle, end);
		
		if(leftSubarray.compareTo(rightSubarray) > 0 && leftSubarray.compareTo(crossSubarray) > 0) {
			return leftSubarray;
		} else if(rightSubarray.compareTo(leftSubarray) > 0 && rightSubarray.compareTo(crossSubarray) > 0) {
			return rightSubarray;
		} else {
			return crossSubarray;
		}
	}
	
	private Subarray crossSubarray(int [] A, int start, int middle, int end) {
		int leftMaxSum = Integer.MIN_VALUE;
		int leftMaxStart = 0;
		int rightMaxSum = Integer.MIN_VALUE;
		int rightMaxEnd = 0;
		
		int leftSum = 0;
		for(int i=middle; i>=start; i--) {
			leftSum += A[i];
			if(leftSum > leftMaxSum) {
				leftMaxSum = leftSum;
				leftMaxStart = i;
			}
		}
		
		int rightSum = 0;
		for(int i=middle+1; i<=end; i++) {
			rightSum += A[i];
			if(rightSum > rightMaxSum) {
				rightMaxSum = rightSum;
				rightMaxEnd = i;
			}
		}
		
		return new Subarray(leftMaxStart, rightMaxEnd, leftMaxSum+rightMaxSum);
	}
	
	public Subarray maxSubarrayKadane(int [] A) {
		int currentSum = A[0];
		int maxSum = A[0];
		
		int currentStartIndex = 0;
		int maxStartIndex = 0;
		
		int currentEndIndex = 0;
		int maxEndIndex = 0;
		
		for(int i=1; i< A.length; i++) {
			if(currentSum + A[i] > A[i]) {
				currentSum += A[i];
				currentEndIndex = i;
			} else {
				currentSum = A[i];
				currentStartIndex = i;
				currentEndIndex = i;
			}
			
			if(currentSum > maxSum) {
				maxSum = currentSum;
				maxStartIndex = currentStartIndex;
				maxEndIndex = currentEndIndex;
			}
		}
			
		return new Subarray(maxStartIndex, maxEndIndex, maxSum);
	}
	
	public Subarray2D max2DSubarray(int [][] A) {
		Subarray maxSubarray = null;
		int maxI = -1;
		int maxJ = -1;
		int [] temp = null;
		for(int i=0; i<A[0].length; i++) {
			for(int j=i; j<A[0].length; j++) {
				if(i == j) {
					temp = copyColumn(A, i);
				} else {
					addArray1ToArray2(A, j, temp);
				}
				Subarray subarray = maxSubarrayKadane(temp);
				if(maxSubarray == null || maxSubarray.compareTo(subarray) < 0) {
					maxSubarray = subarray;
					maxI = i;
					maxJ = j;
				}
			}
		}
		return new Subarray2D(maxSubarray.getStart(), maxSubarray.getEnd(), maxI, maxJ, maxSubarray.getMax());
	}
	
	private void addArray1ToArray2(int [][] A1, int col, int [] A2) {
		for(int i=0; i<A1.length; i++) {
			A2[i] = A2[i] + A1[i][col];
		}
	}
	
	private int [] copyColumn(int [][] A, int col) {
		int [] temp = new int[A.length];
		for(int i=0; i<A.length; i++) {
			temp[i] = A[i][col];
		}
		return temp;
	}
	
	public static class Subarray implements Comparable<Subarray> {
		private final int start;
		private final int end;
		private final int max;
		
		public Subarray(int start, int end, int max) {
			this.start = start;
			this.end = end;
			this.max = max;
		}
		public int getStart() {
			return start;
		}
		public int getEnd() {
			return end;
		}
		public int getMax() {
			return max;
		}
		@Override
		public int compareTo(Subarray o) {
			return ((Integer)max).compareTo(o.getMax());
		}
		@Override
		public String toString() {
			return "Start "+start+", End "+end+", Max "+max;
		}
	}
	
	public static class Subarray2D extends Subarray implements Comparable<Subarray> {
		private final int start2;
		private final int end2;
		
		public Subarray2D(int start, int end, int start2, int end2, int max) {
			super(start, end, max);
			this.start2 = start2;
			this.end2 = end2;
		}
		
		public int getStart2() {
			return start2;
		}

		public int getEnd2() {
			return end2;
		}

		@Override
		public String toString() {
			return "Start "+getStart()+", Start2 "+getStart2()+", End "+getEnd()+", End2 "+getEnd2()+", Max "+getMax();
		}
	}
}
