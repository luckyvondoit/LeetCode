package DataStructure.LinkedList;

public class _0021_合并两个有序链表 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
         if (list1 == null) return list2;
         if (list2 == null) return list1;

         ListNode virtualNode = new ListNode(0);
         ListNode curNode = virtualNode;

         while (list1 != null && list2 != null) {
             if (list1.val <= list2.val) {
                 curNode.next = list1;
                 list1 = list1.next;
             } else {
                 curNode.next = list2;
                 list2 = list2.next;
             }
             curNode = curNode.next;
         }

         if (list1 != null) {
             curNode.next = list1;
         }

         if (list2 != null) {
             curNode.next = list2;
         }

         return virtualNode.next;
     }

     /** 递归调用 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
