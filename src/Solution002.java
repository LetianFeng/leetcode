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
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode sentinel = new ListNode(0);
        int carry = 0;

        ListNode node = sentinel;
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                carry += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                carry += n2.val;
                n2 = n2.next;
            }

            node.next = new ListNode(carry % 10);
            node = node.next;
            carry /= 10;
        }

        if (carry > 0)
            node.next = new ListNode(carry);

        return sentinel.next;
    }
}