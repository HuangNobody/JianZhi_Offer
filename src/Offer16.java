
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
		if(head.next == null)//只有一个节点的时候，头结点就是反转节点的头结点
			return head;
		
		ListNode preNode = null;//表示反转链表的头结点
		ListNode curNode = head;
		ListNode nextNode = null;
		
		while(curNode != null){
			nextNode = curNode.next;//nextNode节点为curNode的下一个节点
			if(nextNode == null)
				preNode = curNode;//如果下一个节点为null，则表示当前节点为原链表的末尾节点
			
			curNode.next = preNode;//开始反转，让当前节点指向它的之前的节点
			preNode = curNode;//让之前的节点指向当前节点
			curNode = nextNode;//当前节点指向下一个节点：while循环里的第一句就是让这下一个节点继续向下走一步
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
		//功能测试，（输入的链表含多个节点
		System.out.println(of16.reverseList(node1).value);
		
		//功能测试，（输入的链表只有一个节点
		System.out.println(of16.reverseList(node4).value);
		
		//特殊输入测试（链表头节点为null指针
		System.out.println(of16.reverseList(null));

	}

}
