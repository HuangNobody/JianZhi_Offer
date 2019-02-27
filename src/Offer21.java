import java.util.Stack;

public class Offer21 {

	public static Stack<Integer> mstack = new Stack<>();
	public static Stack<Integer> minstack = new Stack<>();
	
	public static void push(Integer value){
		mstack.push(value);
		
		if(minstack.size() == 0 || value <minstack.peek()){
			minstack.push(value);
		}else
			minstack.push(minstack.peek());
	}
	
	public static void pop(){
		if(!mstack.empty()&& !minstack.empty()){
			mstack.pop();
			minstack.pop();
		}
	}
	
	public static Integer min(){
		if(minstack.empty())
			return 0;
		return minstack.peek();
	}
	
	public static void main(String[] args) {
		push(3);
		System.out.println(min());
		push(4);
		System.out.println(min());
		push(2);
		System.out.println(min());
		push(1);
		System.out.println(min());
		pop();
		System.out.println(min());
		pop();
		System.out.println(min());
		push(0);
		System.out.println(min());
	}

}
