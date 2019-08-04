package com.rgoteti.ds.binarytree;

public class SameTree {
	public static void main(String args[])
	{
		BinarTree bt = new BinarTree();
		bt.root = new Node(10);
		bt.root.left = new Node(12);
		bt.root.right =  new Node(13);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(14);
		bt.root.right.left.right = new Node(16);
		
		BinarTree bts = new BinarTree();
		bts.root = new Node(10);
		bts.root.left = new Node(12);
		bts.root.right =  new Node(13);
		bts.root.right.left = new Node(15);
		bts.root.right.right = new Node(14);
		bts.root.right.left.right = new Node(16);
		
		System.out.println(bt.isSameTree(bt.root, bts.root));
		//bt.inOrderTraversal(bt.root);
	}
}


class BinarTree
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
	
	public boolean isSameTree(Node a, Node b)
	{
		if(a==null && b==null) return true;
		else if(a==null || b==null) return false;
		
		if(a.data == b.data)
			return isSameTree(a.left,b.left) && isSameTree(a.right, b.right);
		
		return false;
	}
}
class Node
{
	int data;
	Node left,right;
	
	public Node()
	{	
	}
	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
	public Node(int data, Node left, Node right) {	
		this.data = data;
		this.left = left;
		this.right = right;
	}	
}
