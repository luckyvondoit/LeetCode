package DataStructure.LinkedList;

public class _0002_两数相加 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         if (l1 == null) return l2;
         if (l2 == null) return l1;

        ListNode virtualNode = new ListNode(0);
        ListNode currentNode = virtualNode;

        int carry = 0; // 进位
         while (l1 != null || l2 != null) {
             int v1 = 0;
             if (l1 != null) {
                 v1 = l1.val;
                 l1 = l1.next;
             }

             int v2 = 0;
             if (l2 != null) {
                 v2 = l2.val;
                 l2 = l2.next;
             }

             int sum = v1 + v2 + carry;

             currentNode.next = new ListNode(sum % 10);
             currentNode = currentNode.next;
             carry = sum / 10;
         }

         if (carry > 0) {
             currentNode.next = new ListNode(carry);
         }
         return virtualNode.next;
    }
}
