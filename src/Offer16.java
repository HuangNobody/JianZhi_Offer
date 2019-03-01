
public class Offer16 {

	public static class ListNode{
		int value;
		ListNode next = null;
		ListNode(int val){
			this.value = val;
		}
	}
	
	public ListNode reverseList(ListNode head){
		if(head == null)
			return null;
		if(head.next == null)//ֻ��һ���ڵ��ʱ��ͷ�����Ƿ�ת�ڵ��ͷ���
			return head;
		
		ListNode preNode = null;//��ʾ��ת�����ͷ���
		ListNode curNode = head;
		ListNode nextNode = null;
		
		while(curNode != null){
			nextNode = curNode.next;//nextNode�ڵ�ΪcurNode����һ���ڵ�
			if(nextNode == null)
				preNode = curNode;//�����һ���ڵ�Ϊnull�����ʾ��ǰ�ڵ�Ϊԭ�����ĩβ�ڵ�
			
			curNode.next = preNode;//��ʼ��ת���õ�ǰ�ڵ�ָ������֮ǰ�Ľڵ�
			preNode = curNode;//��֮ǰ�Ľڵ�ָ��ǰ�ڵ�
			curNode = nextNode;//��ǰ�ڵ�ָ����һ���ڵ㣺whileѭ����ĵ�һ�����������һ���ڵ����������һ��
		}
		return preNode;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		Offer16 of16 = new Offer16();
		//���ܲ��ԣ����������������ڵ�
		System.out.println(of16.reverseList(node1).value);
		
		//���ܲ��ԣ������������ֻ��һ���ڵ�
		System.out.println(of16.reverseList(node4).value);
		
		//����������ԣ�����ͷ�ڵ�Ϊnullָ��
		System.out.println(of16.reverseList(null));

	}

}
