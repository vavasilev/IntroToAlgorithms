package intro.algorithms.sort;

public class DoubleSortable implements KeyedData<Double> {
	double key;
	
	public DoubleSortable(double key) {
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

	public static DoubleSortable [] toSimpleSortableArray(double [] A) {
		DoubleSortable [] result = new DoubleSortable [A.length];
		for(int i=0; i< A.length; i++) {
			result[i] = new DoubleSortable(A[i]);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return ""+key;
	}
}
