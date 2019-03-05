public class Offer37 {

	public static class ListNode{
		int value;
		ListNode next;
		
		ListNode(){}
		
		ListNode(int val){
			this.value = val;
		}
		
		public int getValue(){
			return value;
		}
		
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(" value= "+value);
			sb.append(" next= "+(next == null?"null" : next.value));
			return sb.toString();
		}
	}
	
	public ListNode findFirstCommonNode(ListNode head1, ListNode head2){
		if(head1 == null || head2== null){
			System.out.print("invalid input  ");
			return null;
		}
			
		int length1 = getLength(head1);
		int length2 = getLength(head2);
		
		int lenDiff = length1 - length2;
		ListNode headLong = head1;
		ListNode headShort = head2;
		if(length2 > length1){
			headLong = head2;
			headShort = head1;
			lenDiff = length2-length1;
		}
		
		//���ڳ��������߻�������ͬʱ�����������ϱ���
		for(int i = 0;i<lenDiff;i++)
			headLong = headLong.next;
		
		while( headLong != headShort){
			//������headLong != null && headShort!=null &&headLong != headShort,���headShortweinull�������ָ���쳣
			headLong = headLong.next;
			headShort = headShort.next;
		}
		//int v = headLong.value;
		return headShort;
	}
	
	public int getLength(ListNode head) {
		int result = 0;
		if(head == null)
			return result;
		ListNode point = head;
		while(point != null){
			point = point.next;
			result++;
		}
		return result;
	}
	
	public static void printLinkedList(ListNode head){
		while(head != null){
			System.out.print(head.value+"->");
			head = head.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		
		Offer37 of37 = new Offer37();
		
		//���ܲ��ԣ�1����������������й����ڵ㣺��һ�������ڵ���������м�
		// ��һ����������������м�
		// 1 - 2 - 3 \
//		                6 - 7
//		      4 - 5 /
		ListNode node11a = new ListNode(1);
		ListNode node12a = new ListNode(2);
		ListNode node13a = new ListNode(3);
		
		ListNode node14b = new ListNode(4);
		ListNode node15b = new ListNode(5);
		
		ListNode node16a = new ListNode(6);
		ListNode node17a = new ListNode(7);
		
		node11a.next = node12a;
		node12a.next = node13a;
		node13a.next = node16a;
		node16a.next = node17a;
		
		node14b.next = node15b;
		node15b.next = node16a;
		
		printLinkedList(node11a);
		
		printLinkedList(of37.findFirstCommonNode(node11a, node14b));
		
		
		//���ܲ��ԣ�2����������������й����ڵ㣺 ������������һ�����
		// 1 - 2 - 3 - 4 \
//		                      7
//		           5 - 6 /
		ListNode node21a = new ListNode(1);
		ListNode node22a = new ListNode(2);
		ListNode node23a = new ListNode(3);
		ListNode node24a = new ListNode(4);
		
		ListNode node25b = new ListNode(5);
		ListNode node26b = new ListNode(6);
		
		ListNode node27a = new ListNode(7);
		
		node21a.next = node22a;
		node22a.next = node23a;
		node23a.next = node24a;
		
		node25b.next = node26b;
		
		node24a.next = node27a;
		node26b.next = node27a;
		
		printLinkedList(of37.findFirstCommonNode(node21a, node25b));
		
		//���ܲ��ԣ�3����������������й����ڵ㣺 ��������ǵ�һ�����
		// 1 - 2 - 3 - 4 - 5
		// ����������ȫ�غ� 
		ListNode node31a = new ListNode(1);
		ListNode node32a = new ListNode(2);
		ListNode node33a = new ListNode(3);
		ListNode node34a = new ListNode(4);
		ListNode node35a = new ListNode(5);
		
		node31a.next = node32a;
		node32a.next = node33a;
		node33a.next = node34a;
		node34a.next = node35a;
		
		printLinkedList(of37.findFirstCommonNode(node31a, node31a));
		
		//���ܲ��ԣ�4�� û�й������
		// 1 - 2 - 3 - 4
//		            
		// 5 - 6 - 7
		ListNode node41a = new ListNode(1);
		ListNode node42a = new ListNode(2);
		ListNode node43a = new ListNode(3);
		ListNode node44a = new ListNode(4);
		
		ListNode node45b = new ListNode(5);
		ListNode node46b = new ListNode(6);
		ListNode node47b = new ListNode(7);
		
		node41a.next = node42a;
		node42a.next = node43a;
		node43a.next = node44a;
		
		node45b.next = node46b;
		node46b.next = node47b;
		
		printLinkedList(of37.findFirstCommonNode(node41a, node45b));

		//����������ԣ����������ͷָ��ΪNULL
		ListNode node51a = null;
		ListNode node51b = null;
		printLinkedList(of37.findFirstCommonNode(node51a, node51b));
		

	}

}
