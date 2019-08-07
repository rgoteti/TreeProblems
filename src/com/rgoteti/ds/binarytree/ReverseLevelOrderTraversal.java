package com.rgoteti.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		ReverseLevelOrderTraversal rlvl = new ReverseLevelOrderTraversal();
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(0);
		bt.root.right =  new Node(25);
		bt.root.left.left = new Node(-1);
		bt.root.left.right = new Node(1);
		bt.root.right.left = new Node(16);
		bt.root.right.right = new Node(32);
		
		rlvl.reverseLevelOrderTraversal(bt.root);
		
	}

	public void reverseLevelOrderTraversal(Node node)
	{
		if(node==null) return;
		Stack<Node> s = new Stack<Node>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			s.push(temp);
			if(temp.right!=null)
				q.add(temp.right);
			if(temp.left!=null)
				q.add(temp.left);			
		}
		while(!s.isEmpty())
		{
			System.out.print(" "+s.pop().data);
		}
	}
}
