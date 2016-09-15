
/*

Input string1: "this is a test string"
Input string2: "tist"
Output string: "t stri"
Find smallest substring of string1 that contains all the characters from string 2?

 */
import java.util.*;
import java.io.*;

public class ShortestSubString {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Find smallest substring of string1 that contains all the characters from string 2?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter source string 1");
		String str1 = br.readLine();
		System.out.println("Enter search string 2");
		String str2 = br.readLine();
		
		ShortestSubString shortestSubString = new ShortestSubString();
		System.out.println("Output --\n" + shortestSubString.compute(str1, str2));
		
	}

	public String compute(String input, String target) {
		int needToFind[] = new int[256];
		int hasFound[] = new int[256];
		int totalCharCount = 0;
		String result = null;

		char[] targetCharArray = target.toCharArray();
		for (int i = 0; i < targetCharArray.length; i++) {
			needToFind[targetCharArray[i]]++;
		}

		char[] inputCharArray = input.toCharArray();
		for (int begin = 0, end = 0; end < inputCharArray.length; end++) {

			if (needToFind[inputCharArray[end]] == 0) {
				continue;
			}

			hasFound[inputCharArray[end]]++;
			if (hasFound[inputCharArray[end]] <= needToFind[inputCharArray[end]]) {
				totalCharCount++;
			}
			if (totalCharCount == target.length()) {
				while (needToFind[inputCharArray[begin]] == 0
						|| hasFound[inputCharArray[begin]] > needToFind[inputCharArray[begin]]) {

					if (hasFound[inputCharArray[begin]] > needToFind[inputCharArray[begin]]) {
						hasFound[inputCharArray[begin]]--;
					}
					begin++;
				}

				String substring = input.substring(begin, end + 1);
				if (result == null || result.length() > substring.length()) {
					result = substring;
				}
			}
		}
		return result;
	}
}
