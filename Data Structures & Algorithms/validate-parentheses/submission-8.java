class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpenMap = Map.of(
            '}', '{',
            ')', '(',
            ']', '['
        );
        Set<Character> openers = Set.of('{', '(', '[');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            char current = s.charAt(i);
            if(closeToOpenMap.containsKey(current)) {
                if(stack.isEmpty()) {
                    return false;
                }
                char last = stack.peek();
                System.out.println("last: "+last+" current: " + current);
                if(last != closeToOpenMap.get(current)) {
                    return false;
                }
                stack.pop();
            }
            else if(openers.contains(current)) {
                stack.push(current);
            }
            else {
                 return false;
            }
        }
        return stack.size() == 0;

        // (([]{}))
    }
}
