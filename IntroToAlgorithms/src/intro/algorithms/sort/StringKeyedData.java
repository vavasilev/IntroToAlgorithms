package intro.algorithms.sort;

public class StringKeyedData implements KeyedData<String> {
	String key;
	
	public StringKeyedData(String key) {
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

	public static StringKeyedData [] toStringSortableArray(String [] A) {
		StringKeyedData [] result = new StringKeyedData [A.length];
		for(int i=0; i< A.length; i++) {
			result[i] = new StringKeyedData(A[i]);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return ""+key;
	}
}
