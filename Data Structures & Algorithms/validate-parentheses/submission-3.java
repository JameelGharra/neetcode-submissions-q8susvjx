class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0;
        Set<Character> opening = new HashSet<>(Arrays.asList('(', '{', '['));
        Set<Character> closing = new HashSet<>(Arrays.asList(')', '}', ']'));
        for(Character c : s.toCharArray()) {
            if(!opening.contains(c) && !closing.contains(c))
                return false;
            if(closing.contains(c)) {
                if(stack.isEmpty() || open <= 0)
                    return false;
                if(
                    (stack.peek() == '(' && c != ')') || 
                    (stack.peek() == '[' && c != ']') ||
                    (stack.peek() == '{' && c != '}')
                ) {
                    return false;
                }
                stack.pop();
                --open;
            }
            if(opening.contains(c)) {
                open++;
                stack.push(c);
            }
        }
        return (open == 0);
    }
}
