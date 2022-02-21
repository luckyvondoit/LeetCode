package DataStructure.LinkedList;

import javax.security.auth.kerberos.KerberosTicket;

public class _0206_Reverse_Linked_List {
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
        return reverseList1(head);
    }

    private ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        ListNode newHead = reverseList1(next);
        next.next = head;
        head.next = null;

        return newHead;
    }

    private ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


}
