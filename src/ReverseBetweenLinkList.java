
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
import java.io.*;

public class ReverseBetweenLinkList {
	static class ListNode {
		String val;
		ListNode next;

		ListNode(String x) {
			val = x;
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter start(m) and end(n)...separated by space");
		String line = br.readLine();
		String mANDn[] = line.split(" ");
		int m = Integer.parseInt(mANDn[0]), n = Integer.parseInt(mANDn[1]);
		System.out.println("Enter linklist");
		line = br.readLine();
		String values[] = line.split(" ");
		if (n > values.length)
			System.out.println("The hell");

		ListNode tmp = null, start = null;
		for (String v : values) {
			ListNode node = new ListNode(v);
			if (tmp != null)
				tmp.next = node;
			else
				start = node;
			tmp = node;
		}
		ListNode res = new ReverseBetweenLinkList().reverseBetween(start, m - 1, n - 1);
		System.out.println("Result---->");
		while (res != null) {
			System.out.print(" " + res.val);
			res = res.next;
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		System.out.println();
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null)
			return null;
		int index = 0;
		ListNode prev = head, curr = head.next, tmp, start = null, end;
		// System.out.println("Traverse...");
		for (index = 0; index < m; index++) {
			// System.out.print(" "+ prev.val);
			start = prev;
			prev = prev.next;
		}

		end = prev;

		// System.out.println("\nstart=" + (start!=null?start.val:null) + "
		// end="+ (end!=null?end.val:null));
		if (end == null) {
			return head;
		}

		// System.out.println("Looping over ("+m+","+n+")" + " index = " +
		// index);
		curr = prev;
		while (index <= n) {
			// System.out.println("in loop" + " index:" + index + " curr:" +
			// (curr!=null?curr.val:curr));
			// if(curr!=null)
			tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
			index++;
		}
		System.out.println("After while loop\nstart=" + (start != null ? start.val : null) + " head="
				+ (head != null ? head.val : null) + " end=" + (end != null ? end.val : null) + " prev="
				+ (prev != null ? prev.val : null) + " curr=" + (curr != null ? curr.val : null));

		if (start != null)
			start.next = prev;
		end.next = curr;

		if (m == 0)
			return prev;

		return head;
	}
}
