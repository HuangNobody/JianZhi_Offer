import java.util.Stack;

public class Offer19 {
	
	public static class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(){}
		
		BinaryTreeNode(int value){// 只有一个节点时，即：只有根节点
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
	
	//递归实现
	public void mirrorRecursively(BinaryTreeNode root){
		if(root == null)
			return;
		if(root.left == null && root.right == null)
			return;
		
		// 交换当前节点的左右子节点,注意，要加.value.不然最后测试的不好显示输出结果
		BinaryTreeNode tempNode = root.left;// 交换当前节点的左右子节点
		root.left = root.right;
		root.right = tempNode;
		
		// 左子树递归
		if(root.left != null)
			mirrorRecursively(root.left);
		
		// 右子树递归
		if(root.right != null)
			mirrorRecursively(root.right);
	}
	
	//为了使方便测试，这里封装了一个设置指定根节点的左孩子和右孩子节点的方法：
	public static void setSubTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right = right;
	}
	
	//用循环实现
	public void mirror(BinaryTreeNode root){
		if(root == null)
			return;
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode currentNode = stack.pop();//将根元素出栈 交换根元素的左右子树
			if(currentNode.left != null || currentNode.right != null){//若左右孩子不为空则交换左右孩子
				BinaryTreeNode tempNode = currentNode.left;
				currentNode.left = currentNode.right;
				currentNode.right = tempNode;
			}
			
			//将根元素的左右孩子压入栈中 
			if(currentNode.left != null)
				stack.push(currentNode.left);
			if(currentNode.right != null)
				stack.push(currentNode.right);
		}
	}
	
	//前序递归实现输出
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
		//功能测试
		 // 01.普通二叉树
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
	    
		System.out.println("情况1，镜像为： ");
		of19.mirrorRecursively(nodeA11);
		of19.mirror(nodeA11);
		of19.preOrderRe(nodeA11);
		System.out.println();
		
		//功能测试
		 // 02.二叉树的所有节点都没有左子树
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
		
		System.out.println("情况2，镜像为： ");
		of19.mirrorRecursively(nodeA21);
		of19.preOrderRe(nodeA21);
		of19.mirror(nodeA21);
		System.out.println();
		
		//功能测试
		 // 03.二叉树的所有节点都没有右子树
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
		
		System.out.println("情况3，镜像为： ");
		of19.mirrorRecursively(nodeA31);
		of19.preOrderRe(nodeA31);
		of19.mirror(nodeA31);
		System.out.println();
		
		//功能测试
		 // 04.只有一个节点的二叉树
	    //                  8                      8 
		BinaryTreeNode nodeA41 = new BinaryTreeNode(8);
		System.out.println("情况4，镜像为： ");
		of19.mirrorRecursively(nodeA41);
		of19.preOrderRe(nodeA41);
		of19.mirror(nodeA41);
		System.out.println();
		
		//特殊输入测试
		//二叉树的根节点为NULL指针
		System.out.println("情况5，镜像为： ");
		of19.mirrorRecursively(null);
		of19.preOrderRe(null);
		of19.mirror(null);
		System.out.println();

	}
}
