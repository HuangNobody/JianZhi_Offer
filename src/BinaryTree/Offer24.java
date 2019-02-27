package BinaryTree;
public class Offer24 {

	public boolean VerifySequenceOfBST(int [] sequence, int start, int end){
		if(sequence == null || sequence.length == 0)
			return false;
		if(start<0 || end >sequence.length)
			return false;
		int root = sequence[end];
		
		//在二叉搜索树中左子树的节点小于根节点
		int i = start;
		for(;i<end;i++){
			if(sequence[i]>root)
				break;
		}
		
		//在二叉搜索树中右子树的节点大于根节点
		int j = i;
		for(; j<end;j++){
			if(sequence[j]<root)
				return false;
		}
		
		//判断左子树是不是二叉搜索树
		boolean left = true;
		if(i>start)
			left = VerifySequenceOfBST(sequence, start, i-1);
		
		//判断右子树是不是二叉搜索树
		boolean right = true;
		if(j<end)
			right = VerifySequenceOfBST(sequence, i,end-1);
			
		return left&&right;
	}
	
	public static void main(String[] args) {
		Offer24 of24 = new Offer24();
		
		//功能测试，1 输入的后序遍历的序列对应一颗完全二叉树
		//      			8                     
		//              /       \               
		//             6         10           
		//           /   \     /   \        
		//          5     7   9    11  
		int [] arr1 = {5,7,6,9,11,8};
		System.out.println(of24.VerifySequenceOfBST(arr1, 0, 5));
		
		//功能测试
		 // 02.二叉树的所有节点都没有左子树
	    //                  8                      
	    //                      \                    
	    //                       10                 
	    //                         \           
	    //                         11        
		int [] arr2 = {11,10,8};
		System.out.println(of24.VerifySequenceOfBST(arr2, 0, 2));
		
		//功能测试
		 // 03.二叉树的所有节点都没有右子树
	    //                  8                      
	    //              /                             
	    //             6                              
	    //           /                                   
	    //          5     
		int [] arr3 = {5,6,8};
		System.out.println(of24.VerifySequenceOfBST(arr3, 0, 2));
		
		//功能测试
		 // 04.只有一个节点的二叉树
	    //                  8 
		int [] arr4 = {5};
		System.out.println(of24.VerifySequenceOfBST(arr4, 0, 0));
		
		//功能测试
		 // 05.输入的后序遍历的序列没有一个对应的二叉树
		int [] arr5 = {7,4,6,5};
		System.out.println(of24.VerifySequenceOfBST(arr5, 0, 3));
		
		//特殊输入测试
		//指向后序遍历序列的指针为NULL
		int [] arr6 = null;
		System.out.println(of24.VerifySequenceOfBST(arr6, 0, 0));

	}

}
