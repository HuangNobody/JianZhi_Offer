import java.util.Stack;

public class Offer07 {
	
	private static Stack<Object> stack1 = new Stack<>();
	private static Stack<Object> stack2 = new Stack<>();
	
	//��������е�Ԫ��ֻ���뵽ջ1��
	public static void appendTail(Object item){
		stack1.push(item);
		System.out.println("ѹ��ջԪ�أ�" + item);
	}
	
	/*
	 * ɾ��һ��Ԫ��ʱ�����ջ 2�Ƿ�Ϊ�գ�ջ2��Ϊ���򵯳�ջ2ջ��Ԫ�أ�ջ2Ϊ�գ����ջ1�е�Ԫ��ȫ��������ѹ�뵽ջ2�У�
	 * Ȼ���ջ2ջ������Ԫ��
	 */
	public static void deleteHead(){
		if(!stack2.isEmpty())
			System.out.println("����ջԪ��:" +stack2.pop());
		else{
			if(stack1.isEmpty())
				throw new RuntimeException("����Ϊ��");
			while(!stack1.isEmpty()){
				Object item = stack1.pop();
				stack2.push(item);
			}
			deleteHead();//��֮ǰstack2Ϊ�գ�������վ�󲻿��ˣ��������ɾ��ջ��Ԫ��
		}
	}
	
	public static void main(String[] args) {
		//��������
		//Offer07 o7 = new Offer07();
		//o7.appendTail(1);
		//1�����յĶ�����ɾ��Ԫ��
		//deleteHead();
		//1�����յĶ��������Ԫ��
		appendTail(1);
		
		//2,���ǿյĶ��������Ԫ��
		appendTail(2);
		appendTail(3);
		//2,���ǿյĶ�����ɾ��Ԫ��
		deleteHead();
		
		//3������ɾ��Ԫ��ֱ������Ϊ��
		deleteHead();
		deleteHead();
	}
}
