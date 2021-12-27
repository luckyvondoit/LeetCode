package DataStructure.LinkedList;

public class _0876_Middle_of_the_Linked_List {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode middleNode(ListNode head) {
         if (head == null) return null;
         int len = 1;
         ListNode cur = head;
         while (cur.next != null) {
             cur = cur.next;
             len += 1;
         }

         ListNode mid = head;
         int idx = len / 2;
         for (int i = 0; i < idx; i++) {
             mid = mid.next;
         }
         return mid;
    }

}
