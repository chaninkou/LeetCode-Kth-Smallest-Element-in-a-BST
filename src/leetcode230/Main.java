package leetcode230;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {	
		BinarySearchTree tree = new BinarySearchTree();
		
		int[] input = {100,90,80,70,85,84,86};
		
		int k = 3;
		
		System.out.println("Input: " + Arrays.toString(input));
		
		tree.addTreeNode(input);
		
		System.out.println("The " + k + "th smallest element: ");
		
		System.out.println(tree.kthSmallest2(tree.root, k));
		
	}
}
