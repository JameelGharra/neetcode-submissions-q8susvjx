class Solution {
    // heap approach: O(K log n = n log n) time & O(n) space 
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Integer number : nums) {
            countMap.put(number, countMap.getOrDefault(number, 0)+1);
        }
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        while(k > 0) {
            result[k-1] = minHeap.poll()[0];
            --k;
        }
        return result;
    }
}
