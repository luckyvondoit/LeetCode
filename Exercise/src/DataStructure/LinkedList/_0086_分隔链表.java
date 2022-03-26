package DataStructure.LinkedList;

public class _0086_分隔链表 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode partition(ListNode head, int x) {
         if (head == null) return null;
         ListNode lHead = new ListNode(0);
         ListNode lTail = lHead;

         ListNode rHead = new ListNode(0);
         ListNode rTail = rHead;

         while (head != null) {
             if (head.val < x) {
                 lTail.next = head;
                 lTail = lTail.next;
             } else {
                 rTail.next = head;
                 rTail = rTail.next;
             }
             head = head.next;
         }
         // 此代码必须，rtail后面的节点全部小于x，无法将rTail.next置为null。
         rTail.next = null;

         lTail.next = rHead.next;

         return lHead.next;
    }
}
