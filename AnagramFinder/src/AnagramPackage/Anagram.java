/** Java program that prints out to the user all the anagrams to his input word. */

package AnagramPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Anagram {
	
/*Helper Methods Implementation */	
	//StringSorter//
	public static String StringSorter(String str) {
		char sortArray[] = (str.toLowerCase()).toCharArray();
		Arrays.sort(sortArray);
		return new String(sortArray);
	}
	
	/** Anagram Finder 
	 * @params function takes in s1(the word) and HashMap<String K, String V> 
	 * where keys are 'alphabetically sorted of the value string',
	 * where values are words in the dictionary.
	 * @return string, return Value from the HashMap to the Key.  */
	public static String AnagramFinder(String s1, HashMap<String, String> dictionary)
	{
		String s1_sorted = StringSorter(s1); //s1_sorted in alphabetic order
		String result = dictionary.get(s1_sorted);	
		return result;
	}
		
/*Driver method */
	public static void main(String[] args) throws FileNotFoundException  {
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		long start = System.currentTimeMillis(); 
		
		//Read in file line by line and save lines in a String ArrayList. //
		File f = new File("C:\\Users\\uinur\\Desktop\\dictionary.txt"); // need to change the filepath to filename later
		Scanner s2 = new Scanner(f);
		
		ArrayList<String> dictionaryList = new ArrayList<String>();
		
		HashMap<String, String> map = new HashMap<>();
		while( s2.hasNextLine() )
		{
			dictionaryList.add(s2.nextLine());
		}
		//Traverse through dictionary List and write them into HashMap 
		//as key(word's alphabeticallyOrdered version) and as value(current word at i).
		String alphOrdered = null;
		for (int i = 0; i < dictionaryList.size(); i++ )
		{
			alphOrdered = StringSorter(dictionaryList.get(i));
			if(map.get(alphOrdered) != null) map.put(alphOrdered, map.get(alphOrdered) + ", " + dictionaryList.get(i));
			else map.put(alphOrdered, dictionaryList.get(i));		
		}
		
		
		/* Prompt to the user and save the user input as a string */
		System.out.println("Enter a word whose anagrams you want to find:");
		Scanner s = new Scanner(System.in);
		String userInput = s.nextLine();
	
		
		/*Call AnagramFinder method on the string saved from the user input. */
		String out = AnagramFinder(userInput, map);
		String count[] = out.split(",");
		
		long end = System.currentTimeMillis(); 
		long duration = end - start;
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if (out != null)
		{
			System.out.println(count.length + " anagrams found in " + duration + " ms." );
			System.out.println(out);
		}
		else System.out.println("No anagrams for " + userInput);
	
	}// end of main
	
}// end of class Anagram

