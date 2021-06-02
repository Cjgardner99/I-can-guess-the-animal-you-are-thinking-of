package GardP2;
import java.util.Scanner;


import java.util.Arrays;
import java.io.*;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
public class BT2Driver {
	
	// NOte that here when i call bt.levaes i am calling a boolean method i created that checks if the pointer is on a leaf
	public static BinaryTree playG(Scanner in, BinaryTree bt, String d, PrintWriter o) {//This Method runs through the game, adding stuff to the tree (String d are the directions
		System.out.println(bt.get(d));// prompts the question at the appropriate Node within the tree
		String ans = in.nextLine();//keeps track of users yes or no responses
		String ans2 = "";//this variable is used for what animal the user was thinking of if the game guessed the animal wrong
		String q = "";//this variable is used to to store the users distinguishing question
		if (ans.equalsIgnoreCase("yes") && bt.leaves(bt.get(d))==true) {//this conditional takes care of performing the appropriate action 
			//when the users response is yes and they are at the point where the game tries to guess what there animal is the game is over 
			System.out.println("I win");
			bt.deleteRoot("Is it a cat??");//this was used to remove duplicates of cat. and to fix a problem with my code that was finikey
			return bt;
		}
		else {
			
			if (ans.equalsIgnoreCase("no") && bt.leaves(bt.get(d)) == true) {
			// if the user enters no, and the game is on the part where it guesses your animal then
			// it prompts what it was and a question of distinguishing the two animals
			System.out.println("Dang it! what was it? ");
			ans2 = in.nextLine();
			System.out.println("Enter a question where the answer is yes for the question: "+ "("+"is it a(n) "+ ans2+"?"+ ")"+" and no for the question: " +"("+ bt.get(d)+"?)");
			q = in.nextLine();
			bt.replace(q, d, "is it a " + ans2);// This method i also creates in the
			//binary tree class to basically replace what is in the parent root with the new user
			//given question and shift was was in the parent node to the left of the tree and put 
			//their animal they were thinking of to the right of the tree.
			
			
			}
			else {
				if (ans.equalsIgnoreCase("no") && bt.leaves(bt.get(d)) == false) { 
				//this conditional checks if they entered no to a question and its not at the point where its guessing your animal
				// Then it moves recalls the method but changing where it is at in the tree. in this conditional
				// its the left becauase whenever a user enters no 
				// it moves to the left
				if (d.equals("")) {
				playG(in, bt, "L",o);
				}
				else {
					playG(in,bt, d + "L",o);	
				}
				}
				if (ans.equalsIgnoreCase("yes") && bt.leaves(bt.get(d)) == false) {
				// this conditional does the same as the previous one but moves to the right
					if (d.equals("")) {
						playG(in,bt, "R",o);
						}
						else {
							playG(in,bt, d + "R",o);
						}
				}
		}
			bt.deleteRoot("Is it a cat??");
			return bt;
	}
	}
	
	public static BinaryTree createTree (BinaryTree binT, Scanner txt, List <String> line) {
		// This method creates the tree from the text filel
		while (txt.hasNextLine()) {
	        line.add(txt.nextLine());// moves text from file to a list
		}
		List <List<String>> it = new ArrayList <List<String>> ();
		for (int i = 0; i < line.size(); i++) {// Creates a CSV but as an arraylist so the thing
			//going in the tree is first in the list and the directions are the next thing in the list
			it.add(new ArrayList<String>(Arrays.asList(line.get(i).split(","))));	
		}
		
		for (int i = 0; i < it.size(); i++) {//removes any empty ArrayLists within the ArrayList
			if (it.get(i).get(0).isEmpty()) {
				it.remove(i);
			}
		}
		
		
		
		
		for (int i = 0; i < it.size(); i++) {// adds to binary tree
			if (!it.get(i).get(0).isEmpty()) {
			binT.add(it.get(i).get(0), it.get(i).get(1));
			}
		}
		
		return binT;
			
	}

	public static void main(String[] args) throws IOException  {
		List <String> lines = new ArrayList<String> ();
		File temp = new File("file/answers.txt");
		Scanner textFile = new Scanner(temp);// pulls textile info
		
		
		
		Scanner in = new Scanner (System.in);
		BinaryTree bt = new BinaryTree();
		createTree (bt, textFile,lines);
		
		
		
		
	
		
		
		while (true) {
		Scanner exit = new Scanner (System.in);// used to check if user wants to keep playing
		String conf = "";//
		PrintWriter output = new PrintWriter(new FileWriter("file/answers.txt", true));// sets up obj to write to file
		if (lines.get(0).isEmpty()) {// this is were things get complicated
		// here i have it so if there nothing in the file it will run without reading from a file
		output.println(playG(in, bt,"", output).toFile());// here i have it print the Binary tree to the file using a toFile method i created in the BinaryTree class
		System.out.println("Would you Like to play agiain? ");
		conf = exit.nextLine();
		if (conf.equalsIgnoreCase("no")) {
			System.out.println("User has quit");
			output.close();
			break;
		}
		else {
			continue;
		}
		}
		else {// this is ran if there is somthing in the fiile
			output.println(playG(in, bt,"R", output).toFile());
			output.close();
			break;
			
		}
		
		
		
		
		
		

}
		Scanner in3 = new Scanner (System.in);// checks if they want to play agiain 
		String conf = "";
		System.out.println("Would you like to play again? ");
		conf = in3.nextLine();
		if (conf.equalsIgnoreCase("yes")) {
			main(args);
		}
		else {
			System.out.println("User has quit");
		}


}
}