package intro.algorithms.sort;

public class IntMinMaxProvider implements
	MinMaxProvider<Integer, IntKeyedData> {

	@Override
	public Integer getMinKey() {
		return Integer.MIN_VALUE;
	}

	@Override
	public Integer getMaxKey() {
		return Integer.MAX_VALUE;
	}

	@Override
	public IntKeyedData getMinKeyedData() {
		return new IntKeyedData(getMinKey());
	}

	@Override
	public IntKeyedData getMaxKeyedData() {
		return new IntKeyedData(getMaxKey());
	}

}
