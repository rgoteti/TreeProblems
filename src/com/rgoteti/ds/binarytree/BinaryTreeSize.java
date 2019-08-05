package com.rgoteti.ds.binarytree;

public class BinaryTreeSize {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(12);
		bt.root.right =  new Node(13);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(14);
		bt.root.right.left.right = new Node(16);
		
		System.out.println(new BTS().binaryTreeSize(bt.root));
	}	
}

//Space complexity: It depends on the size of stack i.e height of binary tree
//Time Complexity: O(n) as we are visiting all the nodes once.
class BTS extends BinaryTree
{
	public int binaryTreeSize(Node node)
	{
		if(node==null)
			return 0;
		else
			return 1+binaryTreeSize(node.left)+binaryTreeSize(node.right);
			
	}
}
