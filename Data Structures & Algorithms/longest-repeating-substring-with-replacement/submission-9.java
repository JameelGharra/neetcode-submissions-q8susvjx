class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, res = 0, countMostFreq = 0;
        for(int i = 0; i < s.length(); ++i) {
            Character current = s.charAt(i);
            count.put(current, count.getOrDefault(current, 0)+1);
            int countCurrent = count.get(current);
            countMostFreq = Math.max(countCurrent, countMostFreq);
            while(k < i - left + 1 - countMostFreq) {
                char c = s.charAt(left);
                count.put(c, count.get(c)-1);
                ++left;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}
