import java.util.ArrayList;
import java.util.Stack;

//��������ṹ,��������ⲿ�ִ���ŵ���Offer05����ͻᱨ������ǰ�ListNode�ŵ���Offer05�����Ҫ��class ListNode{...}ǰ�����static
class ListNode{
	ListNode next;
	int val;
}

public class Offer05 {
		
		
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<>();
		if(listNode == null)
			return list;
		Stack<ListNode> stack = new Stack<>();
		while(listNode != null){
			stack.push(listNode);
			listNode = listNode.next;
		}
		
		while(!stack.isEmpty()){
			list.add(stack.pop().val);
		}
		return list;
	}
	public static void main(String[] args) {
		Offer05 of5 = new Offer05();
		//��������
		//1�����ܲ��ԣ�����������ж���ڵ㣬���������ֻ��һ���ڵ㣩
		ListNode node1 = new ListNode();
		ListNode node2 = new ListNode();
		ListNode node3 = new ListNode();
		node1.val = 1;
		node2.val = 2;
		node3.val = 3;
		node1.next = node2;
		node2.next = node3;
		System.out.println(of5.printListFromTailToHead(node1));
		
		ListNode node4 = new ListNode();
		node4.val = 4;
		System.out.println(of5.printListFromTailToHead(node4));
		
		//2,����������ԣ����������ͷ�ڵ�ָ��Ϊnull��
		ListNode node5 = null;
		System.out.println(of5.printListFromTailToHead(node5));
	}
}
	

