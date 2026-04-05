class Solution {
    private char CHAR_RLE_COUNT = '#';
    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();
        // 123#hithere
        for(String str : strs) {
            strBuilder.append(str.length()).append('#').append(str);
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        int currentIndex = 0;
        List<String> decoded = new ArrayList<>();
        while(currentIndex < str.length()) {
            int endNumber = str.indexOf(CHAR_RLE_COUNT, currentIndex);
            int sizeNext = Integer.parseInt(str.substring(currentIndex, endNumber));
            decoded.add(str.substring(endNumber+1, endNumber+sizeNext+1));
            currentIndex = endNumber+sizeNext+1;
        }
        return decoded;
    }
}
