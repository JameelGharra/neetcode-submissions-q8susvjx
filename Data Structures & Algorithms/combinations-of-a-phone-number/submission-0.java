class Solution {
    private List<String> res;
    Map<Character, char[]> combos = Map.of(
        '2', new char[]{'a', 'b', 'c'},
        '3', new char[]{'d', 'e', 'f'},
        '4', new char[]{'g', 'h', 'i'},
        '5', new char[]{'j', 'k', 'l'},
        '6', new char[]{'m', 'n', 'o'},
        '7', new char[]{'p', 'q', 'r', 's'},
        '8', new char[]{'t', 'u', 'v'},
        '9', new char[]{'w', 'x', 'y', 'z'}
    );
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int digitIdx, StringBuilder sb) {
        if (digitIdx == digits.length()) {
            res.add(sb.toString());
            return ;
        }
        for (char c : combos.get(digits.charAt(digitIdx))) {
            sb.append(c);
            backtrack(digits, digitIdx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
