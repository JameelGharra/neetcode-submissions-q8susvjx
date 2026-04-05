class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;

        int[] sChars = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            ++sChars[s.charAt(i)-'a'];
            --sChars[t.charAt(i)-'a'];
        }
        for(int i = 0; i < 26; ++i) {
            if(sChars[i] != 0)
                return false;
        }
        return true;
    }
}
