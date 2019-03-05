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
		
		int i = mid;//i初始化为前半段最后一个数字的下标
		int j = end;//j初始化为后半段最后一个数字的下标
		int index = end;//辅助数组复制的数组的最后一个数字的下标
		int count = 0;//计数--逆序对的数目
		
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
		
		//功能测试，1，输入未经排序的数组
		int [] array1 ={7,5,6,4};
		System.out.println(inversePairs(array1));
		
		//功能测试，2，输入递增排序的数组
		int [] array2 ={4,5,6,7};
		System.out.println(inversePairs(array2));
		
		//功能测试，3，输入递减排序的数组
		int [] array3 ={7,6,5,4};
		System.out.println(inversePairs(array3));
		
		//功能测试，4，输入的数组中有重复数字
		int [] array4 ={7,5,6,5};
		System.out.println(inversePairs(array4));
		
		//边界值测试，5，输入的数组中只有两个数字
		int [] array5 ={7,5};
		System.out.println(inversePairs(array5));
		
		//边界值测试，6，输入的数组中只有两个数字
		int [] array6 ={7};
		System.out.println(inversePairs(array6));
		
		//特殊输入测试，表示数组的指针为NULL
		int [] array7 =null;
		System.out.println(inversePairs(array7));

	}

}
