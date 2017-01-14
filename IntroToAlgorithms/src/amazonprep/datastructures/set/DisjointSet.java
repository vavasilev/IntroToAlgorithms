package amazonprep.datastructures.set;

import amazonprep.datastructures.list.ListElement;

public class DisjointSet<T> extends ListElement<T> {
	private DisjointSet<T> representative;
	
	public DisjointSet() {
		this.representative = this;
		this.representative.setNext(this);
		this.representative.setPrev(this);
	}

	public DisjointSet<T> getRepresentative() {
		return representative;
	}

	public void setRepresentative(DisjointSet<T> representative) {
		this.representative = representative;
	}
	
	public void union(DisjointSet<T> other) {
		ListElement<T> othersPrev = other.getRepresentative().getPrev();
		
		representative.getPrev().setNext(other.getRepresentative());
		other.getRepresentative().setPrev(representative);
		
		othersPrev.setNext(representative);
		representative.setPrev(othersPrev);
		
		DisjointSet<T> elm = other.getRepresentative();
		while(elm != representative) {
			elm.setRepresentative(representative);
			elm = (DisjointSet<T>)elm.getNext();
		}
	}
}
