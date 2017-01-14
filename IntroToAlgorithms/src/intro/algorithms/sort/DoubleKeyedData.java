package intro.algorithms.sort;

public class DoubleKeyedData implements KeyedData<Double> {
	double key;
	
	public DoubleKeyedData(double key) {
		this.key = key;
	}
	
	@Override
	public Double getKey() {
		return key;
	}

	@Override
	public void setKey(Double key) {
		this.key = key;
	}

	public static DoubleKeyedData [] toSimpleSortableArray(double [] A) {
		DoubleKeyedData [] result = new DoubleKeyedData [A.length];
		for(int i=0; i< A.length; i++) {
			result[i] = new DoubleKeyedData(A[i]);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return ""+key;
	}
}
