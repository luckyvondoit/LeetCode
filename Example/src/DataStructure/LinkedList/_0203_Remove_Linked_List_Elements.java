package DataStructure.LinkedList;

public class _0203_Remove_Linked_List_Elements {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeElements1(ListNode head, int val) {
         if (head == null) return null;

         ListNode cur = head;
         ListNode newHead = head;
         ListNode prev = null;

         boolean changeHead = head.val == val;

         while (cur != null) {
             if (changeHead) {
                 newHead = newHead.next;
                 cur = newHead;
                 if (cur != null) {
                     changeHead = cur.val == val;
                 }
             } else {
                 if (cur.val == val) {
                     prev.next = cur.next;
                     cur = cur.next;
                 } else {
                     prev = cur;
                     cur = cur.next;
                 }
             }
         }
         return newHead;
    }

    public ListNode removeElements2(ListNode head, int val) {
         if (head == null) return null;
         ListNode dummyHead = new ListNode(0);
         dummyHead.next = head;
         ListNode prev = dummyHead;
         while (prev.next != null) {
             if (prev.next.val == val) {
                 prev.next = prev.next.next;
             } else  {
                 prev = prev.next;
             }
         }
         return dummyHead.next;
    }
}
