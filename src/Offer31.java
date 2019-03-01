

public class Offer31 {
	
	private static boolean invalidInput = false;
	
	//����1�������ۼ�
	public int findGreatestSumOfSubArray(int [] array){
		if(array == null || array.length <=0){
			invalidInput = true;
			return 0;
		}
		
		invalidInput = false;
		
		int maxSum = array[0];//�����������
		int curSum = array[0];//�ۼӵ��������
		
		for(int i = 1;i<array.length;i++){
			if(curSum<=0)
				curSum = array[i];
			else
				curSum += array[i];
			
			if(curSum>maxSum)
				maxSum = curSum;
		}
		return maxSum;
	}
	
	//����2����̬�滮
	public int findGreatestSumOfSubArray_2(int [] array){
		if(array == null || array.length <=0){
			invalidInput = true;
			return 0;
		}
		
		invalidInput = false;
		
		int [] curSum = new int[array.length];
		int maxSum = Integer.MIN_VALUE;//0x80000000
		curSum[0] = array[0];
		for(int i = 1;i<array.length;i++){
			if(curSum[i-1] <=0 )
				curSum[i] = array[i];
			else
				curSum[i] = curSum[i-1] + array[i];
			if(curSum[i]<curSum[0])
				curSum[i] = curSum[0];//��Ӧ���԰�������ȫ�Ǹ���������������{-1,-2,-3,-4,-5}û��䣬���-2
			if(curSum[i] >maxSum)
				maxSum = curSum[i];
		}
		return maxSum;
	}
	
	//����3���ݹ�
	public int findGreatestSumOfSubArray_3(int [] array){
		if(array == null || array.length <=0){
			invalidInput = true;
			return 0;
		}
		
		invalidInput = false;
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0;i<array.length;i++){
			sum = Math.max(array[i], array[i]+sum);
			max = Math.max(sum, max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		Offer31 of31 = new Offer31();
		
		//���ܲ��ԣ�1�����������������Ҳ�и���
		int [] arr11 = {1,-2,3,10,-4,7,2,-5};
		//System.out.println(of31.findGreatestSumOfSubArray(arr11));
		//System.out.println(of31.findGreatestSumOfSubArray_2(arr11));
		System.out.println(of31.findGreatestSumOfSubArray_3(arr11));
		
		//���ܲ��ԣ�2�����������ȫ������
		int [] arr21 = {1,2,3,4,5};
		//System.out.println(of31.findGreatestSumOfSubArray(arr21));
		//System.out.println(of31.findGreatestSumOfSubArray_2(arr21));
		System.out.println(of31.findGreatestSumOfSubArray_3(arr21));
		
		//���ܲ��ԣ�3�����������ȫ�Ǹ���
		int [] arr31 = {-1,-2,-3,-4,-5};
		//System.out.println(of31.findGreatestSumOfSubArray(arr31));
		//System.out.println(of31.findGreatestSumOfSubArray_2(arr31));
		System.out.println(of31.findGreatestSumOfSubArray_3(arr31));
		
		//����������ԣ�4,���������ָ��ΪNULL
		int [] arr41 = null;
		//System.out.println(of31.findGreatestSumOfSubArray(arr41));
		//System.out.println(of31.findGreatestSumOfSubArray_2(arr41));
		System.out.println(of31.findGreatestSumOfSubArray_3(arr41));

	}

}
