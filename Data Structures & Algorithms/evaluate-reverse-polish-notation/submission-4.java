class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        Set<String> operators = Set.of("+", "-", "/", "*");
        for(String token : tokens) {
            if(operators.contains(token)) {
                int y = operands.pop();
                int x = operands.pop();
                int operResult = 0;
                switch(token) {
                    case "+": operResult = x+y; break;
                    case "-": operResult = x-y; break;
                    case "*": operResult = x*y; break;
                    case "/": operResult = x/y; break;
                }
                operands.push(operResult);
            }
            else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }
}
