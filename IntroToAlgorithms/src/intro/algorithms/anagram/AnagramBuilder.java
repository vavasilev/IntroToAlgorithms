package amazonprep.algorithms.anagram;

import amazonprep.algorithms.tree.BinarySearchTree;
import amazonprep.algorithms.tree.DataMerger;

public class AnagramBuilder {
	
	private DataMerger<Anagram> dataMerger = new DataMerger<Anagram>() {

		@Override
		public Anagram mergeData(Anagram existingData, Anagram newData) {
			existingData.union(newData);
			return existingData;
		}
		
	};
	
	public AnagramBuilder() {
		anagrams.setDataMerger(dataMerger);
	}

	private BinarySearchTree<String, Anagram> anagrams = new BinarySearchTree<String, Anagram>();
	
	public void addWord(String word) {
		Anagram anagram = new Anagram(word);
		
		anagrams.insertOrUpdateData(anagram, true);
	}

	public BinarySearchTree<String, Anagram> getAnagrams() {
		return anagrams;
	}
}
