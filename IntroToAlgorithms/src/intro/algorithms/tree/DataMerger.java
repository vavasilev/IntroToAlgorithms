package intro.algorithms.tree;

public interface DataMerger<T> {

	T mergeData(T existingData, T newData);
}
