class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> countCurrent = new HashMap<>();
        for(Character c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        int missed = count.keySet().size();
        // xabcyzrxy - xyz => xabcyz is bad - zrxy is good
        int left = 0, minLeft = 0, minRight = s.length()-1, right = 0;
        boolean found = false;
        while(right < s.length()) {
            Character c = s.charAt(right);
            countCurrent.put(c, countCurrent.getOrDefault(c, 0)+1);
            if(count.get(c) != null && countCurrent.get(c) == count.get(c)) {
                missed--;
            }
            while(missed == 0 && left <= right) {
                if(right-left <= minRight-minLeft) {
                    minLeft = left;
                    minRight = right;
                    found = true;
                }
                char cLeft = s.charAt(left);
                System.out.println("left: " + left+ " right: " + right + "cLeft: "+cLeft);
                countCurrent.put(cLeft, countCurrent.get(cLeft)-1);
                System.out.println("weird " + countCurrent.get(cLeft));
                if(count.get(cLeft) != null && countCurrent.get(cLeft) == count.get(cLeft)-1) {
                    missed++;
                }
                left++;
            }
            ++right;
        }
        if(!found)
            return "";
        return s.substring(minLeft, minRight+1);
    }
}
