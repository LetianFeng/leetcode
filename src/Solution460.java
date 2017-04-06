import java.util.HashMap;

public class Solution460 {

    int capacity;
    int count;
    HashMap<Integer, DNode> map;

    DNode tail;

    public Solution460(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        DNode node = map.get(key);
        node.used++;
        updatePosition(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity < 1)
            return;

        if (tail == null) {
            tail = new DNode(key, value);
            map.put(key, tail);
            count++;
            updatePosition(tail);
        } else {

            if (map.containsKey(key)) {
                DNode node = map.get(key);
                node.value = value;
                node.used++;
                updatePosition(node);
            } else {
                if (count < capacity) {
                    DNode node = new DNode(key, value);

                    tail.next = node;
                    node.pre = tail;
                    tail = node;

                    map.put(key, tail);
                    count++;
                    updatePosition(node);
                } else {
                    map.remove(tail.key);

                    tail.key = key;
                    tail.value = value;
                    tail.used = 0;

                    map.put(key, tail);
                    updatePosition(tail);
                }

            }
        }

    }

    private void updatePosition(DNode node) {
        DNode pre = node.pre;
        while (pre != null && node.used >= pre.used) {
            node.pre = pre.pre;
            pre.next = node.next;

            node.next = pre;
            pre.pre = node;

            if (node.pre != null)
                node.pre.next = node;
            if (pre.next != null)
                pre.next.pre = pre;
            if (tail == node)
                tail = pre;

            pre = node.pre;
        }
    }

    private class DNode {
        DNode pre;
        DNode next;
        int key;
        int value;
        int used;

        public DNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

