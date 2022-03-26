/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
package DataStructure.LinkedList;

import java.util.List;

public class _0206_反转链表 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode next = head.next;
        head.next = null;

        ListNode newHead = reverseList1(next);
        next.next = head;


        return newHead;

    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        _0206_反转链表 obj = new _0206_反转链表();

        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

//        ListNode newHead = obj.reverseList(node1);
//
//        while (newHead != null) {
//            System.out.println(newHead.val);
//            newHead = newHead.next;
//        }

        ListNode newHead1 = obj.reverseList1(node1);
        while (newHead1 != null) {

            System.out.println(newHead1.val);
            newHead1 = newHead1.next;
        }
    }

}


