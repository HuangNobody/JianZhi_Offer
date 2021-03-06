import java.util.Arrays;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}
public class Offer06 {

	public TreeNode reConstructBinaryTree(int [] pre, int []in){
		if(pre == null || in == null)
			return null;
		if(pre.length == 0 || in.length == 0)
			return null;
		if(pre.length != in.length)
			return null;
		TreeNode root = new TreeNode(pre[0]);
		for(int i = 0;i<pre.length;i++){
			if(pre[0] == in[i]){
				root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1),
						Arrays.copyOfRange(in, 0, i));
				root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length),
						Arrays.copyOfRange(in, i+1, in.length));
			}
		}
		return root;
	}

	//方法2
	public TreeNode reConstructBinaryTree_2(int [] pre,int [] in) {
		TreeNode root = reConstructBinaryTree_2(pre, 0, pre.length-1, in, 0, in.length-1);
		return root;
	}

	public TreeNode reConstructBinaryTree_2(int [] pre, int startPre, int endPre,
											int [] in, int startIn, int endIn){
		if(startPre>endPre || startIn>endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]);
		for(int i = startIn;i<=endIn;i++){
			if(pre[startPre] == in[i]){
				//root.left = reConstructBinaryTree_2(pre, startPre+1, startPre+i, in, startIn, i-1);
				//root.right = reConstructBinaryTree_2(pre, startPre+i-1,endPre, in, i+1, endIn);这样写报错，数组越界
				root.left = reConstructBinaryTree_2(pre, startPre+1, startPre+(i-startIn),
						in, startIn, i-1);
				root.right = reConstructBinaryTree_2(pre, startPre+(i-startIn)+1,endPre,
						in, i+1, endIn);
                /*i-starin是在计算当前节点左子树节点个数；i-starin+starpre是确定当前节点左子树在pre里的位置；根据中序遍历+前序遍历的特点，
                pre[starpre+1]就是当前节点的左子节点，pre[i-starin+starpre+1]就是当前节点的右子节点；巧妙的是那个判定条件，越界即左右子节点不存在
                */
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Offer06 of6 = new Offer06();
		//测试用例
		//1，普通二叉树（完全二叉树，不完全二叉树）
		int[] pre1 = {1,2,4,5,3,6,7};
		int[] in1 = {4,2,5,1,6,3,7};
		//System.out.println(of6.reConstructBinaryTree(pre1, in1).val);
		System.out.println(of6.reConstructBinaryTree_2(pre1, in1).val);
		
		int[] pre2 = {1,2,4,7,3,5,6,8};
		int[] in2 = {4,7,2,1,5,3,8,6};
		//System.out.println(of6.reConstructBinaryTree(pre2, in2).val);
		
		//2,特殊二叉树（所有节点都没有右子节点的二叉树，所有节点都没有左子节点的二叉树，只有一个节点的二叉树）
		int[] pre3 = {1,2,4,5};
		int[] in3 = {4,2,5,1};
		//System.out.println(of6.reConstructBinaryTree(pre3, in3).val);
		
		int[] pre4 = {1,3,6,7};
		int[] in4 = {1,6,3,7};
		//System.out.println(of6.reConstructBinaryTree(pre4, in4).val);
		
		int[] pre5 = {1};
		int[] in5 = {1};
		//System.out.println(of6.reConstructBinaryTree(pre5, in5).val);
		
		//3,特殊输入测试（二叉树的根节点为NULL,输入的前序遍历序列和中序遍历序列不匹配）
		int[] pre6 = null;
		int[] in6 = null;
		//System.out.println(of6.reConstructBinaryTree(pre6, in6));

	}
}
