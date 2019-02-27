package LinkedList;

public class Offer26 {

	//复杂链表的节点定义
	public static class ComplexListNode{
		int value;
		ComplexListNode next = null;
		ComplexListNode sibling =null;
		
		ComplexListNode(){}
		
		ComplexListNode(int val){
			super();
			this.value = val;
		}
		
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(" value= "+ value);
			sb.append(", next= "+(next ==null ? "null":next.value));
			sb.append(", sibling=" +(sibling == null? "null":sibling.value));
			return sb.toString();
		}
	}
	
	//复制链表第一步,根据原始结点A在其后面创建A'。
	public void cloneNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode != null){
			//创建pCloned结点即A'结点使其指向原始链表中A结点的下一结点B,不过A'的m_pSibling设置为null
			ComplexListNode pCloned = new ComplexListNode();//新增加一个节点
			pCloned.value = pNode.value;
			pCloned.next = pNode.next;
			pCloned.sibling = null;
			
			//将A结点指向A’结点
			pNode.next = pCloned;
			//使pNode指向A的下一结点B并以此循环修改(此时中间已将克隆结点A‘插入了原始列表)
			pNode = pCloned.next;
		}
	}
	
	//设置每个结点的m_pSibling(注：m_pSibling为空结点不做修改)
	public void connectSiblingNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode != null){
			ComplexListNode pCloned = pNode.next;
			if(pNode.sibling != null){
				pCloned.sibling = pNode.sibling.next;
			}
			pNode = pCloned.next;
		}
	}
	
	
	//拆分链表
	public ComplexListNode reconnectNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		ComplexListNode pClonedHead = null;
		ComplexListNode pClonedNode = null;
		if(pNode != null){
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		while(pNode != null){
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		return pClonedHead;
	}
	
	public ComplexListNode clone(ComplexListNode pHead){
		if(pHead == null)
			System.out.println("linkedlist is null");
		cloneNodes(pHead);
		connectSiblingNodes(pHead);
		return reconnectNodes(pHead);
	}
	
	
	
	public static void main(String[] args) {

		Offer26 of26 = new Offer26();
		
		//功能测试，1，节点中的sibling指向节点自身
		ComplexListNode node11 = new ComplexListNode(1);
		ComplexListNode node12 = new ComplexListNode(2);
		ComplexListNode node13 = new ComplexListNode(3);
		
		node11.next = node12;
		node11.sibling = node11;
		node12.next = node13;
		
		ComplexListNode tempNode11 = of26.clone(node11);
		
		while(tempNode11 != null){
			System.out.println(tempNode11);
			tempNode11 = tempNode11.next;
		}
		System.out.println();
		
		//功能测试，2，两个节点的sibling形成环状结构
		ComplexListNode node21 = new ComplexListNode(1);
		ComplexListNode node22 = new ComplexListNode(2);
		ComplexListNode node23 = new ComplexListNode(3);
		
		node21.next = node22;
		node21.sibling = node23;
		node22.next = node23;
		node23.sibling = node21;
		
		ComplexListNode tempNode21 = of26.clone(node21);
		
		while(tempNode21 != null){
			System.out.println(tempNode21);
			tempNode21 = tempNode21.next;
		}
		System.out.println();
		
		//功能测试，2，链表中只有一个节点
		ComplexListNode node31 = new ComplexListNode(1);
		
		ComplexListNode tempNode31 = of26.clone(node31);
		
		while(tempNode31 != null){
			System.out.println(tempNode31);
			tempNode31 = tempNode31.next;
		}
		System.out.println();
		
		//特殊输入测试，指向链表头节点的指针为NULL
		ComplexListNode node41 = null;
		
		ComplexListNode tempNode41 = of26.clone(node41);
		
		while(tempNode41 != null){
			System.out.println(tempNode41);
			tempNode41 = tempNode41.next;
		}
		System.out.println();

	}

}
