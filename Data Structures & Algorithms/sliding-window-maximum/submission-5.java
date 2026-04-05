class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        int[] res = new int[nums.length-k+1];
        for(int i = 0; i < nums.length-k+1; ++i) {
            if(i == 0) { // first k elements has to be added
                int j = i;
                while(j-i < k) {
                    maxHeap.add(new int[]{nums[j], j});
                    ++j;
                }
            }
            else { // adding only the last element for the windows after first one
                maxHeap.add(new int[]{nums[i+k-1], i+k-1});
            }
            boolean found = false;
            while(!found) {
                int[] elem = maxHeap.peek();
                if(elem[1] >= i) {
                    found = true;
                    res[i] = elem[0];
                }
                if(elem[1] <= i) {
                    maxHeap.poll();
                }
            }
            found = false;
        }
        return res;
    }
}
