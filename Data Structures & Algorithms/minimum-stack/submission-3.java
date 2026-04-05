// class MinStack {
//     private Deque<Integer> mainStack;
//     private Deque<Integer> getMinStack;

//     public MinStack() {
//         mainStack = new ArrayDeque<>();
//         getMinStack = new ArrayDeque<>();
//     }
    
//     public void push(int val) {
//         mainStack.push(val);
//         if(!getMinStack.isEmpty()) {
//             int currentMin = getMinStack.peek();
//             if(val <= currentMin)
//                 getMinStack.push(val);
//         }
//         else {
//             getMinStack.push(val);
//         }
//     }
    
//     public void pop() {
//         if(mainStack.pop().equals(getMinStack.peek()))
//             getMinStack.pop();
//     }
    
//     public int top() {
//         return mainStack.peek();
//     }
    
//     public int getMin() {
//         return getMinStack.peek();
//     }
// }


class MinStack {
    private Deque<Node> stack;

    private static class Node {
        int minSoFar;
        int value;
        Node(int value, int min) {
            minSoFar = min;
            this.value = value;
        }
    }

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new Node(val, val));
        else
            stack.push(new Node(val, Math.min(val, stack.peek().minSoFar)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().minSoFar;
    }
}

