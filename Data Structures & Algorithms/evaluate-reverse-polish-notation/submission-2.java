class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> arithmetics = Set.of("+", "-", "/", "*");
        for(int i = 0; i < tokens.length; ++i) {
            String st = tokens[i];
            if(!arithmetics.contains(st)) {
                stack.push(Integer.parseInt(st));
            }
            else {
                int res;
                int number2 = stack.pop(), number1 = stack.pop();
                if(st.equals("+"))
                    res = number1+number2;
                else if(st.equals("-"))
                    res = number1-number2;
                else if(st.equals("*"))
                    res = number1*number2;
                else
                    res = number1/number2;
                
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
