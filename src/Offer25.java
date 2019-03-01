

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
		if(root.left == null && root.right == null){//��ǰϵ�ڵ���Ҷ�ӽڵ�ʱ
			if(root.data == k ){
				System.out.print("·����ʼ");
				for(int i:path)
					System.out.print(i+", ");
				System.out.println(root.data);
			}
		}else{//��ǰ�ڵ㲻��Ҷ�ӽڵ�ʱ
			path.push(root.data);
			findPath(root.left, k-root.data, path);
			findPath(root.right, k- root.data, path);
			path.pop();
		}
	}
	
	//Ϊ��ʹ������ԣ������װ��һ������ָ�����ڵ�����Ӻ��Һ��ӽڵ�ķ�����
	public static void setSubTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right = right;
	}

	public static void main(String[] args) {
		
		Offer25 of25 = new Offer25();
		
		//���ܲ��ԣ�1 ���������ж�������������·��
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
		
		System.out.println("��������1:");
		of25.findPath(node11, 22);
		
		//���ܲ��ԣ�2 ����������1������������·��
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
			
		System.out.println("��������2:");
		of25.findPath(node21, 22);
		
		//���ܲ��ԣ�3 ����������1������������·��
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
					
		System.out.println("��������3:");
		of25.findPath(node31, 22);
		
		//����������ԣ�ָ����������ڵ��ָ��ΪNULLָ��
		
		System.out.println("��������4:");
		of25.findPath(null, 22);
		
	}

}
