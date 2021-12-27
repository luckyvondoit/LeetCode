//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
package DataStructure.LinkedList;

public class _0083_Remove_Duplicates_from_Sorted_List {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode deleteDuplicates(ListNode head) {
         if (head == null) return null;

         ListNode cur = head;

         while (cur.next != null) {
             if (cur.val == cur.next.val) {
                 cur.next = cur.next.next;
             } else  {
                 cur = cur.next;
             }
         }
         return head;
    }
}
