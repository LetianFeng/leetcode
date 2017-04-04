import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));

            node = node.next;
        }

        node = head;
        while (node != null) {
            RandomListNode newNode = map.get(node);
            newNode.next = map.get(node.next);
            newNode.random = map.get(node.random);

            node = node.next;
        }

        return map.get(head);
    }
}