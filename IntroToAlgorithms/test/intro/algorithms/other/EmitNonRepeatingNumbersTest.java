package intro.algorithms.other;

import static org.junit.Assert.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;

public class EmitNonRepeatingNumbersTest {

	@Test
	public void test() {
		EmitNonRepeatingNumbers algo = new EmitNonRepeatingNumbers();
		
		IntStream stream = IntStream.of(12, 33, 54, 33, 2, 5, 2, 1, 13, 12);
		Stream<String> result = algo.emit(
				stream.<IntKeyedData>mapToObj(num -> new IntKeyedData(num))).
				map(sortable -> sortable.toString());
		String resultStr = result.collect(Collectors.joining(", "));
		assertEquals("12, 33, 54, 2, 5, 1, 13", resultStr);
	}

}
