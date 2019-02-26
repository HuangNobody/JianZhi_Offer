public class Offer17 {
	
	public static class ListNode{
		int value;
		ListNode next = null;
		ListNode(int val){
			this.value = val;
		}
	}
	
	//递归解决
	public ListNode mergeRecursive(ListNode head1, ListNode head2){
		if(head1 == null)
			return head2;
		else if(head2 == null)
			return head1;
		
		ListNode pMergedHead = null;
		if(head1.value < head2.value){
			pMergedHead = head1;
			pMergedHead.next = mergeRecursive(head1.next, head2);
		}else{
			pMergedHead = head2;
			pMergedHead.next = mergeRecursive(head1, head2.next);
		}
		return pMergedHead;
	}
	
	//非递归,采用不带头节点的链表
	public ListNode merge(ListNode head1, ListNode head2){
		if(head1 == null )
			return head2;
		if(head2 == null)
			return head1;
		
		ListNode newHead = null;
		ListNode tempHead= null;
		
		while(head1 != null && head2 != null){
			if(head1.value <head2.value){
				if(newHead == null){
					newHead = head1;
					tempHead = head1;
				}else{
					tempHead.next = head1;
					tempHead = tempHead.next;
				}
				head1 = head1.next;
			}else{
				if(newHead == null){
					newHead = head2;
					tempHead = head2;
				}else{
					tempHead.next = head2;
					tempHead = tempHead.next;
				}
				head2 = head2.next;
			}
		}
		if(head1 == null)
			tempHead.next = head2;//第一次把tempHead.next写成tempHead，出错了
		else
			tempHead.next = head1;
		return newHead;
	}
	
	public static void print(ListNode head){
		if(head == null)
			System.out.println("List is null");
		while(head != null){
			System.out.print(head.value+", ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		head1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode head2 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(8);
		head2.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode head3 = new ListNode(2);
		ListNode node8 = new ListNode(4);
		ListNode node9 = new ListNode(6);
		ListNode node10 = new ListNode(8);
		head3.next = node8;
		node8.next = node9;
		node9.next = node10;
		
		ListNode head4 = new ListNode(2);
		ListNode node11 = new ListNode(4);
		ListNode node12 = new ListNode(6);
		ListNode node13 = new ListNode(8);
		head4.next = node11;
		node11.next = node12;
		node12.next = node13;
		
		Offer17 of17 = new Offer17();
		
		//功能测试（输入的两个链表有多个节点，节点的值互不相同
		//print(of17.mergeRecursive(head1, head2));
		//print(of17.merge(head1, head2));
				
		//功能测试（输入的两个链表有多个节点，节点的值互不相同
		//print(of17.mergeRecursive(head3, head4));
		//print(of17.merge(head3, head4));

		//特殊输入测试（两个链表的一个头节点为NULL指针
		//print(of17.mergeRecursive(head1, null));
		//print(of17.merge(head1, null));
		
		//特殊输入测试（两个链表的两个头节点为NULL指针
		//print(of17.mergeRecursive(null, null));
		//print(of17.merge(null, null));
		
		//特殊输入测试（两个链表中只有一个节点
		print(of17.mergeRecursive(node4, null));
		//print(of17.merge(node4, null));
	}

}
