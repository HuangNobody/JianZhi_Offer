package Test_1;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(){};
	
	TreeNode(int data,TreeNode left, TreeNode right){
		super();//ǧ������ˣ���Ȼ��������û�������node9ʵ����ʱ����
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public void setLeft(TreeNode left){
		this.left = left;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public void setRight(TreeNode right){
		this.right = right;
	}
}
