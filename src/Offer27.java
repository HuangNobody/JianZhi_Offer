

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
	
	//private BinaryTreeNode lastNodeInList = null;//指向双向链表的尾节点
	
	public BinaryTreeNode convert(BinaryTreeNode root){
		//已经处理好的双向链表的尾结点，使用一个长度为1的数组，类似C++中的二级指针
		BinaryTreeNode [] lastNodeInList = new BinaryTreeNode[1];//指向双向链表的尾节点
		convertNode(root, lastNodeInList);
		
		//System.out.println(lastNodeInList);
		
		//我们需要返回头节点，新建一个头节点用于指向双向链表的表头，若是不见，也不会报错，但是输出结果是错的
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
		// 如果有左子树就先处理左子树
		if(currentNode.left != null)
			convertNode(currentNode.left, lastNodeInList);
		// 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
		currentNode.left = lastNodeInList[0];
		 // 如果左子树转换成的双向链表不为空，设置尾结点的后继
		if(lastNodeInList[0] != null)
			lastNodeInList[0].right = currentNode;//双向链表指向后一个节点
		// 记录当前结点为尾结点
		lastNodeInList[0] = currentNode;
		//转换右子树
		if(currentNode.right != null)
			convertNode(currentNode.right, lastNodeInList);
		//System.out.println(lastNodeInList);
	}
	
	//为了使方便测试，这里封装了一个设置指定根节点的左孩子和右孩子节点的方法：
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
		//功能测试，1，输入的二叉树是完全二叉树
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
		
		System.out.println("测试用例1:");
		System.out.print("Before convert: ");
		printTree(node11);
		System.out.println("null");
		
		BinaryTreeNode tempNode11 = of27.convert(node11);
		System.out.print("After convert: ");
		printList(tempNode11);
		System.out.println();
		
		//功能测试
		 // 02.二叉树的所有节点都没有左子树
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
		
		System.out.println("测试用例2:");
		System.out.print("Before convert: ");
		printTree(node21);
		System.out.println("null");
		
		BinaryTreeNode tempNode21 = of27.convert(node21);
		System.out.print("After convert: ");
		printList(tempNode21);
		System.out.println();
		
		//功能测试
		 // 03.二叉树的所有节点都没有右子树
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
		
		System.out.println("测试用例3:");
		System.out.print("Before convert: ");
		printTree(node31);
		System.out.println("null");
		
		BinaryTreeNode tempNode31 = of27.convert(node31);
		System.out.print("After convert: ");
		printList(tempNode31);
		System.out.println();
		
		//功能测试
		 // 04.只有一个节点的二叉树
	    //                  10 
		BinaryTreeNode node41 = new BinaryTreeNode(10);
		
		System.out.println("测试用例4:");
		System.out.print("Before convert: ");
		printTree(node41);
		System.out.println("null");
		
		BinaryTreeNode tempNode41 = of27.convert(node41);
		System.out.print("After convert: ");
		printList(tempNode41);
		System.out.println();
		
		//特殊输入测试，5
		//指向二叉树的根节点的指针为NULL
		BinaryTreeNode node51 = null;
		System.out.println("测试用例5:");
		System.out.print("Before convert: ");
		printTree(node51);
		System.out.println("null");
		
		BinaryTreeNode tempNode51 = of27.convert(node51);
		System.out.print("After convert: ");
		printList(tempNode51);
		System.out.println();

	}

}
