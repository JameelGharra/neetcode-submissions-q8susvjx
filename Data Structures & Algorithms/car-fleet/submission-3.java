class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        int[][] pairs = new int[position.length][2];
        for(int i = 0; i < pairs.length; ++i) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> b[0]-a[0]);
        stack.push((double)(target-pairs[0][0])/pairs[0][1]);
        for(int i = 1; i < pairs.length; ++i) {
            int[] pair = pairs[i];
            double calculatedCurrent = (double)(target-pair[0])/pair[1];
            if(calculatedCurrent > stack.peek())
                stack.push(calculatedCurrent);
            
        }
        return stack.size();
    }
}
