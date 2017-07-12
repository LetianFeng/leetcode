/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 !=null) {
                tail.val += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                tail.val += l1.val;
                l1 = l1.next;
            } else {
                tail.val += l2.val;
                l2 = l2.next;
            }
            if (tail.val / 10 > 0) {
                tail.next = new ListNode(1);
                tail.val = tail.val % 10;
            } else if (l1 != null || l2 != null) {
                tail.next = new ListNode(0);
            }
            tail = tail.next;

        }

        return head;
    }
}