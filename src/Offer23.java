
import java.util.LinkedList;
import java.util.Queue;

import Test_1.TreeNode;

public class Offer23 {
	
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(){};
		
		public TreeNode(int val){
			this.data = val;
		}
		
		TreeNode(int data,TreeNode left, TreeNode right){
			super();//千万别忘了，不然会出错，如果没有这句在node9实例化时报错
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public int getData(){
			return data;
		}
		
		public TreeNode getLeft(){
			return left;
		}
		
		public TreeNode getRight(){
			return right;
		}
	}

	//层序遍历
		/*offer，add区别：
		 *  一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。 这时新的offer 方法
		 * 就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。 
		 *  poll，remove区别： 
		 *  remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 
		 *  但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
		 */
	public void levelOrder(TreeNode root){
		TreeNode temp;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			temp = queue.poll();
			System.out.print(temp.getData()+", ");
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
	}
	
	//为了使方便测试，这里封装了一个设置指定根节点的左孩子和右孩子节点的方法：
		public static void setSubTreeNode(TreeNode root, TreeNode left, TreeNode right){
			if(root == null)
				return;
			root.left = left;
			root.right = right;
		}
	
	public static void main(String[] args) {
		
		 // 01.普通二叉树
	    //                  8                     
	    //              /       \               
	    //             6         10           
	    //           /   \     /   \        
	    //          5     7   9    11       
		
		TreeNode nodeA11 = new TreeNode(8);
		TreeNode nodeA12 = new TreeNode(6);
		TreeNode nodeA13 = new TreeNode(10);
		TreeNode nodeA14 = new TreeNode(5);
		TreeNode nodeA15 = new TreeNode(7);
		TreeNode nodeA16 = new TreeNode(9);
		TreeNode nodeA17 = new TreeNode(11);
		
		setSubTreeNode(nodeA11, nodeA12, nodeA13);
		setSubTreeNode(nodeA12, nodeA14, nodeA15);
		setSubTreeNode(nodeA13, nodeA16, nodeA17);
		
		Offer23 of23 = new Offer23();
		
		of23.levelOrder(nodeA11);

	}

}
