class Solution {
    private void generate(int n, int open, List<String> result, StringBuilder build) {
        if(n == 0){
            if(open == 0) 
                result.add(build.toString());
            return ;
        }
        build.append("(");
        generate(n-1, open+1, result, build);
        build.deleteCharAt(build.length()-1);
        if(open-1 >= 0) {
            build.append(")");
            generate(n-1, open-1, result, build);
            build.deleteCharAt(build.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(2*n, 0, result, new StringBuilder());
        return result;
    }
}
