class MinStack {
    Stack<Long> distances;
    long dist;
    public MinStack() {
        distances = new Stack<>();
    }
    
    public void push(int val) {
        if(distances.isEmpty()) {
            dist = val;
        }
        distances.push(val-dist);
        if(val-dist < 0)
            dist = val;
    }
    
    public void pop() {
        long popped = distances.pop();
        if(!distances.isEmpty() && popped < 0) {
            dist = dist-popped;
        }
    }
    
    public int top() {
        if(distances.peek() < 0) {
            return (int)dist;
        }
        else {
            return (int)(distances.peek()+dist);
        }
    }
    
    public int getMin() {
        return (int)dist;
    }
}
