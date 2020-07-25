import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/*This java program takes a list of strings as input from the user 
 * and calls the method filterStrings() that returns a list consisting
 * of only palindrome. (Using Java 8 Lambdas and Streams API's) */

public class SubTask3Palindromes 
{
	public static List<String> filterStrings(List<String> inputList)
	{
		List<String> requiredList = new ArrayList<String>();
		for(int i = 0; i < inputList.size(); i++)
		{
			String tempString = (inputList.get(i)).replaceAll("\\s+", "").toLowerCase();
			 
			boolean check = IntStream.range(0, tempString.length() / 2)
	            .noneMatch(s -> tempString.charAt(s) != tempString.charAt(tempString.length() - s - 1));
			if (check)
				requiredList.add(inputList.get(i));
		}
		return requiredList;
	}
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in)) 
		{
			System.out.println("Enter the size of the list");
			int n = sc.nextInt();
			List<String> inputList = new ArrayList<String>(n);
			System.out.println("Enter the numbers to the list");
			for(int i = 0; i < n; i++)
				inputList.add(sc.next());
			System.out.println( " Palindromic Strings from the given list of strings are: " + filterStrings( inputList ) );
		}
    }

}