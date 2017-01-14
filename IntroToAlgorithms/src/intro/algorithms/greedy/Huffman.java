package intro.algorithms.greedy;

import java.util.HashMap;
import java.util.Map;

import intro.algorithms.sort.MinMaxProvider;
import intro.algorithms.sort.KeyedData;
import intro.algorithms.tree.BinaryTree;
import intro.algorithms.tree.BinaryTreeNode;
import intro.algorithms.tree.BinaryTreeVisitor;
import intro.algorithms.tree.WalkOrder;
import intro.algorithms.tree.WalkOrderData;
import intro.datastructures.heap.Heap;
import intro.datastructures.heap.Heap.HeapType;

public class Huffman {
	
	private MinMaxProvider<Integer, ? extends KeyedData<Integer>> minMaxProvider;
	
	public Huffman(MinMaxProvider<Integer, ? extends KeyedData<Integer>> minMaxProvider) {
		this.minMaxProvider = minMaxProvider;
	}
	
	public BinaryTree<Integer, CharacterFrequency> getCode(CharacterFrequency [] frequencies) {
		Heap<Integer, BinaryTreeNode<Integer, CharacterFrequency>> h = new Heap<Integer, BinaryTreeNode<Integer, CharacterFrequency>>(toTreeNodes(frequencies), frequencies.length, HeapType.MIN);
		h.maintainHeapPropertyAll();
		while(h.getSize() > 1) {
			BinaryTreeNode<Integer, CharacterFrequency> f1 = h.extractOptimalElement();
			BinaryTreeNode<Integer, CharacterFrequency> f2 = h.extractOptimalElement();
			BinaryTreeNode<Integer, CharacterFrequency> parent = new BinaryTreeNode<Integer, CharacterFrequency>(new CharacterFrequency((char)0, f1.getData().getFrequency()+f2.getData().getFrequency()));
			parent.setLeft(f1);
			parent.setRight(f2);
			f1.setParent(parent);
			f2.setParent(parent);
			h.insert(parent, minMaxProvider);
		}
		
		BinaryTree<Integer, CharacterFrequency> result = new BinaryTree<Integer, CharacterFrequency>();
		result.setRoot(h.extractOptimalElement());
		
		return result;
	}
	
	public CharacterCode [] getCodeAsString(CharacterFrequency [] frequencies) {
		BinaryTree<Integer, CharacterFrequency> tree = getCode(frequencies);
		
		FrequencyTreeVisitor visitor = new FrequencyTreeVisitor();
		tree.accept(visitor, WalkOrder.POST);
		Map<Character, CharacterCode> codeMap = visitor.getCodes();
		
		CharacterCode [] codes = new CharacterCode[frequencies.length];
		
		for(int i=0; i<frequencies.length; i++) {
			char character = frequencies[i].getCharacter();
			codes[i] = codeMap.get(character);
		}
		
		return codes;
	}
	
	public static class FrequencyTreeVisitor implements BinaryTreeVisitor<Integer, CharacterFrequency> {
		
		private Map<Character, CharacterCode> codes = new HashMap<Character, CharacterCode>();
		int codeIndex = 0;
		
		@Override
		public void visit(BinaryTreeNode<Integer, CharacterFrequency> node, WalkOrder walkOrder, WalkOrderData data) {
			if(node.isLeaf()) {
				StringBuilder sb = new StringBuilder();
				BinaryTreeNode<Integer, CharacterFrequency> tempNode = node;
				while(tempNode.getParent() != null) {
					sb.insert(0, tempNode == tempNode.getParent().getLeft() ? "0" : "1");
					tempNode = tempNode.getParent();
				}
				char character = node.getData().getCharacter();
				CharacterCode code = new CharacterCode(character, sb.toString());
				codes.put(character, code);
				codeIndex++;
			}
		}

		public Map<Character, CharacterCode> getCodes() {
			return codes;
		}
		
	}
	
	private BinaryTreeNode<Integer, CharacterFrequency>[] toTreeNodes(CharacterFrequency [] frequencies) {
		BinaryTreeNode<Integer, CharacterFrequency> [] nodes = new BinaryTreeNode[frequencies.length];
		
		for(int i=0; i<frequencies.length; i++) {
			nodes[i] = new BinaryTreeNode<Integer, CharacterFrequency>(frequencies[i]);
		}
		
		return nodes;
	}

	public static class CharacterFrequency implements KeyedData<Integer> {
		private char character;
		private int frequency;
		public CharacterFrequency(char character, int frequency) {
			super();
			this.character = character;
			this.frequency = frequency;
		}
		public char getCharacter() {
			return character;
		}
		public int getFrequency() {
			return frequency;
		}
		@Override
		public Integer getKey() {
			return frequency;
		}
		@Override
		public void setKey(Integer key) {
			this.frequency = key;
		}
	}
	
	public static class CharacterCode {
		private char character;
		private String code;
		public CharacterCode(char character, String code) {
			super();
			this.character = character;
			this.code = code;
		}
		public char getCharacter() {
			return character;
		}
		public String getCode() {
			return code;
		}
	}
}
