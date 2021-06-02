package GardP2;
import java.util.List;

import java.util.Scanner;


import java.util.Arrays;
import java.io.*;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

import java.util.ArrayList;
public class BinaryTree {
	private class Node
	{
		public String data;
		public Node left;
		public Node right;
		
		public Node(String data, Node left, Node right)
		{ 
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root; 
	
	public BinaryTree()
	{
		root = new Node ("Is it a cat??",null,null);
	}
	
	
	public boolean hasNoLeft(String data, String data2) {
		return hasNoLeft(root, data, data2);
	}
	private boolean hasNoLeft(Node r, String data, String data2) {
		List <String> list = new ArrayList <String> ();
		if (r == null) {
			return false;
		}
		else {
			if (r.right != null) {
				list.addAll(hasNoLeft(r.right));
			}
			if (r.left != null) {
				list.addAll(hasNoLeft(r.left));
			}
			if (r.right != null && r.left == null) {
				list.add(r.data);
				
				
			}
			if (list.contains(data)) {
				
				return true;
			}
			else {
				return false;
			}
			
		}
	}
	
	public void moveLeft(String data, String data2) {
		moveLeft(root, data, data2);
	}
	private void moveLeft(Node r, String data, String data2) {
		
		if (r == null) {
			
		}
		else {
			if (r.right != null) {
				moveLeft(r.right, data, data2);
			}
			if (r.left != null) {
				moveLeft(r.left, data, data2);
			}
			if (r.right != null && r.left == null) {
				r.left = new Node (data2,null,null);
				
				
				
			}
			
	}
	}
	public List<String> hasNoLeft(){
		return hasNoLeft(root);
	}
	private List<String> hasNoLeft (Node r){
		List <String> list = new ArrayList <String> ();
		if (r == null) {
			return new ArrayList<String>();
		}
		else {
			if (r.right != null) {
				list.addAll(hasNoLeft(r.right));
			}
			if (r.left != null) {
				list.addAll(hasNoLeft(r.left));
			}
			if (r.right != null && r.left == null) {
				list.add(r.data);
				
			}
			return list;
	}
	}
	
public ArrayList<String> toList (){
		
		return toList(root);
	}
	private ArrayList<String> toList(Node r){
		if (r == null) {
			return new ArrayList <String> ();
		}
		else {
			ArrayList <String> it = new ArrayList <String> ();
			it.addAll(toList(r.left));
			it.add(r.data);
			it.addAll(toList(r.right));
			return it;
			
	}
	}

	public void replace (String data, String loco, String data2) {// data 2 points what goes to the right of tree 
	String pos = root.data;
	if (loco.equals("")) {
		pos = root.data;
		root.data = data;
		root.left = new Node (pos,null,null);// puts old data to left of tree
		root.right = new Node (data2,null,null); //puts new data to right of tree
		
	}
	else {
		Node ptr = root;
		String parentPart = loco.substring(0, loco.length()-1);
		String childPart = loco.substring(loco.length()-1);
		for (char c : parentPart.toCharArray()) {
			if (c == 'R') {
				ptr = ptr.right;
			}
			else {
				ptr = ptr.left;
			}
		}
			if (childPart.equals("L")) {
				pos = ptr.left.data;
				ptr.left.data = data;
				ptr.left.left = new Node (pos,null,null);
				ptr.left.right = new Node(data2,null,null);
				
				
			}
			else {
				pos = ptr.right.data;
				ptr.right.data = data;
				ptr.right.left = new Node(pos,null,null);
				ptr.right.right = new Node(data2,null,null);
				
			}
		}
		
		
		
		
	}

	
	
	public void add(String data, String directions)
	{
		if (root == null) 
		{
			root = new Node(data, null, null);
		}
		else
		{
			Node ptr = root; 
			String parentPart = directions.substring(0, directions.length()-1);
			String childPart = directions.substring(directions.length()-1);
			for (char c : parentPart.toCharArray()) 
			{
				if (c == 'L') 
					ptr = ptr.left;
				else
					ptr = ptr.right;
			}
			
			if (childPart.equals("L")) 
				ptr.left = new Node(data, null, null);
			else
				ptr.right = new Node(data, null, null);
		}
	}
public int sizeL() {
		
		return sizeL(root);
	}
	private int sizeL(Node r) {
		if (r == null) {
			return 0;
		}
		else {
			int leftSize = sizeL(r.left);
			return leftSize;
		}
	}
	
	public int size() {
		
		return size(root);
	}
	private int size(Node r) {
		if (r == null) {
			return 0;
		}
		else {
			int leftSize = size(r.left);
			int rightSize = size(r.right);
			return leftSize + rightSize + 1;
		}
	}

	public int height() {
		return height(root);
	}
	private int height(Node r) {
		if (r == null) {
			return -1;
		}
		else {
			int leftTree = height(r.left);
			int rightTree = height(r.left);
			if (leftTree > rightTree) {
				return leftTree+1;
			}
			else {
				return rightTree+1;
			}
		}
	}
	public int count(String s) {
		return count(s, root);
	}
	private int count (String t, Node r) {
		if (r == null) {
			return 0;
		}

		else {
			int leftTree = count(t, r.left);
			int rightTree = count(t, r.right);
			if (r.data.equals(t)) {
			return leftTree + rightTree + 1;
		}
			else {
				return leftTree + rightTree;
			}
				
			}
	}

	public String get(String location)
	
	{
		if (location.equalsIgnoreCase("")) {
			return root.data;
		}
		else {
		Node ptr = root; 
		
		
		for (int i=0; i < location.length(); i++)
		{
			char direction = location.charAt(i);
			if (direction == 'L')
				ptr = ptr.left; // move left
			else
				ptr = ptr.right;
		}
		return ptr.data;
		
	}
	}
	public int level(String loco) {// taken from first leaves method, but checks if its a leaf
			return loco.length();
		
	}
	public boolean leaves(String data){
		return leaves(root, data);
	}
	private boolean leaves (Node r, String data){
		List <String> list = new ArrayList <String> ();
		if (r == null) {
			return false;
		}
		else {
			if (r.right != null) {
				list.addAll(leaves(r.right));
			}
			if (r.left != null) {
				list.addAll(leaves(r.left));
			}
			if (r.right == null && r.left == null) {
				list.add(r.data);
				
			}
			if (list.contains(data)) {
				return true;
			}
			else {
				return false;
			}
			
	}
	}
	public void deleteRoot(String value)// deletes root for purpose of fixing errors within my code
	{
	
		if (root.data.equals(value) && root.left == null) 
		{
			root = root.right;
			return;
		}
		if (root.data.equals(value) && root.right == null)
		{
			root = root.left;
			return;
		}
		
	}
	public List<String> leaves(){
		return leaves(root);
	}
	private List<String> leaves (Node r){
		List <String> list = new ArrayList <String> ();
		if (r == null) {
			return new ArrayList<String>();
		}
		else {
			if (r.right != null) {
				list.addAll(leaves(r.right));
			}
			if (r.left != null) {
				list.addAll(leaves(r.left));
			}
			if (r.right == null && r.left == null) {
				list.add(r.data);
				
			}
			return list;
	}
	}
	/*
	public int sum() {
		return sum(root);
	}
	private int sum(Node r) {
		
		if (r == null) {
			return 0;
		}
		else {
			int Rtree = sum(r.right);
			int Ltree = sum(r.left);
			int total = Rtree + Ltree + r.data;
			return total;
		}
	}
	*/
	
	public String toFile() {// This method is key to making this program run
		return toFile(root, "");
	}
	private String toFile(Node r, String ptr) {//whenevr it goes to a new node it prints the data and its directions to the file
		if (r == null) {
			return "";
		}
		else {
			String toit = "";
			toit += ("" + r.data + ", "+ ptr + "\n");
			toit += toFile(r.left, ptr + "L");// if it moves left, it prints the nodes data and loco
			toit += toFile (r.right, ptr + "R"); // if it moves right, it prints the nodes data and loco
			
			return toit;
		}
		
	}
	
	public String toString() {
		return toString(root);
	}
	private String toString(Node r) {
		if (r == null) {
			return "";
		}
		else {
			String ans = "";
			ans += toString(r.left);
			ans += ("" + r.data + " ");
			ans += toString(r.right);
			return ans;
		}
		
	}
	}





