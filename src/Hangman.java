import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Hangman {
	static ArrayList list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		String n = JOptionPane.showInputDialog("Enter a number in the space below.");
		int number = Integer.parseInt(n);
		try {
			for (int i = 0; i < number; i++) {
				BufferedReader words = new BufferedReader(new FileReader("src/dictionary.txt"));
				String w = words.readLine();
				String output = "";
				while (w != null) {
					w = words.readLine();
					list.add(w);
				}
			}

			System.out.println(list);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
