package intro.algorithms.sort;

import intro.datastructures.heap.HeapContext;

public class IntKeyedData implements KeyedData<Integer>, HeapContext {

	private int key;
	private Object element;
	
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

	@Override
	public void setBackingElement(Object element) {
		this.element = element;
	}

	@Override
	public Object getBackingElement() {
		return element;
	}
}
