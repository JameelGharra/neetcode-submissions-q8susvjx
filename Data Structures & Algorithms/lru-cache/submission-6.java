
// Literally cheating
class LRUCache {
    private final Map<Integer, Integer> cache;
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(this.capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return LRUCache.this.capacity < cache.size();
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
