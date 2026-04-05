class LRUCache {
    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    private Node dummyLeft; // least used
    private Node dummyRight; // most recent
    private Map<Integer, Node> cache;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        dummyLeft = new Node(-1, -1); // key would not matter since not in map
        dummyRight = new Node(-1, -1);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            makeRecent(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // [x, x'] -> [y, y']
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            makeRecent(node);
            return ;
        }
        node = new Node(key, value);
        cache.put(key, node);
        if (size == capacity) {
            cache.remove(dummyLeft.next.key);
            dummyLeft.next.next.prev = dummyLeft;
            dummyLeft.next = dummyLeft.next.next;
            --size;
        }
        ++size;
        makeRecent(node);
    }

    private void makeRecent(Node node) {
        if (dummyRight.prev == node)
            return ;
        if (size == 1) {
            dummyLeft.next = node;
            dummyRight.prev = node;
            node.prev = dummyLeft;
            node.next = dummyRight;
            return ;
        }
        // [Left] [x, x'] -> [y, y'] [Right]
        if (node.prev != null) { // basically a new node
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        // update right side
        dummyRight.prev.next = node;
        node.next = dummyRight;
        node.prev = dummyRight.prev;
        dummyRight.prev = node;
    }
}
