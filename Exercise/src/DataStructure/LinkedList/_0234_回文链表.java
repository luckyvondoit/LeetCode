package DataStructure.LinkedList;

import java.awt.*;

public class _0234_回文链表 {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
             return val + "->" + next;
         }
     }

    public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null) return true;
         if (head.next.next == null) return head.val == head.next.val;

         // 将右半部分翻转，左右向中间进行比较

         ListNode rhead = reverseList(middleNode(head).next);
         ListNode rOldHead = rhead;
         ListNode lhead = head;

         boolean result = true;
         while (rhead != null) {
             if (lhead.val != rhead.val) {
                 result = false;
                 break;
             };
             lhead = lhead.next;
             rhead = rhead.next;
         }
         // 恢复右半部分
        reverseList(rOldHead);
        return result;
    }

    // 1,2,3,4,5 返回3
    // 1,2,3,4 返回2
    private ListNode middleNode(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
         while (fast.next != null && fast.next.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }

    private ListNode reverseList(ListNode head) {
         ListNode prev = null;
         while (head != null) {
             ListNode tmp = head.next;
             head.next = prev;
             prev = head;
             head = tmp;
         }
         return prev;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(node1);

        _0234_回文链表 obj = new _0234_回文链表();
        obj.isPalindrome(node1);

        System.out.println(node1);


    }
}
