class Solution {
    private static boolean isFinished(Map<Character, Integer> map, Set<Character> chars) {
        boolean isDone = true;
        for(Character c : chars) {
            if(map.get(c) != 0) {
                isDone = false;
                break;
            }
        }
        return isDone;
    }
    public boolean checkInclusion(String s1, String s2) {
        // Input: s1 = "abc", s2 = "lecabee"
        Set<Character> chars = new HashSet<>();
        Map<Character, Integer> count = new HashMap<>();
        for(Character c : s1.toCharArray()) {
            chars.add(c);
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        int left = 0;
        for(int right = 0; right < s2.length(); ++right) {
            char current = s2.charAt(right);
            if(chars.contains(current)) {
                if(count.get(current) > 0) {  
                    count.put(current, count.get(current)-1);
                    if(isFinished(count, chars))
                        return true;
                }
                else { 
                    while(current != s2.charAt(left)) {
                        if(chars.contains(current))
                            count.put(current, count.get(current)+1);
                        ++left;
                    }
                }
            }
            else {
                while(left < right) {
                    if(chars.contains(s2.charAt(left))) 
                        count.put(s2.charAt(left), count.get(s2.charAt(left))+1);
                    ++left;
                }
            }
        }
        return false;
    }
}
