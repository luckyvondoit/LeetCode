/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
package DataStructure.LinkedList;

public class _0203_移除链表元素 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 链表删除元素的三种方式
     * 1、已知prev，prev.next = prev.next.next
     * 2、已知current，让current.val和 current.next.val交换，然后按照1的方式删除current.next
     * 3、递归删除，如下例removeElements
     */

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;

        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        // 如果末尾是要删除的，上面循环直接跳过，需要将末尾元素的next置为null
        newTail.next = null;
        return newHead.next;
    }


}