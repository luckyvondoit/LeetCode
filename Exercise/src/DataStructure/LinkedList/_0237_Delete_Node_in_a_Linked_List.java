//https://leetcode.com/problems/delete-node-in-a-linked-list/
package DataStructure.LinkedList;

public class _0237_Delete_Node_in_a_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
