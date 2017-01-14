package intro.algorithms.anagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramBuilderTest {

	@Test
	public void test() {
		AnagramBuilder builder = new AnagramBuilder();
		// n*logM
		builder.addWord("cat");
		builder.addWord("dog");
		builder.addWord("tac");
		builder.addWord("god");
		builder.addWord("act");
		
		assertEquals("[cat, tac, act](,[dog, god])", builder.getAnagrams().toString());
	}
}
