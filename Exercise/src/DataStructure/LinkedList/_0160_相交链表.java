package DataStructure.LinkedList;

/**
 * 思路：headA和headB的长度不同，在headA后面拼接headB，在headB后面拼接headA。此时，两个链表的长度相同
 */
public class _0160_相交链表 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if (headA == null || headB == null) return null;
         ListNode curA = headA;
         ListNode curB = headB;

         // 如果有公共子链表，curA == curB 且 都不为空，如果不存在，curA和curB都为空
         while (curA != curB) {
             curA = curA == null ? headB : curA.next;
             curB = curB == null ? headA : curB.next;

             // 以下写法会造成死循环
             // curA = curA.next == null ? curB : curA.next;
             // curB = curB.next == null ? curA : curB.next;
         }
         return curA;
    }

}
