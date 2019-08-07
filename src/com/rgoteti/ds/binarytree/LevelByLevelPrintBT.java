package com.rgoteti.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevelPrintBT {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(0);
		bt.root.right =  new Node(25);
		bt.root.left.left = new Node(-1);
		bt.root.left.right = new Node(1);
		bt.root.right.left = new Node(16);
		bt.root.right.right = new Node(32);
		
		new LevelByLevelPrintBT().levelByLevelPrintUsing2Queues(bt.root);
		new LevelByLevelPrintBT().levelByLevelPrintUsing1QueuesWithDelimiter(bt.root);
		new LevelByLevelPrintBT().levelByLevelOneQueueUsingCount(bt.root);
	}

	public void levelByLevelPrintUsing2Queues(Node node)
	{
		if(node==null) return;
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.add(node);
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			while(!q1.isEmpty())
			{
				Node temp = q1.remove();
				if(temp.left!=null)
					q2.add(temp.left);
				if(temp.right!=null)
					q2.add(temp.right);
				System.out.print(" "+temp.data);
			}
			System.out.println("\n");
			while(!q2.isEmpty())
			{
				Node temp = q2.remove();
				if(temp.left!=null)
					q1.add(temp.left);
				if(temp.right!=null)
					q1.add(temp.right);
				System.out.print(" "+temp.data);
			}
			System.out.println("\n");		
		}
	}
	
	public void levelByLevelPrintUsing1QueuesWithDelimiter(Node node)
	{
		if(node == null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp!=null)
			{
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				System.out.print(" "+temp.data);
			}else if(temp==null && !q.isEmpty())
			{
				System.out.println("\n");
				q.add(null);
			}
		}
	}
	
	public void levelByLevelOneQueueUsingCount(Node node)
	{
		if(node==null) return;
		Queue<Node> q = new LinkedList<Node>();
		int currentLevelCount=1;
		int nextLevelCount=0;
		q.add(node);
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			System.out.print(" "+temp.data);
			currentLevelCount--;
			if(temp.left!=null)
			{
				q.add(temp.left);
				nextLevelCount++;
			}
			if(temp.right!=null)
			{
				q.add(temp.right);
				nextLevelCount++;
			}
			if(currentLevelCount==0)
			{
				System.out.println("\n");
				currentLevelCount = nextLevelCount;
				nextLevelCount=0;
			}
		}
	}
}