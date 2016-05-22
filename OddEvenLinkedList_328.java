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
    
    // 老师
    //【注意】开连个Pointer然后分别将已有的点挪到两个pointer之后,这个也是in place的！！
    // 并没有把每个Node都重新declare了用了O(n)额外空间
    public ListNode oddEvenList_Teacher(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode[] tails = new ListNode[] {oddHead, evenHead};
        //		ListNode oddTail = oddHead;
        //	    ListNode evenTail = evenHead;
        
        int index = 0;
        while (head != null) {
            tails[index].next = head;
            tails[index] = tails[index].next;
            //			if (index == 0) {
            //	            oddTail = head;
            //	            oddTail = oddTail.next;
            //	        } else {
            //	            evenTail = head;
            //	            evenTail = evenTail.next;
            //	        }
            head = head.next;
            index = (index + 1) % 2;
        }
        
        tails[0].next = evenHead.next;
        tails[1].next = null;
        
        return oddHead.next;
    }
    
}
