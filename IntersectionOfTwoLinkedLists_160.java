package hw4;
import listAndTree.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @author D2Victoria
 *
 */


public class IntersectionOfTwoLinkedLists_160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		int sizeA = this.getSize(headA);
		int sizeB = this.getSize(headB);
		
		int delta = Math.abs(sizeA - sizeB);
		ListNode longer = sizeA >= sizeB ? headA : headB;
		ListNode shorter = sizeA >= sizeB ? headB : headA;
		while (delta > 0) {
			longer = longer.next;
			delta--;
		}
		
		while (longer != null && shorter != null) {
			if (longer.equals(shorter)) {
				return longer;
			}
			longer = longer.next;
			shorter = shorter.next;
		}
		
		return null;
	}
	
	private int getSize(ListNode head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
 		return size;
	}
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        	return null;
        }
        
        ListNode tailA = null;
		ListNode crrt = headA;
		while (crrt.next != null) {
			crrt = crrt.next;
		}
		tailA = crrt;
		
		ListNode tailB = null;
	    crrt = headB;
		while (crrt.next != null) {
			crrt = crrt.next;
		}
		tailB = crrt;
		
		if (tailA.equals(tailB)) {
			return tailA;
		}
		// construct cycle
		if (!tailA.equals(headA) && !tailB.equals(headB)) {
			tailB.next = headA;
			crrt = headB; // crrt: slow pointer
		} else {
			return null;
		}
		
		ListNode fast = headB.next;
		while (!fast.equals(crrt)) {
			fast = fast.next.next;
			crrt = crrt.next;
			if (fast == null || fast.next == null) {
				return null;
			}
		}
		
		crrt = headB;
		while(crrt != fast.next) {
			crrt = crrt.next;
			fast = fast.next;
		}
		tailB.next = null;
		return crrt;
    }
	
	public static void main(String[] args) {
		// 1 -> 3
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		a.next = b;
		
		// 0 -> 2 -> 4 -> 6 -> 8
		ListNode c = new ListNode(0);
		ListNode crrt = c;
		for (int i = 1; i <= 4; i++) {
			ListNode add = new ListNode(2 * i);
			crrt.next = add;
			crrt = crrt.next;
		}
		
		IntersectionOfTwoLinkedLists_160 test = new IntersectionOfTwoLinkedLists_160();
		ListNode result = test.getIntersectionNode(a, c);
		if ( result == null) {
			System.out.println("pass!");
		} else {
			System.out.println("" + result);
		}
		
		
	}

}
