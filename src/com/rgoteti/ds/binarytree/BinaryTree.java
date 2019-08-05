package com.rgoteti.ds.binarytree;

public class BinaryTree
{
	Node root;
	
	public void inOrderTraversal(Node temp)
	{
		if(temp==null)
			return;
		inOrderTraversal(temp.left);
		System.out.println(temp.data);
		inOrderTraversal(temp.right);
	}
	
}
