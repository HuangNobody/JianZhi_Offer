

public class Offer27 {

	public static class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(){}
		
		BinaryTreeNode(int val){
			this.value = val;
		}
		
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(" value = "+value);
			sb.append(", left = "+(left==null ? "null" : left.value));
			sb.append(", right = " + (right == null ?"null" : right.value));
			return sb.toString();
		}
	}
	
	//private BinaryTreeNode lastNodeInList = null;//ָ��˫�������β�ڵ�
	
	public BinaryTreeNode convert(BinaryTreeNode root){
		//�Ѿ�����õ�˫�������β��㣬ʹ��һ������Ϊ1�����飬����C++�еĶ���ָ��
		BinaryTreeNode [] lastNodeInList = new BinaryTreeNode[1];//ָ��˫�������β�ڵ�
		convertNode(root, lastNodeInList);
		
		//System.out.println(lastNodeInList);
		
		//������Ҫ����ͷ�ڵ㣬�½�һ��ͷ�ڵ�����ָ��˫������ı�ͷ�����ǲ�����Ҳ���ᱨ�������������Ǵ��
		BinaryTreeNode headNodeOfList = lastNodeInList[0];
	
		while(headNodeOfList != null && headNodeOfList.left != null){
			headNodeOfList = headNodeOfList.left;
		}
		
		return headNodeOfList;
	}
	
	public void convertNode(BinaryTreeNode node, BinaryTreeNode [] lastNodeInList) {
		if(node == null)
			return;
		BinaryTreeNode currentNode = node;
		// ��������������ȴ���������
		if(currentNode.left != null)
			convertNode(currentNode.left, lastNodeInList);
		// ����ǰ����ǰ��ָ���Ѿ�����õ�˫�������ɵ�ǰ�������������ɣ���β���
		currentNode.left = lastNodeInList[0];
		 // ���������ת���ɵ�˫������Ϊ�գ�����β���ĺ��
		if(lastNodeInList[0] != null)
			lastNodeInList[0].right = currentNode;//˫������ָ���һ���ڵ�
		// ��¼��ǰ���Ϊβ���
		lastNodeInList[0] = currentNode;
		//ת��������
		if(currentNode.right != null)
			convertNode(currentNode.right, lastNodeInList);
		//System.out.println(lastNodeInList);
	}
	
	//Ϊ��ʹ������ԣ������װ��һ������ָ�����ڵ�����Ӻ��Һ��ӽڵ�ķ�����
	public static void setSubTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right = right;
	}
	
	public static void printList(BinaryTreeNode root){
		while(root != null){
			System.out.print(root.value+"->");
			root = root.right;
		}
		System.out.print("null");
	}
	
	public static void printTree(BinaryTreeNode root){
		if(root!= null){
			printTree(root.left);
			System.out.print(root.value+"->");
			printTree(root.right);
		}
	}

	public static void main(String[] args) {
		
		Offer27 of27 = new Offer27();
		//���ܲ��ԣ�1������Ķ���������ȫ������
		//            10
		//         /      \
		//        6        14
		//       /\        /\
		//      4  8     12  16
		
		BinaryTreeNode node11 = new BinaryTreeNode(10);
		BinaryTreeNode node12 = new BinaryTreeNode(6);
		BinaryTreeNode node13 = new BinaryTreeNode(14);
		BinaryTreeNode node14 = new BinaryTreeNode(4);
		BinaryTreeNode node15 = new BinaryTreeNode(8);
		BinaryTreeNode node16 = new BinaryTreeNode(12);
		BinaryTreeNode node17 = new BinaryTreeNode(16);
		
		setSubTreeNode(node11, node12, node13);
		setSubTreeNode(node12, node14, node15);
		setSubTreeNode(node13, node16, node17);
		
		System.out.println("��������1:");
		System.out.print("Before convert: ");
		printTree(node11);
		System.out.println("null");
		
		BinaryTreeNode tempNode11 = of27.convert(node11);
		System.out.print("After convert: ");
		printList(tempNode11);
		System.out.println();
		
		//���ܲ���
		 // 02.�����������нڵ㶼û��������
	    //                  10                      
	    //                      \                    
	    //                       14                 
	    //                         \           
	    //                         16
		BinaryTreeNode node21 = new BinaryTreeNode(10);
		BinaryTreeNode node22 = new BinaryTreeNode(14);
		BinaryTreeNode node23 = new BinaryTreeNode(16);
		
		node21.right = node22;
		node22.right = node23;
		
		System.out.println("��������2:");
		System.out.print("Before convert: ");
		printTree(node21);
		System.out.println("null");
		
		BinaryTreeNode tempNode21 = of27.convert(node21);
		System.out.print("After convert: ");
		printList(tempNode21);
		System.out.println();
		
		//���ܲ���
		 // 03.�����������нڵ㶼û��������
	    //                  10                      
	    //              /                             
	    //             6                              
	    //           /                                   
	    //          4     
		BinaryTreeNode node31 = new BinaryTreeNode(10);
		BinaryTreeNode node32 = new BinaryTreeNode(6);
		BinaryTreeNode node33 = new BinaryTreeNode(4);
		
		node31.left = node32;
		node32.left = node33;
		
		System.out.println("��������3:");
		System.out.print("Before convert: ");
		printTree(node31);
		System.out.println("null");
		
		BinaryTreeNode tempNode31 = of27.convert(node31);
		System.out.print("After convert: ");
		printList(tempNode31);
		System.out.println();
		
		//���ܲ���
		 // 04.ֻ��һ���ڵ�Ķ�����
	    //                  10 
		BinaryTreeNode node41 = new BinaryTreeNode(10);
		
		System.out.println("��������4:");
		System.out.print("Before convert: ");
		printTree(node41);
		System.out.println("null");
		
		BinaryTreeNode tempNode41 = of27.convert(node41);
		System.out.print("After convert: ");
		printList(tempNode41);
		System.out.println();
		
		//����������ԣ�5
		//ָ��������ĸ��ڵ��ָ��ΪNULL
		BinaryTreeNode node51 = null;
		System.out.println("��������5:");
		System.out.print("Before convert: ");
		printTree(node51);
		System.out.println("null");
		
		BinaryTreeNode tempNode51 = of27.convert(node51);
		System.out.print("After convert: ");
		printList(tempNode51);
		System.out.println();

	}

}
