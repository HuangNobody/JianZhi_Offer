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

	public static void main(String[] args) {
		Offer06 of6 = new Offer06();
		//��������
		//1����ͨ����������ȫ������������ȫ��������
		int[] pre1 = {1,2,4,5,3,6,7};
		int[] in1 = {4,2,5,1,6,3,7};
		System.out.println(of6.reConstructBinaryTree(pre1, in1).val);
		
		int[] pre2 = {1,2,4,7,3,5,6,8};
		int[] in2 = {4,7,2,1,5,3,8,6};
		System.out.println(of6.reConstructBinaryTree(pre2, in2).val);
		
		//2,��������������нڵ㶼û�����ӽڵ�Ķ����������нڵ㶼û�����ӽڵ�Ķ�������ֻ��һ���ڵ�Ķ�������
		int[] pre3 = {1,2,4,5};
		int[] in3 = {4,2,5,1};
		System.out.println(of6.reConstructBinaryTree(pre3, in3).val);
		
		int[] pre4 = {1,3,6,7};
		int[] in4 = {1,6,3,7};
		System.out.println(of6.reConstructBinaryTree(pre4, in4).val);
		
		int[] pre5 = {1};
		int[] in5 = {1};
		System.out.println(of6.reConstructBinaryTree(pre5, in5).val);
		
		//3,����������ԣ��������ĸ��ڵ�ΪNULL,�����ǰ��������к�����������в�ƥ�䣩
		int[] pre6 = null;
		int[] in6 = null;
		System.out.println(of6.reConstructBinaryTree(pre6, in6));

	}
}
