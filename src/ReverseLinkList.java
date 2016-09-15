
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

public class ReverseLinkList {
	static class ListNode {
		String val;
		ListNode next;

		ListNode(String x) {
			val = x;
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String values[] = line.split(" ");
		ListNode tmp = null, start = null;
		for (String v : values) {
			ListNode node = new ListNode(v);
			if (tmp != null)
				tmp.next = node;
			else
				start = node;
			tmp = node;
		}
		ListNode res = new ReverseLinkList().reverseList(start);
		while (res != null) {
			System.out.println(" " + res.val);
			res = res.next;
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;

		ListNode prev = head, curr = head.next, nxt;
		while (curr != null) {
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		head.next = null;
		return prev;
	}
}
