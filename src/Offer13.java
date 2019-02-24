//ǰ�᣺����Ҫɾ���Ľڵ������������
//ɾ��i�ڵ㣬�Ȱ�i����һ���ڵ�j�����ݸ��Ƶ�i��Ȼ��ѽڵ�i��ָ��ָ��ڵ�j����һ���ڵ�

public class Offer13 {
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode delete(ListNode headNode, ListNode ToBeDeleteNode){
		// 1.�������Ϊ�գ�����Ҫɾ���Ľڵ�Ϊ�գ�����
		if(headNode == null || ToBeDeleteNode == null)
			return null;
		
		//Ҫɾ���Ľڵ㲻��β�ڵ�
		if(ToBeDeleteNode.next != null){//��ʼʱ�������ToBeDeleteNode.next��next���ˣ�������ֿ�ָ���쳣
			ListNode tempNode = ToBeDeleteNode.next;// Ҫ��һ����ʱ�ڵ㱣��toBeDeleted��next�ڵ�
			ToBeDeleteNode.val = tempNode.val;
			ToBeDeleteNode.next = tempNode.next;
			
			tempNode = null;
		}else if(headNode == ToBeDeleteNode){  //����ֻ��һ���ڵ㣬ɾ��ͷ�ڵ㣨Ҳ��β�ڵ㣩
			ToBeDeleteNode = null;
			headNode = null;
		}else{                         //�������ж���ڵ㣬ɾ��β�ڵ�
			ListNode tempNode = headNode;
			while(tempNode.next != ToBeDeleteNode)
				tempNode = tempNode.next;
			
			tempNode.next = null;
			ToBeDeleteNode = null;
		}
		return headNode;
	}
	
	public void print(ListNode headNode){
		if(headNode == null)
			System.out.println("List is null");
		while(headNode != null){
			System.out.print(headNode.val+", ");
			headNode = headNode.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Offer13 of13 = new Offer13();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		//��������
		//1�����ܲ��ԣ�
		System.out.println("�������ж����㣬ɾ��ͷ���:");
		of13.print(of13.delete(node1, node1));
		
		System.out.println("�������ж����㣬ɾ���м��һ�����:");
		of13.print(of13.delete(node1, node3));
		
		System.out.println("�������ж����㣬ɾ��β���:");
		of13.print(of13.delete(node1, node5));
		
		System.out.println("������ֻ��һ���ڵ㣬ɾ�����:");
		of13.print(of13.delete(node5, node5));
		
		//2,����������ԣ���ָ������ͷ�ڵ�ָ��ΪNULLָ�룩
		System.out.println("ָ������ͷ�ڵ�ָ��ΪNULLָ��:");
		of13.print(of13.delete(null, node5));
		
		//ָ��Ҫɾ���Ľڵ�ΪNULLָ��
		System.out.println("ָ��Ҫɾ���Ľڵ�ΪNULLָ��:");
		of13.print(of13.delete(node1, null));
		
	}
}
