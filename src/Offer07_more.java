//��������ģ��һ��ջ
import java.util.LinkedList;
import java.util.Queue;

public class Offer07_more {
	
	private static Queue<Object> queue1= new LinkedList<>();
	private static Queue<Object> queue2= new LinkedList<>();
	
	//����ջ�е�Ԫ��ֻ���뵽����1��,���
	public static void push(Object item){
		queue1.add(item);
		System.out.println("ѹ�����Ԫ�أ�" + item);
	}
	
	public void pop(){ //���ӣ������пա������Ƿǿյ�ջ���ܳ�ջ��
		if(queue1.size() <=1){
			System.out.println("��������Ԫ�أ�"+queue1.poll());
		}else{
			while(queue1.size() > 1){
				queue2.add(queue1.poll());
			}
		}
		
		while(queue2.size() > 0){
			queue1.add(queue2.poll());
		}
		
		System.out.println("��������Ԫ�أ�"+queue1.poll());
	}
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		Offer07_more o7m = new Offer07_more();
		o7m.pop();
		o7m.pop();
		o7m.pop();
	}

}
