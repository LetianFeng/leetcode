/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0, lenB = 0;

        while (nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        nodeA = headA;
        while (lenA > lenB) {
            nodeA = nodeA.next;
            lenA--;
        }
        nodeB = headB;
        while (lenA < lenB) {
            nodeB = nodeB.next;
            lenB--;
        }

        while(nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA;
    }
}