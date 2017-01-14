package amazonprep.algorithms.greedy;

import static org.junit.Assert.*;

import org.junit.Test;

import amazonprep.algorithms.greedy.Huffman.CharacterCode;
import amazonprep.algorithms.greedy.Huffman.CharacterFrequency;
import amazonprep.algorithms.sort.IntMinMaxProvider;
import amazonprep.algorithms.tree.BinaryTree;
import amazonprep.algorithms.tree.BinaryTreeNode;

public class HuffmanTest {

	@Test
	public void testGetCode() {
		Huffman h = new Huffman(new IntMinMaxProvider());
		Huffman.CharacterFrequency f1 = new Huffman.CharacterFrequency('a', 45);
		Huffman.CharacterFrequency f2 = new Huffman.CharacterFrequency('b', 13);
		Huffman.CharacterFrequency f3 = new Huffman.CharacterFrequency('c', 12);
		Huffman.CharacterFrequency f4 = new Huffman.CharacterFrequency('d', 16);
		Huffman.CharacterFrequency f5 = new Huffman.CharacterFrequency('e', 9);
		Huffman.CharacterFrequency f6 = new Huffman.CharacterFrequency('f', 5);
		BinaryTree<Integer, CharacterFrequency> codes = h.getCode(new Huffman.CharacterFrequency [] {f1, f2, f3, f4, f5, f6});
		BinaryTreeNode<Integer, CharacterFrequency> root = codes.getRoot();
		BinaryTreeNode<Integer, CharacterFrequency> aNode = root.getLeft(); 
		assertNotNull(aNode);
		assertEquals('a', aNode.getData().getCharacter());
		BinaryTreeNode<Integer, CharacterFrequency> root1 = root.getRight();
		assertNotNull(root1);
		BinaryTreeNode<Integer, CharacterFrequency> root10 = root1.getLeft();
		assertNotNull(root10);
		BinaryTreeNode<Integer, CharacterFrequency> cNode = root10.getLeft(); 
		assertNotNull(cNode);
		assertEquals('c', cNode.getData().getCharacter());
		BinaryTreeNode<Integer, CharacterFrequency> bNode = root10.getRight(); 
		assertNotNull(bNode);
		assertEquals('b', bNode.getData().getCharacter());
		BinaryTreeNode<Integer, CharacterFrequency> root11 = root1.getRight();
		assertNotNull(root11);
		BinaryTreeNode<Integer, CharacterFrequency> root110 = root11.getLeft();
		assertNotNull(root110);
		BinaryTreeNode<Integer, CharacterFrequency> fNode = root110.getLeft(); 
		assertNotNull(fNode);
		assertEquals('f', fNode.getData().getCharacter());
		BinaryTreeNode<Integer, CharacterFrequency> eNode = root110.getRight(); 
		assertNotNull(eNode);
		assertEquals('e', eNode.getData().getCharacter());
		BinaryTreeNode<Integer, CharacterFrequency> dNode = root11.getRight(); 
		assertNotNull(dNode);
		assertEquals('d', dNode.getData().getCharacter());
	}

	@Test
	public void testGetCodeAsString() {
		Huffman h = new Huffman(new IntMinMaxProvider());
		Huffman.CharacterFrequency f1 = new Huffman.CharacterFrequency('a', 45);
		Huffman.CharacterFrequency f2 = new Huffman.CharacterFrequency('b', 13);
		Huffman.CharacterFrequency f3 = new Huffman.CharacterFrequency('c', 12);
		Huffman.CharacterFrequency f4 = new Huffman.CharacterFrequency('d', 16);
		Huffman.CharacterFrequency f5 = new Huffman.CharacterFrequency('e', 9);
		Huffman.CharacterFrequency f6 = new Huffman.CharacterFrequency('f', 5);
		CharacterCode[] codeAsString = h.getCodeAsString(new Huffman.CharacterFrequency [] {f1, f2, f3, f4, f5, f6});
		
		assertEquals('a', codeAsString[0].getCharacter());
		assertEquals("0", codeAsString[0].getCode());
		assertEquals('b', codeAsString[1].getCharacter());
		assertEquals("101", codeAsString[1].getCode());
		assertEquals('c', codeAsString[2].getCharacter());
		assertEquals("100", codeAsString[2].getCode());
		assertEquals('d', codeAsString[3].getCharacter());
		assertEquals("111", codeAsString[3].getCode());
		assertEquals('e', codeAsString[4].getCharacter());
		assertEquals("1101", codeAsString[4].getCode());
		assertEquals('f', codeAsString[5].getCharacter());
		assertEquals("1100", codeAsString[5].getCode());
	}
}
