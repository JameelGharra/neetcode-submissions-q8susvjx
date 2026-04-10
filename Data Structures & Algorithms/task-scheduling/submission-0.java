class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                pq.offer(count[i]);
            }
        }
        // time the count
        int time = 0;
        Queue<int[]> cooldownQueue = new ArrayDeque<>();
        while (!pq.isEmpty() || !cooldownQueue.isEmpty()) {
            ++time;
            if (!pq.isEmpty()) {
                int freq = pq.poll() - 1;
                if (freq > 0) {
                    cooldownQueue.offer(new int[]{time + n, freq});
                }
            }
            else {
                time = cooldownQueue.peek()[0];
            }
            if (!cooldownQueue.isEmpty()) {
                if (cooldownQueue.peek()[0] == time) {
                    int freq = cooldownQueue.poll()[1];
                    pq.offer(freq);

                }
            }
        }
        return time;
    }
}
