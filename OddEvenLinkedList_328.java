package hw4;
import listAndTree.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * Space O(1); Time O(n);
 * 
 * eg:
 * Given a->b->c->d->e->null;
 * Return a->c->e->b->d->null;
 * @author D2Victoria
 *
 */

public class OddEvenLinkedList_328 {
	
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		
		int size = 0;
		ListNode tail = null;
		ListNode crrt = head, start = head;
		while (crrt != null) {
			size++;
			if (crrt.next == null) {
				tail = crrt;
			}
			crrt = crrt.next;
		}
		
		for (int i = 1; i <= size / 2; i++) {
			tail.next = head.next;
			head.next = head.next.next;
			tail.next.next = null;
			
			// update head and tail
			head = head.next;
			tail= tail.next;
		}
		return start;
	}

}
