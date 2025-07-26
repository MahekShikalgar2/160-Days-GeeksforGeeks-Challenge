class Solution {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
        
    }
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
        
    }

    public void pop() {
        if(!stack.isEmpty()){
            int top = stack.pop();
            if(top == minStack.peek()){
                minStack.pop();
            }
        }
    }
        
    public int peek() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
       if(minStack.isEmpty()){
           return -1;
       }
       return minStack.peek();
    }
}