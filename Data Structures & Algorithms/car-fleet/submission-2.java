class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[][] pairs = new int[position.length][2];
        for(int i = 0; i < pairs.length; ++i) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> b[0]-a[0]);
        stack.push(pairs[0]);
        for(int i = 1; i < pairs.length; ++i) {
            int[] pair = pairs[i];
            int[] peeked = stack.peek();
            double calculatedPeeked = (double)(target-peeked[0])/peeked[1];
            double calculatedCurrent = (double)(target-pair[0])/pair[1];
            if(calculatedCurrent > calculatedPeeked)
                stack.push(pair);
            
        }
        return stack.size();
    }
}
