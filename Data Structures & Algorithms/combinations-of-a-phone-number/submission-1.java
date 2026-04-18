class Solution {
    // iteratively
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] letters = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
        };
        List<String> res = new ArrayList<>();
        res.add("");
        for (char c : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (char letter : letters[c - '0'].toCharArray()) {
                for (String combo : res) {
                    tmp.add(combo + letter);
                }
            }
            res = tmp;
        }
        return res;
    }
}
