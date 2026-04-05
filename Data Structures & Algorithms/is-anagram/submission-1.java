class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            count[s.charAt(i)-97]++;
            count[t.charAt(i)-97]--;
        }
        for(int i = 0; i < 26; ++i) {
            if(count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
