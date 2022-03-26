package DataStructure.LinkedList;

public class _0876_链表的中间结点 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public ListNode middleNode(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }
}
