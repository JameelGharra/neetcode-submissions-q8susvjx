class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; ++i) {
            while(!stack.isEmpty() && stack.peek()[0] < arr[i]) {
                int[] pair = stack.pop();
                res[pair[1]] = i-pair[1];
            }
            stack.push(new int[]{arr[i], i});
        }
        return res;
    }
}
