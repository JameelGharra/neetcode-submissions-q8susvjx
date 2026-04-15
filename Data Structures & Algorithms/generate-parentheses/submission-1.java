class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), res);
        return res;
    }
    private void backtrack(int openNotUsed, int closeNotUsed, StringBuilder sb, List<String> res) {
        if (openNotUsed == 0 && closeNotUsed == 0) {
            res.add(sb.toString());
            return ;
        }
        if (openNotUsed < closeNotUsed) {
            sb.append(")");
            backtrack(openNotUsed, closeNotUsed - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (openNotUsed > 0) {
            sb.append("(");
            backtrack(openNotUsed - 1, closeNotUsed, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
