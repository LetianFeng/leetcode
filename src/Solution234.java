/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        // find the middle node in the list

        // [1,2,4,3,4,2,1]
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // even -> 3
        // odd -> 3, actually we need 4

        // if odd nodes, move middle forward for 1 position
        if (fast != null)
            slow = slow.next;

        ListNode secondHead = null;
        // reverse the second half
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = secondHead;
            secondHead = slow;
            slow = next;
        }

        fast = head;
        slow = secondHead;
        while (slow != null) {
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }




        return true;
    }
}