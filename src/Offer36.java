public class Offer36 {
	
	public static int inversePairs(int [] array){
		if(array == null|| array.length<=1){
			return 0;
		}
		int [] copy = new int[array.length];
		for(int i = 0;i<array.length;i++)
			copy[i] = array[i];
		return mergeCount(array, copy, 0, array.length-1);
	}
	
	
	public static int mergeCount(int[] array, int[] copy, int start, int end) {
		if(start == end){
			copy[start] = array[start];
			return 0;
		}
		int mid = (start+end)>>1;
		int leftCount = mergeCount(copy, array, start, mid);
		int rightCount = mergeCount(copy, array, mid+1, end);
		
		int i = mid;//i��ʼ��Ϊǰ������һ�����ֵ��±�
		int j = end;//j��ʼ��Ϊ�������һ�����ֵ��±�
		int index = end;//�������鸴�Ƶ���������һ�����ֵ��±�
		int count = 0;//����--����Ե���Ŀ
		
		while(i>=start && j>= mid+1){
			if(array[i]>array[j]){
				copy[index--] = array[i--];
				count += j-mid;
			}else
				copy[index--] = array[j--];
		}
		
		for(;i>=start;i--)
			copy[index--] = array[i];
		for(;j>=mid+1;j--)
			copy[index--] = array[j];
		
		return count+leftCount+rightCount;
	}

	public static void main(String[] args) {
		
		//���ܲ��ԣ�1������δ�����������
		int [] array1 ={7,5,6,4};
		System.out.println(inversePairs(array1));
		
		//���ܲ��ԣ�2������������������
		int [] array2 ={4,5,6,7};
		System.out.println(inversePairs(array2));
		
		//���ܲ��ԣ�3������ݼ����������
		int [] array3 ={7,6,5,4};
		System.out.println(inversePairs(array3));
		
		//���ܲ��ԣ�4����������������ظ�����
		int [] array4 ={7,5,6,5};
		System.out.println(inversePairs(array4));
		
		//�߽�ֵ���ԣ�5�������������ֻ����������
		int [] array5 ={7,5};
		System.out.println(inversePairs(array5));
		
		//�߽�ֵ���ԣ�6�������������ֻ����������
		int [] array6 ={7};
		System.out.println(inversePairs(array6));
		
		//����������ԣ���ʾ�����ָ��ΪNULL
		int [] array7 =null;
		System.out.println(inversePairs(array7));

	}

}
