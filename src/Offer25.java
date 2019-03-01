

import java.util.Stack;

public class Offer25 {
	
	public static class BinaryTreeNode{
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(){}
		
		BinaryTreeNode(int val){
			this.data = val;
		}
	}

	public void findPath(BinaryTreeNode root, int k){
		if(root == null)
			return;
		Stack<Integer> stack = new Stack<>();
		findPath(root, k, stack);
	}
	
	
	public void findPath(BinaryTreeNode root, int k, Stack<Integer> path) {
		if(root == null)
			return;
		if(root.left == null && root.right == null){//当前系节点是叶子节点时
			if(root.data == k ){
				System.out.print("路径开始");
				for(int i:path)
					System.out.print(i+", ");
				System.out.println(root.data);
			}
		}else{//当前节点不是叶子节点时
			path.push(root.data);
			findPath(root.left, k-root.data, path);
			findPath(root.right, k- root.data, path);
			path.pop();
		}
	}
	
	//为了使方便测试，这里封装了一个设置指定根节点的左孩子和右孩子节点的方法：
	public static void setSubTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right = right;
	}

	public static void main(String[] args) {
		
		Offer25 of25 = new Offer25();
		
		//功能测试，1 二叉树中有多条符合条件的路径
		//      			10                     
		//              /       \               
		//             5         12           
		//           /   \           
		//          4     7   
		
		BinaryTreeNode node11 = new BinaryTreeNode(10);
		BinaryTreeNode node12 = new BinaryTreeNode(5);
		BinaryTreeNode node13 = new BinaryTreeNode(12);
		BinaryTreeNode node14 = new BinaryTreeNode(4);
		BinaryTreeNode node15 = new BinaryTreeNode(7);
		
		setSubTreeNode(node11, node12, node13);
		setSubTreeNode(node12, node14, node15);
		
		System.out.println("测试用例1:");
		of25.findPath(node11, 22);
		
		//功能测试，2 二叉树中有1条符合条件的路径
		//      			10                     
		//              /       \               
		//             5         18          
		//           /   \           
		//          4     7   
				
		BinaryTreeNode node21 = new BinaryTreeNode(10);
		BinaryTreeNode node22 = new BinaryTreeNode(5);
		BinaryTreeNode node23 = new BinaryTreeNode(18);
		BinaryTreeNode node24 = new BinaryTreeNode(4);
		BinaryTreeNode node25 = new BinaryTreeNode(7);
				
		setSubTreeNode(node21, node22, node23);
		setSubTreeNode(node22, node24, node25);
			
		System.out.println("测试用例2:");
		of25.findPath(node21, 22);
		
		//功能测试，3 二叉树中有1条符合条件的路径
		//      			10                     
		//              /       \               
		//             5         18          
		//           /   \           
		//          4     7   
						
		BinaryTreeNode node31 = new BinaryTreeNode(10);
		BinaryTreeNode node32 = new BinaryTreeNode(5);
		BinaryTreeNode node33 = new BinaryTreeNode(18);
		BinaryTreeNode node34 = new BinaryTreeNode(4);
		BinaryTreeNode node35 = new BinaryTreeNode(10);
						
		setSubTreeNode(node31, node32, node33);
		setSubTreeNode(node32, node34, node35);
					
		System.out.println("测试用例3:");
		of25.findPath(node31, 22);
		
		//特殊输入测试，指向二叉树根节点的指针为NULL指针
		
		System.out.println("测试用例4:");
		of25.findPath(null, 22);
		
	}

}
