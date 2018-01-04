import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	static ArrayList<String> list = new ArrayList<>();
	static Stack<String> stackOfWords = new Stack<>(); 
	JFrame frame;
	JPanel panel;
	
	public static void main(String[] args) throws IOException {
		Hangman hangman = new Hangman();
		hangman.saveWordsToArrayList();
		
	}
	
	public void saveWordsToArrayList() throws IOException {
		String n = JOptionPane.showInputDialog("Enter a number in the space below.");
		int number = Integer.parseInt(n);
		String listOfWords = "";
		int r = 0;
		
		try {
			for (int i = 0; i < number; i++) {
				Random random = new Random();
				r = random.nextInt(3000);
				BufferedReader words = new BufferedReader(new FileReader("src/dictionary.txt"));
				String w = words.readLine();
				String output = "";
				while (w != null) {
					w = words.readLine();
					list.add(w);
				}
				listOfWords = list.get(r);
				System.out.println(listOfWords);
				
			}
			
		stackOfWords.push(listOfWords);
		
;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Hangman() {
		frame = new JFrame();
		panel = new JPanel();
	}
	
}
