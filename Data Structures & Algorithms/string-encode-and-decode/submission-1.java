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
            int j = index;
            while(str.charAt(j) != '#') {
                ++j;
            }
            int number = Integer.parseInt(str.substring(index, j));
            index = j+1;
            j = j+1+number;
            result.add(str.substring(index, j));
            index = j;
        }
        return result;
    }
}
