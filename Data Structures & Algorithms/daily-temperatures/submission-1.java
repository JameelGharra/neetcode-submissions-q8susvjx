class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // [36, 30, 31, 39]
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; ++i) {
            if(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                    int[] pair = stack.pop();
                    result[pair[0]] = i-pair[0];
                }
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        return result;
    }
}
