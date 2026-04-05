class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> arithmetics = Set.of("+", "-", "/", "*");
        for(String token : tokens) {
            if(!arithmetics.contains(token)) {
                stack.push(Integer.parseInt(token));
            }
            else {
                int res;
                int right = stack.pop(), left = stack.pop();
                switch(token) {
                case "+":
                    res = left+right;
                    break;
                case "-":
                    res = left-right;
                    break;
                case "*":
                    res = left*right;
                    break;
                default:
                    res = left/right;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
