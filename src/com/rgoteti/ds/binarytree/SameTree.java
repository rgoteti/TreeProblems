package com.rgoteti.ds.binarytree;

public class SameTree {
	public static void main(String args[])
	{
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(12);
		bt.root.right =  new Node(13);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(14);
		bt.root.right.left.right = new Node(16);
		
		BinaryTree bts = new BinaryTree();
		bts.root = new Node(10);
		bts.root.left = new Node(12);
		bts.root.right =  new Node(13);
		bts.root.right.left = new Node(15);
		bts.root.right.right = new Node(14);
		bts.root.right.left.right = new Node(16);
		
		System.out.println(new SameTree().isSameTree(bt.root, bts.root));
		//bt.inOrderTraversal(bt.root);
	}
	
	public boolean isSameTree(Node a, Node b)
	{
		if(a==null && b==null) return true;
		else if(a==null || b==null) return false;
		
		if(a.data == b.data)
			return isSameTree(a.left,b.left) && isSameTree(a.right, b.right);
		
		return false;
	}
}