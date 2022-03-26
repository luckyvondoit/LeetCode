/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
package DataStructure.LinkedList;

public class _0083_删除排序链表中的重复元素 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return newHead;
    }
}
