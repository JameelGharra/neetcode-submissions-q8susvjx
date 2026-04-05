class Solution {
    // O(N log K) time and O(N) space
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> freq = new HashMap<>();
    //     for(int number : nums) {
    //         freq.put(number, freq.getOrDefault(number, 0)+1);
    //     }
    //     Queue<Map.Entry<Integer, Integer>> priority = new PriorityQueue<>(
    //         (a, b) -> a.getValue()-b.getValue()
    //     );
    //     for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
    //         priority.add(entry);
    //         if(priority.size() > k)
    //             priority.poll();
    //     }
    //     int[] result = new int[k];
    //     for(int i = 0; i < k; ++i) {
    //         result[i] = priority.poll().getKey();
    //     }
    //     return result;
    // }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int number : nums) {
            freq.put(number, freq.getOrDefault(number, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freq.entrySet());
        freqList.sort((a, b) -> b.getValue()-a.getValue());
        int[] result = new int[k];
        for(int i = 0; i < k; ++i)
            result[i] = freqList.get(i).getKey();
        return result;
    }
}
