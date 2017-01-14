package intro.algorithms.sort;

public class DoubleMinMaxProvider implements MinMaxProvider<Double, DoubleKeyedData> {

	@Override
	public Double getMinKey() {
		return Double.MIN_VALUE;
	}

	@Override
	public Double getMaxKey() {
		return Double.MAX_VALUE;
	}

	@Override
	public DoubleKeyedData getMinKeyedData() {
		return new DoubleKeyedData(getMinKey());
	}

	@Override
	public DoubleKeyedData getMaxKeyedData() {
		return new DoubleKeyedData(getMaxKey());
	}
}
