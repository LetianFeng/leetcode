/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(head.val);
        ListNode node = head.next;
        while (node != null) {
            ListNode newNode = new ListNode(node.val);
            newNode.next = newHead;
            newHead = newNode;
            node = node.next;
        }

        return newHead;
    }
}