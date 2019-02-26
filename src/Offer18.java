
public class Offer18 {
	
	public static class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(){}
		
		BinaryTreeNode(int value){
			this.value = value;
		}
		
		BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right){
			this.value = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root1 == null || root2 == null)
			return false;
		
		boolean result = false;
		
		if(root1 != null && root2 != null){
			if(root1.value == root2.value)
				result = doesTree1HaveTree2(root1, root2);
			if(!result)
				result = hasSubTree(root1.left,root2);
			if(!result)
				result = hasSubTree(root1.right, root2);
		}
		return result;
	}
	
	public boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root2 == null)//如果root2都检查完了，都匹配，则返回true
			return true;
		if(root1 == null) //如果root1都检查完了，不匹配，则返回false
			return false;
		if(root1.value != root2.value)
			return false;
		
		return doesTree1HaveTree2(root1.left, root2.left)&&doesTree1HaveTree2(root1.right, root2.right);
	}
	
	//为了使方便测试，这里封装了一个设置指定根节点的左孩子和右孩子节点的方法：
	public static void setSubTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
		if(root == null)
			return;
		root.left = left;
		root.right = right;
	}

	public static void main(String[] args) {
		Offer18 of18 = new Offer18();
		//功能测试
		 // 01.树中结点含有分叉，树B是树A的子结构
	    //                  8                8
	    //              /       \           / \
	    //             8         7         9   2
	    //           /   \
	    //          9     2
	    //               / \
	    //              4   7
		BinaryTreeNode nodeA11 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA12 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA13 = new BinaryTreeNode(7);
		BinaryTreeNode nodeA14 = new BinaryTreeNode(9);
		BinaryTreeNode nodeA15 = new BinaryTreeNode(2);
		BinaryTreeNode nodeA16 = new BinaryTreeNode(4);
		BinaryTreeNode nodeA17 = new BinaryTreeNode(7);
		
		setSubTreeNode(nodeA11, nodeA12, nodeA13);
		setSubTreeNode(nodeA12, nodeA14, nodeA15);
		setSubTreeNode(nodeA15, nodeA16, nodeA17);
		
		BinaryTreeNode nodeB11 = new BinaryTreeNode(8);
		BinaryTreeNode nodeB12 = new BinaryTreeNode(9);
		BinaryTreeNode nodeB13 = new BinaryTreeNode(2);
		
		setSubTreeNode(nodeB11, nodeB12, nodeB13);
		
		System.out.println("情况1： "+of18.hasSubTree(nodeA11, nodeB11));
		
		// 02.树中结点含有分叉，树B不是树A的子结构
	    //                  8                8
	    //              /       \           / \
	    //             8         7         9   2
	    //           /   \
	    //          9     3
	    //               / \
	    //              4   7
		//注意如果创建使用函数二叉树，则必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，
		//而初始化是按顺序初始化的，不逆序建立会报错；如果不适用函数创建二叉树，像下面这样做，不必用逆序建立
		BinaryTreeNode nodeA27 = new BinaryTreeNode(7,null,null);
		BinaryTreeNode nodeA26 = new BinaryTreeNode(4,null, null);
		BinaryTreeNode nodeA25 = new BinaryTreeNode(3, nodeA26, nodeA27);
		BinaryTreeNode nodeA24 = new BinaryTreeNode(9, null, null);
		BinaryTreeNode nodeA23 = new BinaryTreeNode(7, null, null);
		BinaryTreeNode nodeA22 = new BinaryTreeNode(8, nodeA24, nodeA25);
		BinaryTreeNode nodeA21 = new BinaryTreeNode(8, nodeA22, nodeA23);
		
		BinaryTreeNode nodeB23 = new BinaryTreeNode(2, null, null);
		BinaryTreeNode nodeB22 = new BinaryTreeNode(9, null, null);
		BinaryTreeNode nodeB21 = new BinaryTreeNode(8, nodeB22, nodeB23);
		
		System.out.println("情况2： "+of18.hasSubTree(nodeA21, nodeB21));
		
		//特殊输入测试
		 // 03.树中结点只有左子结点，树B是树A的子结构
	    //                8                  8
	    //              /                   / 
	    //             8                   9   
	    //           /                    /
	    //          9                    2
	    //         /      
	    //        2        
	    //       /
	    //      5
		BinaryTreeNode nodeA31 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA32 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA33 = new BinaryTreeNode(9);
		BinaryTreeNode nodeA34 = new BinaryTreeNode(2);
		BinaryTreeNode nodeA35 = new BinaryTreeNode(5);
		
		nodeA31.left = nodeA32;
		nodeA32.left = nodeA33;
		nodeA33.left = nodeA34;
		nodeA34.left = nodeA35;
		
		BinaryTreeNode nodeB31 = new BinaryTreeNode(8);
		BinaryTreeNode nodeB32 = new BinaryTreeNode(9);
		BinaryTreeNode nodeB33 = new BinaryTreeNode(2);
		
		nodeB31.left = nodeB32;
		nodeB32.left = nodeB33;
		
		System.out.println("情况3： "+of18.hasSubTree(nodeA31, nodeB31));
		
		 // 04.树中结点只有左子结点，树B不是树A的子结构
	    //                8                  8
	    //              /                   / 
	    //             8                   9   
	    //           /                    /
	    //          9                    3
	    //         /      
	    //        2        
	    //       /
	    //      5
		BinaryTreeNode nodeA41 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA42 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA43 = new BinaryTreeNode(9);
		BinaryTreeNode nodeA44 = new BinaryTreeNode(2);
		BinaryTreeNode nodeA45 = new BinaryTreeNode(5);
		
		nodeA41.left = nodeA42;
		nodeA42.left = nodeA43;
		nodeA43.left = nodeA44;
		nodeA44.left = nodeA45;
		
		BinaryTreeNode nodeB41 = new BinaryTreeNode(8);
		BinaryTreeNode nodeB42 = new BinaryTreeNode(9);
		BinaryTreeNode nodeB43 = new BinaryTreeNode(3);
		
		nodeB41.left = nodeB42;
		nodeB42.left = nodeB43;
		
		System.out.println("情况4： "+of18.hasSubTree(nodeA41, nodeB41));
		
		// 05.树中结点只有右子结点，树B是树A的子结构
	    //       8                   8
	    //        \                   \ 
	    //         8                   9   
	    //          \                   \
	    //           9                   2
	    //            \      
	    //             2        
	    //              \
	    //               5
		BinaryTreeNode nodeA51 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA52 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA53 = new BinaryTreeNode(9);
		BinaryTreeNode nodeA54 = new BinaryTreeNode(2);
		BinaryTreeNode nodeA55 = new BinaryTreeNode(5);
		
		nodeA51.right = nodeA52;
		nodeA52.right = nodeA53;
		nodeA53.right = nodeA54;
		nodeA54.right = nodeA55;
		
		BinaryTreeNode nodeB51 = new BinaryTreeNode(8);
		BinaryTreeNode nodeB52 = new BinaryTreeNode(9);
		BinaryTreeNode nodeB53 = new BinaryTreeNode(2);
		
		nodeB51.right = nodeB52;
		nodeB52.right = nodeB53;
		
		System.out.println("情况5： "+of18.hasSubTree(nodeA51, nodeB51));
		
		// 06.树中结点只有右子结点，树B不是树A的子结构
	    //       8                   8
	    //        \                   \ 
	    //         8                   9   
	    //          \                 / \
	    //           9               3   2
	    //            \      
	    //             2        
	    //              \
	    //               5
		BinaryTreeNode nodeA61 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA62 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA63 = new BinaryTreeNode(9);
		BinaryTreeNode nodeA64 = new BinaryTreeNode(2);
		BinaryTreeNode nodeA65 = new BinaryTreeNode(5);
		
		nodeA61.right = nodeA62;
		nodeA62.right = nodeA63;
		nodeA63.right = nodeA64;
		nodeA64.right = nodeA65;
		
		BinaryTreeNode nodeB61 = new BinaryTreeNode(8);
		BinaryTreeNode nodeB62 = new BinaryTreeNode(9);
		BinaryTreeNode nodeB63 = new BinaryTreeNode(3);
		BinaryTreeNode nodeB64 = new BinaryTreeNode(2);
		
		nodeB61.right = nodeB62;
		setSubTreeNode(nodeB62, nodeB63, nodeB64);
		
		System.out.println("情况6： "+of18.hasSubTree(nodeA61, nodeB61));
		
		// 07.树A为空树
		BinaryTreeNode nodeB71 = new BinaryTreeNode(8);
		BinaryTreeNode nodeB72 = new BinaryTreeNode(9);
		BinaryTreeNode nodeB73 = new BinaryTreeNode(3);
		BinaryTreeNode nodeB74 = new BinaryTreeNode(2);
		
		nodeB71.right = nodeB72;
		setSubTreeNode(nodeB72, nodeB73, nodeB74);
		
		System.out.println("情况7： "+of18.hasSubTree(null, nodeB71));
		
		 // 08.树B为空树
		BinaryTreeNode nodeA81 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA82 = new BinaryTreeNode(8);
		BinaryTreeNode nodeA83 = new BinaryTreeNode(9);
		BinaryTreeNode nodeA84 = new BinaryTreeNode(2);
		BinaryTreeNode nodeA85 = new BinaryTreeNode(5);
		
		nodeA81.right = nodeA82;
		nodeA82.right = nodeA83;
		nodeA83.right = nodeA84;
		nodeA84.right = nodeA85;
		
		System.out.println("情况8： "+of18.hasSubTree(nodeA81, null));
		
		// 09.树A和树B都为空树
		System.out.println("情况9： "+of18.hasSubTree(null, null));
		
		
	}
}
