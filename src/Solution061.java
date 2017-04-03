/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 0)
            return null;

        if (k == 0)
            return head;

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        if (k % length == 0)
            return head;
        else if (k > length)
            k = k % length;


        node = head;
        for (int i = 0; i < length - k - 1; i++)
            node = node.next;

        ListNode newEnd = node;
        while (node.next != null)
            node = node.next;

        node.next = head;
        head = newEnd.next;
        newEnd.next = null;

        return head;
    }

    public static void main(String[] args) {
        Solution061 sol = new Solution061();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = sol.rotateRight(head, 2);
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}