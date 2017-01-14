package amazonprep.algorithms.sort;

public class StringSortable implements Sortable<String> {
	String key;
	
	public StringSortable(String key) {
		this.key = key;
	}
	
	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	public static StringSortable [] toStringSortableArray(String [] A) {
		StringSortable [] result = new StringSortable [A.length];
		for(int i=0; i< A.length; i++) {
			result[i] = new StringSortable(A[i]);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return ""+key;
	}
}
