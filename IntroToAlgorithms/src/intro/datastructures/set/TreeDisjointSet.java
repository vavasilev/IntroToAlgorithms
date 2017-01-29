package intro.datastructures.set;

public class TreeDisjointSet<T extends DisjointSetBound> implements DisjointSet<T> {

	private int rank;
	private TreeDisjointSet<T> parent;
	
	public TreeDisjointSet() {
		this.parent = this;
	}
	
	public TreeDisjointSet<T> getParent() {
		return parent;
	}

	public void setParent(TreeDisjointSet<T> parent) {
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}
	
	public void incrementRank() {
		rank++;
	}
	
	public void union(DisjointSet<T> other) {
		if(other == this) {
			return;
		}
		
		TreeDisjointSet<T> otherTree = (TreeDisjointSet<T>)other;
		
		// Weighted union by rank
		if(this.getRank() > otherTree.getRank()) {
			otherTree.setParent(this);
		} else {
			this.setParent(otherTree);
			if(this.getRank() == otherTree.getRank()) {
				otherTree.incrementRank();
			}
		}
	}

	@Override
	public void findAndSetDisjointSet(T bound) {
		flattenDisjointSets();
		
		bound.setDisjointSet(getParent());
	}
	
	private void flattenDisjointSets() {
		TreeDisjointSet<T> parentSet = getParent();
		
		if(parentSet == this) {
			return;
		}
		
		parentSet.flattenDisjointSets();
		setParent(parentSet.getParent());
	}
}
