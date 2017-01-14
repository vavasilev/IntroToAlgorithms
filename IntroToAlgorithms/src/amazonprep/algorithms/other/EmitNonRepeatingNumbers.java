package amazonprep.algorithms.other;

import java.util.stream.Stream;

import amazonprep.algorithms.sort.SimpleSortable;
import amazonprep.datastructures.hashtable.Hashtable;
import amazonprep.datastructures.hashtable.LinkedListHashtable;

public class EmitNonRepeatingNumbers {

	public Stream<SimpleSortable> emit(Stream<SimpleSortable> input) {
		Hashtable<SimpleSortable> table = new LinkedListHashtable<>(1000);
		return input.filter(num -> {
			if(table.getData(num.getKey()) != null) {
				return false;
			} else {
				table.insertData(num);
				return true;
			}
		});
	}
}
