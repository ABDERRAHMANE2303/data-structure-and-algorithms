class MinStack {

    List<Integer> stack = new ArrayList<>() , min_stack = new ArrayList<>();

    public MinStack() {
    }
    
    public void push(int val) {
        stack.add(val);
        if (min_stack.size() == 0) min_stack.add(val);
        else min_stack.add(Math.min(min_stack.get(min_stack.size()-1),val));
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
        min_stack.remove(min_stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return min_stack.get(min_stack.size()-1);
    }
}
