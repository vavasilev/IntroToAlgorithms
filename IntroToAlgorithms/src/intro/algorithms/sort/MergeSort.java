package intro.algorithms.sort;

public class MergeSort<T extends Comparable<T>, U extends KeyedData<T>> implements SortingAlgorithm<T, U> {
	
	private MinMaxProvider<T, U> minMaxProvider;
	
	public MergeSort(MinMaxProvider<T, U> minMaxProvider) {
		this.minMaxProvider = minMaxProvider;
	}

	@Override
	public U[] sort(U[] A) {
		mergeSort(A, 0, A.length-1);
		return A;
	}
	
	private void mergeSort(U[] A, int start, int end) {
		if(start == end) {
			return;
		}
		int middle = (end + start)/2;
		mergeSort(A, start, middle);
		mergeSort(A, middle+1, end);
		merge(A, start, middle, end);
	}
	
	private void merge(U[] A, int start, int middle, int end) {
		int length1 = middle - start + 1;
		int length2 = end - middle;
		
		KeyedData<T>[] L1 = new KeyedData[length1+1];
		KeyedData<T>[] L2 = new KeyedData[length2+1];
		
		for(int i=0; i<length1; i++) {
			L1[i] = A[start+i];
		}
		L1[length1] = minMaxProvider.getMaxSortable();
		
		for(int i=0; i<length2; i++) {
			L2[i] = A[middle+i+1];
		}
		L2[length2] = minMaxProvider.getMaxSortable();
		
		int l1I = 0;
		int l2I = 0;
		for(int i=start; i<=end; i++) {
			if(L1[l1I].getKey().compareTo(L2[l2I].getKey()) <= 0) {
				A[i] = (U)L1[l1I];
				l1I++;
			} else {
				A[i] = (U)L2[l2I];
				l2I++;
			}
		}
	}

	@Override
	public String getName() {
		return "Merge Sort";
	}

}
