package intro.algorithms.sort;

public class IntKeyedData implements KeyedData<Integer> {

	int key;
	
	public IntKeyedData(int key) {
		this.key = key;
	}
	
	@Override
	public Integer getKey() {
		return key;
	}

	@Override
	public void setKey(Integer key) {
		this.key = key;
	}

	public static IntKeyedData [] toSimpleSortableArray(int [] A) {
		IntKeyedData [] result = new IntKeyedData [A.length];
		for(int i=0; i< A.length; i++) {
			result[i] = new IntKeyedData(A[i]);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return ""+key;
	}
}
