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
        if (l1 == null || l2 == null)
            return null;

        int sum = l1.val + l2.val;
        ListNode head = new ListNode(sum % 10);
        ListNode tail = head;

        ListNode n1 = l1.next, n2 = l2.next;

        while (n1 != null || n2 != null) {
            sum /= 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }

        if (sum > 9)
            tail.next = new ListNode(1);

        return head;
    }
}