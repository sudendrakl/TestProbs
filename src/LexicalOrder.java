
/*
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/
import java.util.*;
import java.io.*;

public class LexicalOrder {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n");
		String line = br.readLine();

		int m = Integer.parseInt(line);
		TreeSet<String> treeset = new LexicalOrder().testLexicalOrder(m);
		System.out.println("testLexicalOrder()--->" + treeset);
		List<Integer> list = new LexicalOrder().lexicalOrder(m);
		System.out.println("testLexical()--->" + list);
		// System.out.println("The hell " + list);
	}

	private TreeSet<String> testLexicalOrder(int m) {
		TreeSet<String> treeset = new TreeSet<>();
		for (int i = 1; i <= m; i++) {
			treeset.add(Integer.toString(i));
		}
		return treeset;
	}

	int number;

	public List<Integer> lexicalOrder(int n) {
		number = n;
		List<Integer> list = new ArrayList<Integer>(n);
		if (n == 0)
			return list;
		list.add(1);
		if (n == 1)
			return list;
		add(list, 1);
		return list;
	}

	private List<Integer> add(List<Integer> list, int m) {
		//System.out.println("add("+m+")");
		if (m * 10 <= number) { //first add all multiples of 10
			list.add(m * 10);
			add(list, m * 10); //recursive with current x10
		}
		if (m + 1 <= number && (m + 1) % 10 != 0) { //add increment and not x10
			list.add(m + 1);
			add(list, m + 1);
		}
		return list;
	}
}