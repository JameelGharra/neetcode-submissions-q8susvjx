class Solution {
    // minheap O(n log k) vs. maxheap: O(n log n)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int number : nums) {
            pq.offer(number);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
