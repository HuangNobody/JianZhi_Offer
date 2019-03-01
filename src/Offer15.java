
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
		while(pAhead.next != null){//第一次我这里写成pAhead != null,结果运行时当k=5时输出2，k=1时报错
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
		
		// 1功能测试（第k个节点在链表的中间
		System.out.println(ofo15.findKthToTail(node1, 3).value);
		
		// 1功能测试（第k个节点是链表的头节点
		System.out.println(ofo15.findKthToTail(node1, 1).value);
		
		// 1功能测试（第k个节点是链表的尾节点
		System.out.println(ofo15.findKthToTail(node1, 5).value);
		
		//特殊输入测试（链表头节点为NULL指针
		System.out.println(ofo15.findKthToTail(null, 5));//这里若是和上面一样有.value,则报错Exception in thread "main" java.lang.NullPointerException

		//特殊输入测试（链表的节点总数少于k，在for循环中遍历链表可能会出现指向null的next
		System.out.println(ofo15.findKthToTail(node1, 7));
		
		//特殊输入测试（k=0
		System.out.println(ofo15.findKthToTail(node1, 0));
	}
}
