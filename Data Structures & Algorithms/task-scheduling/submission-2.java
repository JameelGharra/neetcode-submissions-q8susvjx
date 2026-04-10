class Solution {
    // greedy
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int maxFreq = count[25];
        int idleSlots = n * (maxFreq - 1);
        for (int i = 24; i >= 0 && count[i] > 0; --i) {
            idleSlots -= Math.min(maxFreq - 1, count[i]);
        }
        return tasks.length + Math.max(0, idleSlots);
    }
}
