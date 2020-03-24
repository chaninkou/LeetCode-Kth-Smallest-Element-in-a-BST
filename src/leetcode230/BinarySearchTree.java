package leetcode230;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
	TreeNode root;
	
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        // In order travesal
        while(root != null || !stack.isEmpty()){
        	// Most left children
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            // update the pointer
            k--;
            
            // 0 means we reach the kth children
            if(k == 0){
                break;
            }
            
            // Get the right child now
            root = root.right;
        }
        
        return root.val;
    }
	
	public int kthSmallest2(TreeNode root, int k) {
        List<TreeNode> result = new ArrayList<>();
        
        inorder(root, result);
        
        // k - 1 will get the elements
        return result.get(k - 1).val; 
    }
	
	// recursive for inorder traversal
	private void inorder(TreeNode root, List<TreeNode> result){
		if(root == null){
			return;
		}
		
		inorder(root.left, result);
		
		result.add(root);
		
		inorder(root.right, result);
	}

	public void addTreeNode(int[] values) {
		TreeNode nodeToAdd;
		
		for(int value : values){
			nodeToAdd= new TreeNode(value);
			
			if(root == null){
				root = nodeToAdd;
			}
			
			traverseAndAddNode(root, nodeToAdd);
		}

	}
	
	public void traverseAndAddNode(TreeNode root, TreeNode nodeToAdd){		
		if(nodeToAdd.val < root.val){
			if(root.left == null){
				root.left = nodeToAdd;
			} else {
				traverseAndAddNode(root.left,nodeToAdd);
			}
		} else if (nodeToAdd.val > root.val){
			if(root.right == null){
				root.right = nodeToAdd;
			} else {
				traverseAndAddNode(root.right, nodeToAdd);
			}
		}
	}

}
