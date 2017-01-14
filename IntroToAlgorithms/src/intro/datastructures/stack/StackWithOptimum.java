package intro.datastructures.stack;

import intro.algorithms.sort.KeyedData;

public class StackWithOptimum<T extends Comparable<T>, U extends KeyedData<T>> extends Stack<U> {
	
	public static enum StackWithOptimumType {
		MIN, MAX
	}
	
	private Stack<U> optimumStack;
	private StackWithOptimumType type;
	
	public StackWithOptimum(int size, StackWithOptimumType type) {
		super(size);
		optimumStack = new Stack<U>(size);
		this.type = type;
	}

	@Override
	public void push(U elm) {
		super.push(elm);
		if(StackWithOptimumType.MIN == type && (optimumStack.isEmpty() || optimumStack.top().getKey().compareTo(elm.getKey()) >= 0)) {
			optimumStack.push(elm);
		} else if(StackWithOptimumType.MAX == type && (optimumStack.isEmpty() || optimumStack.top().getKey().compareTo(elm.getKey()) <= 0)) {
			optimumStack.push(elm);
		}
	}

	@Override
	public U pop() {
		U elm = super.pop();
		if(elm.getKey() == optimumStack.top().getKey()) {
			optimumStack.pop();
		}
		return elm;
	}
	
	@Override
	public U top() {
		return super.top();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	public U optimum() {
		return optimumStack.top();
	}
}
