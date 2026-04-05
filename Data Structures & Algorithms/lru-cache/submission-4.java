
// same just cleaner version
class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private Node dummyLeft, dummyRight;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyLeft = new Node(-1, -1);
        dummyRight = new Node(-1, -1);
        dummyLeft.next = dummyRight;
        dummyRight.prev = dummyLeft;
        cache = new HashMap<>();    
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            insert(node);
            return ;
        }
        if (cache.size() == capacity) {
            cache.remove(dummyLeft.next.key);
            remove(dummyLeft.next);
        }
        node = new Node(key, value);
        cache.put(key, node);
        insert(node);
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(Node node) {
        dummyRight.prev.next = node;
        node.prev = dummyRight.prev;
        dummyRight.prev = node;
        node.next = dummyRight;
    }
}
