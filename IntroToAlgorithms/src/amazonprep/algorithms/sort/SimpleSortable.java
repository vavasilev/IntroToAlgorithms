package amazonprep.algorithms.sort;

public class SimpleSortable implements Sortable<Integer> {

	int key;
	
	public SimpleSortable(int key) {
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

	public static SimpleSortable [] toSimpleSortableArray(int [] A) {
		SimpleSortable [] result = new SimpleSortable [A.length];
		for(int i=0; i< A.length; i++) {
			result[i] = new SimpleSortable(A[i]);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return ""+key;
	}
}
