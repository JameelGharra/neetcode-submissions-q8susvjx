class Solution {

    public String encode(List<String> strs) {
        // 3#abc#.....1337#kqer..qere
        StringBuilder result = new StringBuilder();
        for(String word : strs) { // O(N) * O(S) where S maximum length of string
            result.append(word.length()).append("#").append(word);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            StringBuilder numberStr = new StringBuilder();
            while(str.charAt(index) != '#') {
                numberStr.append(str.charAt(index));
                ++index;
            }
            int number = Integer.parseInt(numberStr.toString());
            result.add(str.substring(index+1, index+1+number));
            index = index+1+number;
        }
        return result;
    }
}
