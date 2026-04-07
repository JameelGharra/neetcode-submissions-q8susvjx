class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int number : nums) {
            pq.offer(number);
            if (pq.size() > k)
                pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k)
            pq.poll();
        return pq.peek();
    }
}
