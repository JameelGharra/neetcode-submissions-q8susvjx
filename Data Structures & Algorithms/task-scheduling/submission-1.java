class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        int maxF = Arrays.stream(count).max().getAsInt();
        int maxCount = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] == maxF) {
                maxCount++;
            }
        }
        int time = (maxF - 1) * (n + 1) + maxCount;
        // edge case
        // 'a' 'a' 'b' 'c' 'd' => 3 + 1 = 4 so we have to take task.length here
        return Math.max(tasks.length, time);
    }
}
