class Solution {
    // O(n) - O(n) - is alright but need to improve less vars
    // public boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     int open = 0;
    //     Set<Character> opening = new HashSet<>(Arrays.asList('(', '{', '['));
    //     Set<Character> closing = new HashSet<>(Arrays.asList(')', '}', ']'));
    //     for(Character c : s.toCharArray()) {
    //         if(!opening.contains(c) && !closing.contains(c))
    //             return false;
    //         if(closing.contains(c)) {
    //             if(stack.isEmpty() || open <= 0)
    //                 return false;
    //             if(
    //                 (stack.peek() == '(' && c != ')') || 
    //                 (stack.peek() == '[' && c != ']') ||
    //                 (stack.peek() == '{' && c != '}')
    //             ) {
    //                 return false;
    //             }
    //             stack.pop();
    //             --open;
    //         }
    //         if(opening.contains(c)) {
    //             open++;
    //             stack.push(c);
    //         }
    //     }
    //     return (open == 0);
    // }

    // Same as above just cleaner and less vars
    public boolean isValid(String s) {
        Map<Character, Character> keys = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );
        Deque<Character> stack = new ArrayDeque<>();
        for(Character c : s.toCharArray()) {
            if(keys.containsKey(c)) {
                if(stack.isEmpty() || keys.get(c) != stack.pop())
                    return false;
            }
            else if(keys.containsValue(c)) {
                stack.push(c);
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
