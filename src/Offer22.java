import java.util.ArrayList;
import java.util.Stack;

public class Offer22 {

	//��������ķ���
	public boolean IsPopOrder(ArrayList<Integer> pushA, ArrayList<Integer> popA){
		if(pushA == null || popA == null)
			return false;
		if(pushA.size() != popA.size())
			return false;
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for(int i = 0;i<pushA.size();i++){
			stack.push(pushA.get(i));
			while(!stack.empty() && stack.peek() == popA.get(j)){
				stack.pop();
				j++;
			}
		}
		if(stack.empty())
			return true;
		else
			return false;
	}
	
	//��������
	public boolean IsPopOrder_2(int [] pushA, int [] popA){
		if(pushA == null || popA == null)
			return false;
		if(pushA.length == 0 || popA.length == 0)
			return false;
		if(pushA.length != popA.length)
			return false;
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for(int i = 0;i<pushA.length;i++){
			stack.push(pushA[i]);
			while(!stack.empty() && stack.peek() == popA[j]){
				stack.pop();
				j++;
			}
		}
		if(stack.empty())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		Offer22 of22 = new Offer22();
		
		//���ܲ��ԣ�1,������������麬�ж�����֣��ڶ��������ǵ�һ�������ʾ��ѹ�����ж�Ӧ��ջ�ĵ�������
		ArrayList<Integer> push1A = new ArrayList<>();
		push1A.add(1);
		push1A.add(2);
		push1A.add(3);
		push1A.add(4);
		push1A.add(5);
		ArrayList<Integer> pop1A = new ArrayList<>();
		pop1A.add(4);
		pop1A.add(5);
		pop1A.add(3);
		pop1A.add(2);
		pop1A.add(1);
		
		//System.out.println(of22.IsPopOrder(push1A, pop1A));
		
		int [] push_1A = {1,2,3,4,5};
		int [] pop_1A = {4,5,3,2,1};
		
		System.out.println(of22.IsPopOrder_2(push_1A, pop_1A));
		
		//���ܲ��ԣ�2,������������麬�ж�����֣��ڶ������鲻�ǵ�һ�������ʾ��ѹ�����ж�Ӧ��ջ�ĵ�������
		ArrayList<Integer> push2A = new ArrayList<>();
		push2A.add(1);
		push2A.add(2);
		push2A.add(3);
		push2A.add(4);
		push2A.add(5);
		ArrayList<Integer> pop2A = new ArrayList<>();
		pop2A.add(4);
		pop2A.add(3);
		pop2A.add(5);
		pop2A.add(1);
		pop2A.add(2);
		
		//System.out.println(of22.IsPopOrder(push2A, pop2A));
		
		int [] push_2A = {1,2,3,4,5};
		int [] pop_2A = {4,3,5,1,2};
		
		System.out.println(of22.IsPopOrder_2(push_2A, pop_2A));
		
		//���ܲ��ԣ�3,�������������ֻ��1�����֣��ڶ��������ǵ�һ�������ʾ��ѹ�����ж�Ӧ��ջ�ĵ�������
		ArrayList<Integer> push3A = new ArrayList<>();
		push3A.add(1);
		ArrayList<Integer> pop3A = new ArrayList<>();
		pop3A.add(1);
		
		//System.out.println(of22.IsPopOrder(push3A, pop3A));
		
		int [] push_3A = {1};
		int [] pop_3A = {1};
		
		System.out.println(of22.IsPopOrder_2(push_3A, pop_3A));
		
		//���ܲ��ԣ�4,�������������ֻ��1�����֣��ڶ��������ǵ�һ�������ʾ��ѹ�����ж�Ӧ��ջ�ĵ�������
		ArrayList<Integer> push4A = new ArrayList<>();
		push4A.add(1);
		ArrayList<Integer> pop4A = new ArrayList<>();
		pop4A.add(2);
				
		//System.out.println(of22.IsPopOrder(push4A, pop4A));
		
		int [] push_4A = {1};
		int [] pop_4A = {2};
		
		System.out.println(of22.IsPopOrder_2(push_4A, pop_4A));
		
		//���������ԣ�5,��������NULLָ��
		ArrayList<Integer> push5A = null;
		ArrayList<Integer> pop5A = null;
		
		//System.out.println(of22.IsPopOrder(push5A, pop5A));
		
		int [] push_5A = null;
		int [] pop_5A = null;
		
		System.out.println(of22.IsPopOrder_2(push_5A, pop_5A));

	}

}
