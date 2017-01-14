package intro.algorithms.anagram;

import intro.algorithms.sort.KeyedData;
import intro.datastructures.list.LinkedList;

public class Anagram implements KeyedData<String> {

	private String representative;
	private LinkedList<String> words = new LinkedList<String>();
	
	public Anagram(String word) {
		words.insertData(word);
		representative = sortWordChars(word);
	}
	
	@Override
	public String getKey() {
		return representative;
	}

	@Override
	public void setKey(String key) {
		this.representative = key;
	}
	
	public void union(Anagram other) {
		if(other.representative.equals(representative)) {
			words.union(other.words);
		}
	}

	public LinkedList<String> getWords() {
		return words;
	}
	
	private String sortWordChars(String word) {
		// Counting sort
		byte chars[] = new byte[52];
		byte[] wordBytes = word.getBytes();
		for(byte wordByte : wordBytes) {
			if(wordByte >= 65 && wordByte <= 90) {
				chars[wordByte-65]++;
			} else if(wordByte >= 97 && wordByte <= 122) {
				chars[wordByte-71]++;
			}
		}
		
		for(int i=1; i<chars.length; i++) {
			chars[i] = (byte)(chars[i] + chars[i-1]);
		}
		
		byte result [] = new byte[wordBytes.length];
		
		for(int i=result.length-1; i>=0; i--) {
			byte wordByte = wordBytes[i];
			int index = 0;
			if(wordByte >= 65 && wordByte <= 90) {
				index = wordByte-65;
			} else if(wordByte >= 97 && wordByte <= 122) {
				index = wordByte-71;
			} else {
				continue;
			}
			result[chars[index]-1] = wordBytes[i];
			chars[index]--;
		}
		return new String(result);
	}

	@Override
	public String toString() {
		return "["+words.toString()+"]";
	}
}
