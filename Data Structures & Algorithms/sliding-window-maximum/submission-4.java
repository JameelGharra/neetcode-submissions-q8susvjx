class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        int[] res = new int[nums.length-k+1];
        for(int i = 0; i < nums.length-k+1; ++i) {
            int j = i;
            while(j-i+1 <= k) {
                maxHeap.add(new int[]{nums[j], j});
                ++j;
            }
            boolean found = false;
            while(!found) {
                int[] elem = maxHeap.poll();
                if(elem[1] >= i) {
                    found = true;
                    res[i] = elem[0];
                }
            }
            found = false;
        }
        return res;
    }
}
