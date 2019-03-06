import java.util.ArrayList;
import java.util.LinkedList;

public class Offer50 {

	public static class TreeNode{
		private int value;
		private TreeNode left;
		private TreeNode right;
		
		TreeNode(){}
		
		TreeNode(int val){
			this.value = val;
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(" value = "+value);
			sb.append(" left = "+(left==null? "null":left.value));
			sb.append(" right = "+(right== null? "null":right.value));
			return sb.toString();
		}
	}
	
	public static void setSubTreeNode(TreeNode root, TreeNode left, TreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right =right;
	}
	
	//1,���Ƕ����������������������Ǿ��������Ķ�����
	public static TreeNode getLastCommonNode(TreeNode root, TreeNode leftNode, TreeNode rightNode){
		if(root ==null || leftNode.value>rightNode.value)
			return null;
		TreeNode treeNode = null;
		if(root.value>=rightNode.value)
			treeNode = getLastCommonNode(root.left, leftNode, rightNode);
		if(root.value<=leftNode.value)
			treeNode = getLastCommonNode(root.right, leftNode, rightNode);
		if(root.value >=leftNode.value && root.value<=rightNode.value)
			return root;
		return treeNode;
	}
	
	//3,f�����Ƕ�������Ҳû��ָ�򸸽ڵ�����á�
	
	public static class TreeNode1{
		char value;
		TreeNode1 childs[];
		
		TreeNode1(){}
		
		TreeNode1(char val){
			this.value = val;
		}
		@Override
		public String toString(){
			return "TreeNode1 [value="+value+"]";
		}
	}
	
	//ʹ������������������ڵ㵽����ڵ��·��
	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();
	
	public static TreeNode1 findLastCommonNode(TreeNode1 node1, TreeNode1 node2, TreeNode1 root){
		getPathFromRootToNode(node1, root, list1);
		getPathFromRootToNode(node2, root, list2);
		//list1 : D -- B -- A
		 //list2 : E -- B -- A
		
		//�������������������ҵ�����Ĺ����ڵ�
		int index = 0;
		int length1 = list1.size();
		int length2 = list2.size();
		int sub = length1>length2 ? length1-length2:length2-length1;
		if(length2>length1){
			LinkedList temp = list1;
			list1 = list2;
			list2 = temp;
		}
		
		while(index != length2-1){
			if(((TreeNode1)list1.get(index+sub)).value == ((TreeNode1)list2.get(index)).value)
				return (TreeNode1)list2.get(index);
			else
				index++;
		}
		return null;
	}

	public static boolean getPathFromRootToNode(TreeNode1 node, TreeNode1 currentRoot,
			LinkedList list) {
		//�ҵ���ֱ�ӷ���true
		if(node.value == currentRoot.value)
			return true;
		
		//�Ҳ����ͽ���ǰ�ڵ����·��,push���������ͷ�����,offer��β��
		list.push(currentRoot);
		
		boolean found = false;
		
		TreeNode1 [] childs = currentRoot.childs;
		if(childs != null && childs.length>0){
			//������ǰ�ڵ�������ӽڵ㣬���ӽڵ������
			for(int i = 0;i<childs.length;i++){
				if(found)
					break;
				else
					found = getPathFromRootToNode(node, childs[i],list);
			}
		}
		//�Ҳ����ͽ���ǰ�ڵ��·����ɾ��,��Ϊ�ǵݹ飬���ݹ�����������ʱ�򣬵�ǰ�ڵ�һ����list�����һ���ڵ㣬��ջ��
		if(!found)
			list.pop();
		
		return found;
	}

	public static void main(String[] args) {
	
		/*
		//1,����������
		 
		                 4
		                /  \
		               2    6
		              / \  / \
		             1   3 5  7
		         
		//��ֵΪ3�Ľڵ��ֵΪ5�Ľڵ��LCA
		TreeNode node14 = new TreeNode(4);
		TreeNode node12 = new TreeNode(2);
		TreeNode node16 = new TreeNode(6);
		TreeNode node11 = new TreeNode(1);
		TreeNode node13 = new TreeNode(3);
		TreeNode node15 = new TreeNode(5);
		TreeNode node17 = new TreeNode(7);
		
		setSubTreeNode(node14, node12, node16);
		setSubTreeNode(node12, node11, node13);
		setSubTreeNode(node16, node15, node17);
		
		System.out.println(getLastCommonNode(node14, node13, node15));
		*/
		
		  /*
		                  A
		                 / \ 
		                B   C
		               /  \ 
		               D    E
		             / \   / | \
		            F   G  H I  J
		           */
		          
		          //��F,H�ڵ��LCA
		TreeNode1 node21 = new TreeNode1('A');
		TreeNode1 node22 = new TreeNode1('B');
		TreeNode1 node23 = new TreeNode1('C');
		TreeNode1 node24 = new TreeNode1('D');
		TreeNode1 node25 = new TreeNode1('E');
		TreeNode1 node26 = new TreeNode1('F');
		TreeNode1 node27 = new TreeNode1('G');
		TreeNode1 node28 = new TreeNode1('H');
		TreeNode1 node29 = new TreeNode1('I');
		TreeNode1 node20 = new TreeNode1('J');
		
		node21.childs = new TreeNode1[] {node22,node23};
		node22.childs = new TreeNode1[] {node24, node25};
		node24.childs = new TreeNode1[] {node26, node27};
		node25.childs = new TreeNode1[] {node28, node29, node20};
		
		System.out.println(findLastCommonNode(node26, node28, node21));
		
	}
}
