
public class Offer15 {
	
	public static class ListNode{
		int value;
		ListNode next;
		ListNode(int val){
			this.value = val;
		}
	}
	
	public ListNode findKthToTail(ListNode head, int k){
		if(head == null || k == 0)
			return null;
		
		ListNode pAhead = head;
		ListNode pBehind = null;
		
		for(int i = 0;i<k-1;i++){
			if(pAhead.next != null)
				pAhead = pAhead.next;
			else
				return null;
		}
		
		pBehind = head;
		while(pAhead.next != null){//��һ��������д��pAhead != null,�������ʱ��k=5ʱ���2��k=1ʱ����
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
	}
	
	public static void main(String[] args) {
		
		Offer15 ofo15 = new Offer15();
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		//node5.next = null;
		
		// 1���ܲ��ԣ���k���ڵ���������м�
		System.out.println(ofo15.findKthToTail(node1, 3).value);
		
		// 1���ܲ��ԣ���k���ڵ��������ͷ�ڵ�
		System.out.println(ofo15.findKthToTail(node1, 1).value);
		
		// 1���ܲ��ԣ���k���ڵ��������β�ڵ�
		System.out.println(ofo15.findKthToTail(node1, 5).value);
		
		//����������ԣ�����ͷ�ڵ�ΪNULLָ��
		System.out.println(ofo15.findKthToTail(null, 5));//�������Ǻ�����һ����.value,�򱨴�Exception in thread "main" java.lang.NullPointerException

		//����������ԣ�����Ľڵ���������k����forѭ���б���������ܻ����ָ��null��next
		System.out.println(ofo15.findKthToTail(node1, 7));
		
		//����������ԣ�k=0
		System.out.println(ofo15.findKthToTail(node1, 0));
	}
}
