package edu.diva.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FormTreeWith0sAnd1S {
	
	public static void main(String[] args) {
		String sequence = "1011100";
		
		TreeNode root = new TreeNode(sequence.charAt(0));
		
		for(int i = 1;i<=sequence.length()-2;i+=2) {
			
			TreeNode left = new TreeNode(sequence.charAt(i));
			TreeNode right  = new TreeNode(sequence.charAt(i+1));
			boolean canProceed = TreeUtil.insertNewNodes(root, left, right); 
			if(!canProceed)
				break;
		}
		
		System.out.println(TreeUtil.getHeightOfTree(root));
	}
	
}

class TreeUtil {
	
	private static final char ONE = '1';
	
	public static int getHeightOfTree(TreeNode node) {
		if(node == null) {
			return -1;
		}
		 int lefth = getHeightOfTree(node.left);
		 int righth = getHeightOfTree(node.right);
		 if (lefth > righth) {
		        return lefth + 1;
		    } else {
		        return righth + 1;
		}
	}
	
	public static boolean insertNewNodes(TreeNode root, TreeNode left, TreeNode right) {
		TreeNode node = fetchParentNode(root);
		if(node == null)
			return false;
		node.left = left;
		node.right = right;
		return true;
	}
	
	public static TreeNode fetchParentNode(TreeNode node) {
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(node);
		while(!nodes.isEmpty()) {
			TreeNode current = nodes.poll();
			if(current.left == null && current.right == null && current.data == ONE) {
				return current;
			}
			if(current.left != null)
				nodes.add(current.left);
			if(current.right != null)
				nodes.add(current.right);
		}
		return null;
	}
}

class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(char data) {
		this.data = data;
	}
	
}