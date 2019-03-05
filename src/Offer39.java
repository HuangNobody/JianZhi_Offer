public class Offer39 {

	public static class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(){}
		
		BinaryTreeNode(int val){
			this.value = val;
		}
	}
	
	//问题1，求二叉树的深度
	public int treeDepth(BinaryTreeNode root){
		if(root == null)
			return 0;
		int nLeft = treeDepth(root.left);
		int nRight = treeDepth(root.right);
		
		return (nLeft>nRight) ? (nLeft+1):(nRight+1);
	}
	
	//问题2.输入一个二叉树的根节点，判断该树是不是平衡二叉树
	//方法1,需要重复遍历节点多次的解法，不好
	public boolean isBalanced(BinaryTreeNode root){
		if(root == null)
			return true;
		
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int diff = left - right;
		if(diff>1 || diff<-1)
			return false;
		
		return isBalanced(root.left)&&isBalanced(root.right);
	}
	
	//方法2，每个基点只遍历一次的解法,后序遍历二叉树
	//高效率的判断是否是一棵平衡二叉树,照着课本上的c++代码翻译成java代码会出错，因为书中是&left，是引用传值，java中没有，这里用新建一个类解决这个问题
	public static class reference{
		private boolean isBalanced;
		private int depth;
		
		public reference(){}
		
		public reference(boolean isBalanced, int depth){
			super();
			this.isBalanced = isBalanced;
			this.depth = depth;
		}

		public boolean getIsBalanced() {
			return isBalanced;
		}

		public void setBalanced(boolean isBalanced) {
			this.isBalanced = isBalanced;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}
	}
	
	public reference isBalanced2(BinaryTreeNode root){
		if(root == null){
			reference re = new reference();
			re.setBalanced(true);
			re.setDepth(0);
			return re;
		}
		
		reference left = isBalanced2(root.left);
		reference right = isBalanced2(root.right);
		
		if(left.getIsBalanced()&& right.getIsBalanced()){
			int diff = left.getDepth() - right.getDepth();
			if(diff<=1&& diff>=-1)
				return new reference(true,(left.getDepth()>right.getDepth() ? left.getDepth() : right.getDepth())+1);
		}
		return new reference(false, -1);
		
	}
	
	
	public static void setBinaryTreeNode(BinaryTreeNode root,BinaryTreeNode left, BinaryTreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right = right;
	}
	
	public static void main(String[] args) {
		
		Offer39 of39 = new Offer39();
		/*
		//功能测试，1，输入普通的二叉树
		//            1
		//         /      \
		//        2        3
		//       /\         \
		//      4  5         6
		//        /
		//       7
		BinaryTreeNode node11 = new BinaryTreeNode(1);
		BinaryTreeNode node12 = new BinaryTreeNode(2);
		BinaryTreeNode node13 = new BinaryTreeNode(3);
		BinaryTreeNode node14 = new BinaryTreeNode(4);
		BinaryTreeNode node15 = new BinaryTreeNode(5);
		BinaryTreeNode node16 = new BinaryTreeNode(6);
		BinaryTreeNode node17 = new BinaryTreeNode(7);
		
		setBinaryTreeNode(node11, node12, node13);
		setBinaryTreeNode(node12, node14, node15);
		setBinaryTreeNode(node15, node17, null);
		setBinaryTreeNode(node13, null, node16);
		
		System.out.println(of39.treeDepth(node11));
		
		//功能测试
		 // 02.二叉树的所有节点都没有左子树
	    //                  1                      
	    //                      \                    
	    //                       3                 
	    //                         \           
	    //                         6
		BinaryTreeNode node21 = new BinaryTreeNode(1);
		BinaryTreeNode node23 = new BinaryTreeNode(3);
		BinaryTreeNode node26 = new BinaryTreeNode(6);
		
		setBinaryTreeNode(node21, null, node23);
		setBinaryTreeNode(node23, null, node26);
		
		System.out.println(of39.treeDepth(node21));
		
		//功能测试
		 // 03.二叉树的所有节点都没有右子树
	    //                 1                     
	    //              /                             
	    //             2                             
	    //           /                                   
	    //          4  
		BinaryTreeNode node31 = new BinaryTreeNode(1);
		BinaryTreeNode node32 = new BinaryTreeNode(2);
		BinaryTreeNode node34 = new BinaryTreeNode(4);
		
		setBinaryTreeNode(node31, node32, null);
		setBinaryTreeNode(node32, node34, null);
		
		System.out.println(of39.treeDepth(node31));
		
		//特殊输入测试
		 // 04.只有一个节点的二叉树
	    //                  1
		BinaryTreeNode node41 = new BinaryTreeNode(1);
		
		setBinaryTreeNode(node41, null, null);
		
		System.out.println(of39.treeDepth(node41));
		
		//特殊输入测试，5
		//指向二叉树的根节点的指针为NULL
		BinaryTreeNode node51 = null;
		System.out.println(of39.treeDepth(node51));
		*/
		
		//功能测试，1，平衡的二叉树
		//            1
		//         /      \
		//        2        3
		//       /\         \
		//      4  5         6
		//        /
		//       7
		BinaryTreeNode node11 = new BinaryTreeNode(1);
		BinaryTreeNode node12 = new BinaryTreeNode(2);
		BinaryTreeNode node13 = new BinaryTreeNode(3);
		BinaryTreeNode node14 = new BinaryTreeNode(4);
		BinaryTreeNode node15 = new BinaryTreeNode(5);
		BinaryTreeNode node16 = new BinaryTreeNode(6);
		BinaryTreeNode node17 = new BinaryTreeNode(7);
		
		setBinaryTreeNode(node11, node12, node13);
		setBinaryTreeNode(node12, node14, node15);
		setBinaryTreeNode(node15, node17, null);
		setBinaryTreeNode(node13, null, node16);
		
		//System.out.println(of39.isBalanced(node11));
		System.out.println(of39.isBalanced2(node11).getIsBalanced());
		
		//功能测试，2，不平衡的二叉树
		//            1
		//         /      \
		//        2        3
		//       /\         \
		//      4  5         6
		//        /
		//       7
		//      /
		//     8
		BinaryTreeNode node21 = new BinaryTreeNode(1);
		BinaryTreeNode node22 = new BinaryTreeNode(2);
		BinaryTreeNode node23 = new BinaryTreeNode(3);
		BinaryTreeNode node24 = new BinaryTreeNode(4);
		BinaryTreeNode node25 = new BinaryTreeNode(5);
		BinaryTreeNode node26 = new BinaryTreeNode(6);
		BinaryTreeNode node27 = new BinaryTreeNode(7);
		BinaryTreeNode node28 = new BinaryTreeNode(8);
		
		setBinaryTreeNode(node21, node22, node23);
		setBinaryTreeNode(node22, node24, node25);
		setBinaryTreeNode(node25, node27, null);
		setBinaryTreeNode(node27, node28, null);
		setBinaryTreeNode(node23, null, node26);
		
		//System.out.println(of39.isBalanced(node21));
		System.out.println(of39.isBalanced2(node21).getIsBalanced());
		
		//功能测试
		 // 03.二叉树的所有节点都没有右子树
	    //                 1                     
	    //              /                             
	    //             2                             
	    //           /                                   
	    //          4  
		BinaryTreeNode node31 = new BinaryTreeNode(1);
		BinaryTreeNode node32 = new BinaryTreeNode(2);
		BinaryTreeNode node34 = new BinaryTreeNode(4);
		
		setBinaryTreeNode(node31, node32, null);
		setBinaryTreeNode(node32, node34, null);
		
		//System.out.println(of39.isBalanced(node31));
		System.out.println(of39.isBalanced2(node31).getIsBalanced());
		
		//功能测试
		 // 04.二叉树的所有节点都没有左子树
	    //                  1                      
	    //                      \                    
	    //                       3                 
	    //                         \           
	    //                         6
		BinaryTreeNode node41 = new BinaryTreeNode(1);
		BinaryTreeNode node43 = new BinaryTreeNode(3);
		BinaryTreeNode node46 = new BinaryTreeNode(6);
		
		setBinaryTreeNode(node41, null, node43);
		setBinaryTreeNode(node43, null, node46);
		
		//System.out.println(of39.isBalanced(node41));
		System.out.println(of39.isBalanced2(node41).getIsBalanced());
		
		//特殊输入测试
		 // 05.只有一个节点的二叉树
	    //                  1
		BinaryTreeNode node51 = new BinaryTreeNode(1);
		
		setBinaryTreeNode(node51, null, null);
		
		//System.out.println(of39.isBalanced(node51));
		System.out.println(of39.isBalanced2(node51).getIsBalanced());
		
		//特殊输入测试，6
		//指向二叉树的根节点的指针为NULL
		BinaryTreeNode node61 = null;
		//System.out.println(of39.isBalanced(node61));
		System.out.println(of39.isBalanced2(node61).getIsBalanced());
	}
}
