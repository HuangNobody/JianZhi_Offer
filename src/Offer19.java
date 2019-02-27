import java.util.Stack;

public class Offer19 {
	
	public static class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(){}
		
		BinaryTreeNode(int value){// ֻ��һ���ڵ�ʱ������ֻ�и��ڵ�
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
		
		public BinaryTreeNode getLeft(){
			return left;
		}
		
		public BinaryTreeNode getRight(){
			return right;
		}
	}
	
	//�ݹ�ʵ��
	public void mirrorRecursively(BinaryTreeNode root){
		if(root == null)
			return;
		if(root.left == null && root.right == null)
			return;
		
		// ������ǰ�ڵ�������ӽڵ�,ע�⣬Ҫ��.value.��Ȼ�����ԵĲ�����ʾ������
		BinaryTreeNode tempNode = root.left;// ������ǰ�ڵ�������ӽڵ�
		root.left = root.right;
		root.right = tempNode;
		
		// �������ݹ�
		if(root.left != null)
			mirrorRecursively(root.left);
		
		// �������ݹ�
		if(root.right != null)
			mirrorRecursively(root.right);
	}
	
	//Ϊ��ʹ������ԣ������װ��һ������ָ�����ڵ�����Ӻ��Һ��ӽڵ�ķ�����
	public static void setSubTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right = right;
	}
	
	//��ѭ��ʵ��
	public void mirror(BinaryTreeNode root){
		if(root == null)
			return;
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode currentNode = stack.pop();//����Ԫ�س�ջ ������Ԫ�ص���������
			if(currentNode.left != null || currentNode.right != null){//�����Һ��Ӳ�Ϊ���򽻻����Һ���
				BinaryTreeNode tempNode = currentNode.left;
				currentNode.left = currentNode.right;
				currentNode.right = tempNode;
			}
			
			//����Ԫ�ص����Һ���ѹ��ջ�� 
			if(currentNode.left != null)
				stack.push(currentNode.left);
			if(currentNode.right != null)
				stack.push(currentNode.right);
		}
	}
	
	//ǰ��ݹ�ʵ�����
		public void preOrderRe(BinaryTreeNode root){
			//System.out.println(biTree.value);
			if(root != null){
				System.out.print(root.getValue()+", ");
				preOrderRe(root.getLeft());
				preOrderRe(root.getRight());
			}
		}
	
	
	
	public static void main(String[] args) {

		Offer19 of19 = new Offer19();
		//���ܲ���
		 // 01.��ͨ������
	    //                  8                      8 
	    //              /       \                /    \
	    //             6         10            10      6
	    //           /   \     /   \          /  \    /  \
	    //          5     7   9    11        11  9    7   5
		BinaryTreeNode nodeA11 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA12 = new BinaryTreeNode(6);
		BinaryTreeNode nodeA13 = new BinaryTreeNode(10);
		BinaryTreeNode nodeA14 = new BinaryTreeNode(5);
		BinaryTreeNode nodeA15 = new BinaryTreeNode(7);
		BinaryTreeNode nodeA16 = new BinaryTreeNode(9);
		BinaryTreeNode nodeA17 = new BinaryTreeNode(11);
		
		setSubTreeNode(nodeA11, nodeA12, nodeA13);
		setSubTreeNode(nodeA12, nodeA14, nodeA15);
		setSubTreeNode(nodeA13, nodeA16, nodeA17);
	    
		System.out.println("���1������Ϊ�� ");
		of19.mirrorRecursively(nodeA11);
		of19.mirror(nodeA11);
		of19.preOrderRe(nodeA11);
		System.out.println();
		
		//���ܲ���
		 // 02.�����������нڵ㶼û��������
	    //                  8                      8 
	    //                      \                /     
	    //                       10            10      
	    //                         \          /  
	    //                         11        11 
		BinaryTreeNode nodeA21 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA22 = new BinaryTreeNode(10);
		BinaryTreeNode nodeA23 = new BinaryTreeNode(11);
		
		nodeA21.right = nodeA22;
		nodeA22.right = nodeA23;
		
		System.out.println("���2������Ϊ�� ");
		of19.mirrorRecursively(nodeA21);
		of19.preOrderRe(nodeA21);
		of19.mirror(nodeA21);
		System.out.println();
		
		//���ܲ���
		 // 03.�����������нڵ㶼û��������
	    //                  8                      8 
	    //              /                             \
	    //             6                               6
	    //           /                                   \
	    //          5                                    5
		BinaryTreeNode nodeA31 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA32 = new BinaryTreeNode(6);
		BinaryTreeNode nodeA33 = new BinaryTreeNode(5);
		
		nodeA31.left = nodeA32;
		nodeA32.left = nodeA33;
		
		System.out.println("���3������Ϊ�� ");
		of19.mirrorRecursively(nodeA31);
		of19.preOrderRe(nodeA31);
		of19.mirror(nodeA31);
		System.out.println();
		
		//���ܲ���
		 // 04.ֻ��һ���ڵ�Ķ�����
	    //                  8                      8 
		BinaryTreeNode nodeA41 = new BinaryTreeNode(8);
		System.out.println("���4������Ϊ�� ");
		of19.mirrorRecursively(nodeA41);
		of19.preOrderRe(nodeA41);
		of19.mirror(nodeA41);
		System.out.println();
		
		//�����������
		//�������ĸ��ڵ�ΪNULLָ��
		System.out.println("���5������Ϊ�� ");
		of19.mirrorRecursively(null);
		of19.preOrderRe(null);
		of19.mirror(null);
		System.out.println();

	}
}
