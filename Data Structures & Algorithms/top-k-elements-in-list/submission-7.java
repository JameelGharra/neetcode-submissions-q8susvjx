class Solution {
    // heap approach: O(K log n = n log n) time & O(n) space 
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> countMap = new HashMap<>();
    //     for(Integer number : nums) {
    //         countMap.put(number, countMap.getOrDefault(number, 0)+1);
    //     }
    //     Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1]-b[1]);
    //     for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
    //         minHeap.add(new int[]{entry.getKey(), entry.getValue()});
    //         if(minHeap.size() > k) {
    //             minHeap.poll();
    //         }
    //     }
    //     int[] result = new int[k];
    //     while(k > 0) {
    //         result[k-1] = minHeap.poll()[0];
    //         --k;
    //     }
    //     return result;
    // }
    public int[] topKFrequent(int[] nums, int k) {
        // k buckets at most since k = O(N)
        // for each bucket there is some list of values it get updated
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Integer number : nums) {
            countMap.put(number, countMap.getOrDefault(number, 0)+1);
        }
        // the higher the index => the higher the freq
        List<List<Integer>> freq = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            freq.add(new ArrayList<>());
        }
        for(Integer number : countMap.keySet()) {
            Integer count = countMap.get(number);
            freq.get(count-1).add(number);
        }
        int[] result = new int[k];
        int count = 0;
        for(int i = freq.size()-1; i >= 0; --i) {
            for(int number : freq.get(i)) {
                result[count++] = number;
                if(count == k)
                    return result;
            }
        }
        // this was trash to do two whiles lol
        // int count = 0, currentListIdx = nums.length-1;
        // while(count < k) {
        //     List<Integer> currentList = freq.get(currentListIdx);
        //     System.out.println("doing this for " + currentListIdx);
        //     int lastIndex = currentList.size()-1;
        //     System.out.println("lastIndex: " + lastIndex);
        //     while(lastIndex >= 0 && count < k) {
        //         System.out.println("count = " + count);
        //         result[count++] = currentList.get(lastIndex--);
        //     }
        //     currentListIdx--;
        // }
        // return result;
        return null;
    }
}

