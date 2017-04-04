import java.util.HashMap;

public class Solution146 {

    int capacity;
    int count;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public Solution146(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node result = map.get(key);

        if (this.head == result) {
            return result.value;
        } else if (this.tail == result) {
            result.pre.next = null;
            this.tail = result.pre;
        } else {
            result.pre.next = result.next;
            result.next.pre = result.pre;
        }

        result.pre = null;
        result.next = this.head;
        this.head.pre = result;
        this.head = result;

        return result.value;
    }

    public void put(int key, int value) {
        if (this.capacity <= 0)
            return;

        Node node = new Node(key, value);

        if (count == 0) {
            this.head = node;
            this.tail = node;
            this.count++;
        } else if (this.count < this.capacity) {
            if (!this.map.containsKey(key)) {
                node.next = this.head;
                this.head.pre = node;
                this.head = node;
                count++;
            } else {
                this.get(key);
                this.head.value = value;
                node = this.head;
            }
        } else {
            if (!this.map.containsKey(key)) {
                this.map.remove(this.tail.key);

                if (count > 1) {
                    this.tail = this.tail.pre;
                    this.tail.next = null;

                    node.next = this.head;
                    this.head.pre = node;
                    this.head = node;
                } else {
                    this.head = node;
                    this.tail = node;
                }
            } else {
                this.get(key);
                this.head.value = value;
                node = this.head;
            }
        }


        this.map.put(key, node);
    }

    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Solution146 sol = new Solution146(1);
        sol.put(2,1);
        sol.get(2);
        sol.put(3,2);
        sol.get(2);
        sol.get(3);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */