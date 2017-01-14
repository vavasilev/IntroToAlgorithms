package intro.algorithms.other;

import java.util.stream.Stream;

import intro.algorithms.sort.IntKeyedData;
import intro.datastructures.hashtable.Hashtable;
import intro.datastructures.hashtable.LinkedListHashtable;

public class EmitNonRepeatingNumbers {

	public Stream<IntKeyedData> emit(Stream<IntKeyedData> input) {
		Hashtable<IntKeyedData> table = new LinkedListHashtable<>(1000);
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
