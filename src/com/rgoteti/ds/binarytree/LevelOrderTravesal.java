package com.rgoteti.ds.binarytree;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTravesal {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(0);
		bt.root.right =  new Node(25);
		bt.root.left.left = new Node(-1);
		bt.root.left.right = new Node(1);
		bt.root.right.left = new Node(16);
		bt.root.right.right = new Node(32);
		
		new LevelOrderTravesal().levelOrderTraversal(bt.root);
	}
	
	public void levelOrderTraversal(Node node)
	{
		if(node == null) return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		Node temp;
		while(!q.isEmpty())
		{
			temp = q.remove();
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			System.out.println(temp.data);
		}
	}
}
