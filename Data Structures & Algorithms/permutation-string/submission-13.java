class Solution {
    // O(n*m) time - space O(m)
    // 
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> permMap = new HashMap<>();
        for(Character c : s1.toCharArray()) {
            permMap.put(c, permMap.getOrDefault(c, 0)+1);
        }
        Set<Character> chars = permMap.keySet();
        int left = 0, right = 0, permutationRequiredLen = s1.length();
        boolean startMatch = false;
        for(; right < s2.length(); ++right) {
            Character c = s2.charAt(right);
            Integer count = permMap.get(s2.charAt(right));
            if(!startMatch && chars.contains(c)) {
                left = right;
                startMatch = true;
            }
            if((count == null || count == 0) && startMatch) {
                while(left < right) {
                    Character cLeft = s2.charAt(left);
                    if(chars.contains(cLeft)) {
                        permMap.put(cLeft, permMap.get(cLeft)+1);
                    }
                    ++left;
                    if(cLeft == c)
                        break; // we start from there now
                }
                startMatch = chars.contains(c);
            }
            if(chars.contains(c)) {
                permMap.put(c, permMap.get(c)-1);
            }
            if(startMatch && permutationRequiredLen == right-left+1) {
                return true;
            }
        }
        return false;
    }
}
