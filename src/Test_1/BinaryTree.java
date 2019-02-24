package Test_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	//ǰ��ݹ�ʵ��
	public void preOrderRe(TreeNode root){
		//System.out.println(biTree.value);
		if(root != null){
			System.out.print(root.getData()+", ");
			preOrderRe(root.getLeft());
			preOrderRe(root.getRight());
		}
	}
	
	//ǰ��ǵݹ�ķ�ʽ
	public void preOrderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		while(true){
			while(root !=null){
				System.out.print(root.getData()+", ");
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty()) break;//���������һ���ڵ�ʱ������һ������ѭ��
			root = stack.pop();
			root = root.getRight();
		}
	}
	
	//�������+�ݹ�
	public void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.getLeft());
			System.out.print(root.getData()+", ");
			inOrder(root.getRight());
		}
	}
	
	//�������+�ǵݹ�
	public void inOrderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		while(true){
			while(root != null){
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty()) break;
			root = stack.pop();
			System.out.print(root.getData()+", ");
			root = root.getRight();
		}
	}
	
	//�������+�ݹ�
	public void postOrder(TreeNode root){
		if(root != null){
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData()+", ");
		}
	}
	
	//��������+�ǵݹ�(�������ѵ�һ��)
	public void postOrderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		while(true){
			if(root !=null){
				stack.push(root);
				root = root.getLeft();
			}else{
				if(stack.isEmpty()) return;
				
				if(stack.lastElement().getRight() == null){//Vector��lastElement(),Returns the last component of the vector.
					root = stack.pop();
					System.out.print(root.getData()+", ");
					while(root == stack.lastElement().getRight()){
						System.out.print(stack.lastElement().getData()+", ");
						root = stack.pop();
						if(stack.isEmpty()){
							break;
						}
					}
				}
				
				if(!stack.isEmpty())
					root = stack.lastElement().getRight();
				else
					root = null;
			}
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
	
	public static void main(String[] args) {
		//ע���������ʹ�ú�������������������������Ƚ����ӽڵ㣬���������Ͻ�������Ϊ��Ҷ�ӽ���ʹ�õ�����Ľڵ㣬
		//����ʼ���ǰ�˳���ʼ���ģ����������ᱨ����������ú�����������������������������������������
		TreeNode node9 = new TreeNode(8,null, null);
		TreeNode node8 = new TreeNode(4,null, null);
		TreeNode node7 = new TreeNode(2, null, null);
		TreeNode node6 = new TreeNode(7,null, node9);
		TreeNode node5 = new TreeNode(5,node8, null);
		TreeNode node4 = new TreeNode(1, null, node7);
		TreeNode node3 = new TreeNode(9, node6, null);
		TreeNode node2 = new TreeNode(3, node4, node5);
		TreeNode node1 = new TreeNode(6, node2,node3);
		
		BinaryTree tree = new BinaryTree();
		System.out.println("����������������ݹ飩��");
		tree.preOrderRe(node1);
		System.out.println();
		
		System.out.println("����������������ǵݹ飩��");
		tree.preOrderNonRecursive(node1);
		System.out.println();
		
		System.out.println("����������������ݹ飩��");
		tree.inOrder(node1);
		System.out.println();
		
		System.out.println("����������������ǵݹ飩��");
		tree.inOrderNonRecursive(node1);
		System.out.println();
		
		System.out.println("����������������ݹ飩��");
		tree.postOrder(node1);
		System.out.println();
		
		System.out.println("����������������ǵݹ飩��");
		tree.postOrderNonRecursive(node1);
		System.out.println();
		
		System.out.println("����������������ݹ飩��");
		tree.levelOrder(node1);
		System.out.println();
	}
}

