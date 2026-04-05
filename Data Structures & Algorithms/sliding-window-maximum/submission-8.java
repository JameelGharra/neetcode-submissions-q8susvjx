class Solution {
    // Deque approach O(n) - O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; ++i) {
            // Keep the first (left) to be maximum
            // while finding the "place" we remove old elements
            // keep removing from first if bigger or equals then insert
            // while(!deque.isEmpty() && (i > k-1 && deque.peekFirst() < i-k+1))
            //     deque.removeFirst();
            while(!deque.isEmpty() && 
                (
                    (nums[deque.getLast()] <= nums[i]) ||
                    (i > k-1 && deque.getLast() < i-k+1)
                )
            )
                deque.removeLast();
            deque.addLast(i);
            if(i > k-1 && deque.peekFirst() < i-k+1)
                deque.removeFirst();
            if(i >= k-1) {
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
