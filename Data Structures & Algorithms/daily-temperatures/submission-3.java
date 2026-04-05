class Solution {
    // Monotonic stack: O(n) - O(n)
    // public int[] dailyTemperatures(int[] temperatures) {
    //     // [36, 30, 31, 39]
    //     Deque<int[]> stack = new ArrayDeque<>();
    //     int[] result = new int[temperatures.length];
    //     for(int i = 0; i < temperatures.length; ++i) {
    //         if(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
    //             while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
    //                 int[] pair = stack.pop();
    //                 result[pair[0]] = i-pair[0];
    //             }
    //         }
    //         stack.push(new int[]{i, temperatures[i]});
    //     }
    //     return result;
    // }

    // DP: O(n) - O(n) but extra space only for the result
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1)
            return new int[1];

        int[] result = new int[temperatures.length];
        for(int i = temperatures.length-2; i >= 0; --i) {
            int j = i+1;
            while(j < temperatures.length && temperatures[j] <= temperatures[i]) {
                if(result[j] != 0) {
                    j += result[j];
                }
                else {
                    j = temperatures.length;
                    break;
                }
            }
            if(j != temperatures.length)
                result[i] = j-i; 
        }
        return result;
    }
}
