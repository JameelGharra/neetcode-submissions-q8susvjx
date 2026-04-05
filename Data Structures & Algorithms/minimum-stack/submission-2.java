class MinStack {
    private Deque<Integer> mainStack;
    private Deque<Integer> getMinStack;

    public MinStack() {
        mainStack = new ArrayDeque<>();
        getMinStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(!getMinStack.isEmpty()) {
            int currentMin = getMinStack.peek();
            if(val <= currentMin)
                getMinStack.push(val);
        }
        else {
            getMinStack.push(val);
        }
    }
    
    public void pop() {
        if(mainStack.pop().equals(getMinStack.peek()))
            getMinStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return getMinStack.peek();
    }
}
