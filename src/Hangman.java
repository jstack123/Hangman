import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	static ArrayList<String> list = new ArrayList<>();
	static Stack<String> stackOfWords = new Stack<>();
	JFrame frame;
	JPanel panel;
	JLabel guess;
	JLabel blankLines;
	JLabel lives;
	JLabel wordsSolved;
	String blankUnderscores = "";
	String word = "";
	int numberOfLives = 9;

	public static void main(String[] args) throws IOException {
		Hangman hangman = new Hangman();
		hangman.saveWordsToArrayList();
		hangman.EndingGame();
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

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stackOfWords.push(listOfWords);

		frame.add(panel);
		panel.add(guess);
		panel.add(blankLines);
		panel.add(lives);
		panel.add(wordsSolved);

		frame.setSize(500, 200);
		frame.setVisible(true);

		word = stackOfWords.pop();

		for (int i = 0; i < word.length(); i++) {
			blankUnderscores += "_";
		}

		guess.setText("Guess a letter");
		blankLines.setText(blankUnderscores);
		lives.setText("You have " + numberOfLives + " lives left.");
		wordsSolved.setText("You have solved 0 words.");

		frame.addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		String newBlanks = "";
		// TODO Auto-generated method stub
		System.out.println(word);
		for (int i = 0; i < word.length(); i++) {
			char entered = e.getKeyChar();
			char current = word.charAt(i);
			if (entered==current) {
				newBlanks += entered;
				
			} else {
				System.out.println(blankUnderscores.charAt(i));
				newBlanks+=blankUnderscores.charAt(i);
			}		
		}
		blankUnderscores = newBlanks;
		blankLines.setText(blankUnderscores);
		System.out.println(blankUnderscores);
		if (word.contains("" + e.getKeyChar())) {
			System.out.println("yes");
			
		} else {
			System.out.println("no");
			numberOfLives-=1;
			lives.setText("" + numberOfLives);
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void EndingGame() {
		/*if (numberOfLives==0) {
			
		}
		
		if (!blankUnderscores.contains("_")) {
			JOptionPane.showMessageDialog(null, "WORD SOLVED");
			stackOfWords.pop();
		}*/
	}

	public Hangman() {
		frame = new JFrame();
		panel = new JPanel();
		guess = new JLabel();
		blankLines = new JLabel();
		lives = new JLabel();
		wordsSolved = new JLabel();
	}

}
