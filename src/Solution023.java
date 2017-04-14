import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        Comparator<ListNode> com = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val)
                    return -1;
                if (n1.val > n2.val)
                    return 1;
                return 0;
            }
        };

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, com);
        for (ListNode list : lists) {
            if (list != null)
                queue.add(list);
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }

        return dummy.next;
    }
}