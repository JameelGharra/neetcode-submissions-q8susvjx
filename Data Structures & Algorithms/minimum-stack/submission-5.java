class MinStack {
    Stack<Integer> contents;
    Stack<Integer> minimum;
    public MinStack() {
        contents = new Stack<>();
        minimum = new Stack<>();
    }
    
    public void push(int val) {
        contents.push(val);
        int minimumVal = val;
        if(!minimum.isEmpty() && minimumVal > minimum.peek()) {
            minimumVal = minimum.peek();
        }
        minimum.push(minimumVal);
    }
    
    public void pop() {
        minimum.pop();
        contents.pop();
    }
    
    public int top() {
        return contents.peek();
    }
    
    public int getMin() {
        return minimum.peek();
    }
}
