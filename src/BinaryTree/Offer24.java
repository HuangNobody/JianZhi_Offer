package BinaryTree;
public class Offer24 {

	public boolean VerifySequenceOfBST(int [] sequence, int start, int end){
		if(sequence == null || sequence.length == 0)
			return false;
		if(start<0 || end >sequence.length)
			return false;
		int root = sequence[end];
		
		//�ڶ������������������Ľڵ�С�ڸ��ڵ�
		int i = start;
		for(;i<end;i++){
			if(sequence[i]>root)
				break;
		}
		
		//�ڶ������������������Ľڵ���ڸ��ڵ�
		int j = i;
		for(; j<end;j++){
			if(sequence[j]<root)
				return false;
		}
		
		//�ж��������ǲ��Ƕ���������
		boolean left = true;
		if(i>start)
			left = VerifySequenceOfBST(sequence, start, i-1);
		
		//�ж��������ǲ��Ƕ���������
		boolean right = true;
		if(j<end)
			right = VerifySequenceOfBST(sequence, i,end-1);
			
		return left&&right;
	}
	
	public static void main(String[] args) {
		Offer24 of24 = new Offer24();
		
		//���ܲ��ԣ�1 ����ĺ�����������ж�Ӧһ����ȫ������
		//      			8                     
		//              /       \               
		//             6         10           
		//           /   \     /   \        
		//          5     7   9    11  
		int [] arr1 = {5,7,6,9,11,8};
		System.out.println(of24.VerifySequenceOfBST(arr1, 0, 5));
		
		//���ܲ���
		 // 02.�����������нڵ㶼û��������
	    //                  8                      
	    //                      \                    
	    //                       10                 
	    //                         \           
	    //                         11        
		int [] arr2 = {11,10,8};
		System.out.println(of24.VerifySequenceOfBST(arr2, 0, 2));
		
		//���ܲ���
		 // 03.�����������нڵ㶼û��������
	    //                  8                      
	    //              /                             
	    //             6                              
	    //           /                                   
	    //          5     
		int [] arr3 = {5,6,8};
		System.out.println(of24.VerifySequenceOfBST(arr3, 0, 2));
		
		//���ܲ���
		 // 04.ֻ��һ���ڵ�Ķ�����
	    //                  8 
		int [] arr4 = {5};
		System.out.println(of24.VerifySequenceOfBST(arr4, 0, 0));
		
		//���ܲ���
		 // 05.����ĺ������������û��һ����Ӧ�Ķ�����
		int [] arr5 = {7,4,6,5};
		System.out.println(of24.VerifySequenceOfBST(arr5, 0, 3));
		
		//�����������
		//ָ�����������е�ָ��ΪNULL
		int [] arr6 = null;
		System.out.println(of24.VerifySequenceOfBST(arr6, 0, 0));

	}

}
