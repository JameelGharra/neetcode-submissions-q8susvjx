// stack
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1)
            return 1;
        List<int[]> data = new ArrayList<>(); // (position, speed)
        int n = position.length;
        for(int i = 0; i < n; ++i) {
            data.add(new int[]{position[i], speed[i]});
        }
        Collections.sort(data, (a, b) -> b[0]-a[0]);
        Stack<Double> times = new Stack<>();
        int answer = 0;
        for(int[] pair : data) {
            // t = (target-pos)/v
            double curTime = ((double)target-pair[0])/pair[1];
            times.push(curTime);
            if(times.size() >= 2) {
                if(curTime <= times.get(times.size()-2)) {
                    times.pop();
                }
            }
        }
        return times.size();
    }
}
