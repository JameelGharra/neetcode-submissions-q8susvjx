class Solution {
    // O(N log N) time and O(N) space
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> freq = new HashMap<>();
    //     for(int number : nums) {
    //         freq.put(number, freq.getOrDefault(number, 0)+1);
    //     }
    //     List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freq.entrySet());
    //     freqList.sort((a, b) -> b.getValue()-a.getValue());
    //     int[] result = new int[k];
    //     for(int i = 0; i < k; ++i)
    //         result[i] = freqList.get(i).getKey();
    //     return result;
    // }

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


    // 
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();
        for(int i = 0; i <= nums.length; ++i) {
            freq.add(new ArrayList<>());
        }
        for(int number : nums) {
            count.put(number, count.getOrDefault(number, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }
        int index = 0;
        int[] result = new int[k];
        for(int i = nums.length; i > 0; --i) {
            for(int number : freq.get(i)) {
                result[index++] = number;
                if(index == k)
                    return result;
            }
        }
        return result;
    }
    
}
