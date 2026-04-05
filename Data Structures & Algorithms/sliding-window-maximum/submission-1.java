class Solution {
    // O(n * k) - O(n-k+1)
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int[] result = new int[nums.length-k+1];
    //     int left = 0;
    //     for(int right = k-1; right <= nums.length-1; ++right) {
    //         int currentMax = nums[left];
    //         for(int i = left+1; i <= right; ++i)
    //             currentMax = Math.max(currentMax, nums[i]);
    //         result[left] = currentMax;
    //         ++left;
    //     }
    //     return result;
    // }

    // Deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; ++i) {
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1)
                dq.removeFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.removeLast();

            dq.addLast(i);
            if(i >= k-1)
                result[i-k+1] = nums[dq.peekFirst()];
        }
        return result;
    }

}
