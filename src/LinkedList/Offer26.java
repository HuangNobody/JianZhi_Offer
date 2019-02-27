package LinkedList;

public class Offer26 {

	//��������Ľڵ㶨��
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
	
	//���������һ��,����ԭʼ���A������洴��A'��
	public void cloneNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode != null){
			//����pCloned��㼴A'���ʹ��ָ��ԭʼ������A������һ���B,����A'��m_pSibling����Ϊnull
			ComplexListNode pCloned = new ComplexListNode();//������һ���ڵ�
			pCloned.value = pNode.value;
			pCloned.next = pNode.next;
			pCloned.sibling = null;
			
			//��A���ָ��A�����
			pNode.next = pCloned;
			//ʹpNodeָ��A����һ���B���Դ�ѭ���޸�(��ʱ�м��ѽ���¡���A��������ԭʼ�б�)
			pNode = pCloned.next;
		}
	}
	
	//����ÿ������m_pSibling(ע��m_pSiblingΪ�ս�㲻���޸�)
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
	
	
	//�������
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
		
		//���ܲ��ԣ�1���ڵ��е�siblingָ��ڵ�����
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
		
		//���ܲ��ԣ�2�������ڵ��sibling�γɻ�״�ṹ
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
		
		//���ܲ��ԣ�2��������ֻ��һ���ڵ�
		ComplexListNode node31 = new ComplexListNode(1);
		
		ComplexListNode tempNode31 = of26.clone(node31);
		
		while(tempNode31 != null){
			System.out.println(tempNode31);
			tempNode31 = tempNode31.next;
		}
		System.out.println();
		
		//����������ԣ�ָ������ͷ�ڵ��ָ��ΪNULL
		ComplexListNode node41 = null;
		
		ComplexListNode tempNode41 = of26.clone(node41);
		
		while(tempNode41 != null){
			System.out.println(tempNode41);
			tempNode41 = tempNode41.next;
		}
		System.out.println();

	}

}
