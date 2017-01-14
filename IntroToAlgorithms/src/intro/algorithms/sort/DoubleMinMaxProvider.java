package intro.algorithms.sort;

public class DoubleMinMaxProvider implements MinMaxProvider<Double, DoubleSortable> {

	@Override
	public Double getMinKey() {
		return Double.MIN_VALUE;
	}

	@Override
	public Double getMaxKey() {
		return Double.MAX_VALUE;
	}

	@Override
	public DoubleSortable getMinKeyedData() {
		return new DoubleSortable(getMinKey());
	}

	@Override
	public DoubleSortable getMaxKeyedData() {
		return new DoubleSortable(getMaxKey());
	}
}
