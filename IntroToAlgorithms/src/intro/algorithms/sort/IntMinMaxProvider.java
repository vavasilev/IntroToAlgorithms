package amazonprep.algorithms.sort;

public class IntMinMaxProvider implements
	MinMaxProvider<Integer, SimpleSortable> {

	@Override
	public Integer getMinKey() {
		return Integer.MIN_VALUE;
	}

	@Override
	public Integer getMaxKey() {
		return Integer.MAX_VALUE;
	}

	@Override
	public SimpleSortable getMinSortable() {
		return new SimpleSortable(getMinKey());
	}

	@Override
	public SimpleSortable getMaxSortable() {
		return new SimpleSortable(getMaxKey());
	}

}
