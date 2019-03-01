
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
			super();//ǧ������ˣ���Ȼ��������û�������node9ʵ����ʱ����
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

	//�������
		/*offer��add����
		 *  һЩ�����д�С���ƣ�����������һ�����Ķ����м���һ������������ͻᱻ�ܾ��� ��ʱ�µ�offer ����
		 * �Ϳ����������ˡ������ǶԵ��� add() �����׳�һ�� unchecked �쳣����ֻ�ǵõ��� offer() ���ص� false�� 
		 *  poll��remove���� 
		 *  remove() �� poll() �������ǴӶ�����ɾ����һ��Ԫ�ء�remove() ����Ϊ�� Collection �ӿڵİ汾���ƣ� 
		 *  �����µ� poll() �������ÿռ��ϵ���ʱ�����׳��쳣��ֻ�Ƿ��� null������µķ������ʺ����׳����쳣�����������
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
	
	//Ϊ��ʹ������ԣ������װ��һ������ָ�����ڵ�����Ӻ��Һ��ӽڵ�ķ�����
		public static void setSubTreeNode(TreeNode root, TreeNode left, TreeNode right){
			if(root == null)
				return;
			root.left = left;
			root.right = right;
		}
	
	public static void main(String[] args) {
		
		 // 01.��ͨ������
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
