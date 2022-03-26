package DataStructure.LinkedList;

import java.util.PriorityQueue;

public class _0023_合并K个升序链表 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     /** 逐一比较法 */
    public ListNode mergeKLists(ListNode[] lists) {
         if (lists == null || lists.length == 0) return null;
         ListNode virtualHead = new ListNode(0);
         ListNode cur = virtualHead;

         while (true) {
             int minIndex = -1;
             for (int i = 0; i < lists.length; i++) {
                 if (lists[i] == null) continue;

                 if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
                     minIndex = i;
                 }
             }

             if (minIndex == -1) break;

             cur.next = lists[minIndex];
             cur = cur.next;
             lists[minIndex] = lists[minIndex].next;
         }
         return virtualHead.next;
    }

    /** 小顶堆 */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode virtualHead = new ListNode(0);
        ListNode cur = virtualHead;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode node1, ListNode node2) -> node1.val - node2.val);
        for (ListNode node : lists) {
            if (node == null) continue;
            minHeap.offer(node);
        }

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.remove();
            cur.next = minNode;
            cur = cur.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return virtualHead.next;
    }

    /** 分治 */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int step = 1;
        while (step < lists.length) {
            int nextStep = step << 1;
            for (int i = 0; i + step < lists.length; i += nextStep) {
                mergeTwoLists(lists[i], lists[i + step]);
            }
            step = nextStep;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

}
