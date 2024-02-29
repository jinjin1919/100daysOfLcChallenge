package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
	
	
	Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>(); 
    }
    
    public void push(int val) {
        
        if(!stack.isEmpty() && stack.peek()[1] < val) {
            stack.push(new int[] {val, stack.peek()[1]}); 
        }else {
            stack.push(new int[] {val, val}); 
        }
    }
    
    public void pop() {
        stack.pop(); 
    }
    
    public int top() {
        return stack.peek()[0]; 
    }
    
    public int getMin() {
        return stack.peek()[1]; 
    }

	public static void main(String[] args) {
		
		MinStack obj = new MinStack(); 
		obj.push(-2); 
		obj.push(0);
		obj.push(-3); 
		
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());

	}

}
