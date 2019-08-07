package com.rgoteti.ds.binarytree;

import java.util.ArrayList;

public class RootToLeafSum {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(12);
		bt.root.right =  new Node(13);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(14);
		bt.root.right.left.right = new Node(16);

		RootToLeafSum bl = new RootToLeafSum();
		bl.rooToLeafSum(bt.root, 37);
		bl.printAl();				
	}

	//Space complexity: 
	//Time Complexity: 

	ArrayList<Integer> list = new ArrayList<Integer>();
	public boolean rooToLeafSum(Node node, int value)
	{
		if(node == null)
			return false;
		if(node.left==null && node.right==null && node.data-value==0)
		{
			list.add(node.data);
			return true;
		}
		
		if(rooToLeafSum(node.left,value-node.data))
		{
			list.add(node.data);
			return true;
		}
		if(rooToLeafSum(node.right,value-node.data))
		{
			list.add(node.data);
			return true;
		}
		return false;
	}
	
	public void printAl()
	{
		for(int i:list)
			System.out.println(i);
	}
}