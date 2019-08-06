package com.rgoteti.ds.binarytree;

public class BTisBST {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(0);
		bt.root.right =  new Node(25);
		bt.root.left.left = new Node(-1);
		bt.root.left.right = new Node(1);
		bt.root.right.left = new Node(16);
		bt.root.right.right = new Node(32);

		//bt.inOrderTraversal(bt.root);
		System.out.println(new ISBST().isBST(bt.root, Integer.MIN_VALUE, Integer.MAX_VALUE)); 
	}
}

class ISBST extends BinaryTree
{
	public boolean isBST(Node node, int min, int max)
	{
		if(node==null) return true;
		if(node.data>min && node.data<max)
			return isBST(node.left,min,node.data) && isBST(node.right,node.data,max);
		else 
			return false;
	}
}
