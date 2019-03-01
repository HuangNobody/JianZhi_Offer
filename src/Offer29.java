

public class Offer29 {
	
	//ѡ��partition����
	public int partition(int [] arr, int left, int right){
		int result = arr[left];
		if(left>right)
			return -1;
		while(left<right){
			while(left<right && arr[right] >= result)
				right--;
			arr[left] = arr[right];
			while(left<right && arr[left] < result)
				left++;
			arr[right] = arr[left];
		}
		arr[left] = result;
		return left;
	}
	
	public int moreThanHalfNum(int [] arr){
		if(arr == null ||arr.length == 0)
			return -1;
		int length = arr.length;
		int middle = length >>1;
		int start = 0;
		int end = length-1;
		int index = partition(arr, start, end);
		while(index != middle){
			if(index > middle){
				end = index-1;
				index = partition(arr, start, end);
			}else{
				start = index+1;
				index = partition(arr, start, end);
			}
		}
		
		int result = arr[middle];
		if(!checkMoreThanHalf(arr, result))
			result = -1;
		
		return result;
	}
	
	public boolean checkMoreThanHalf(int[] arr, int result) {
		int times = 0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i] == result)
				times++;
		}
		boolean isMoreThanHalf = true;
		if(times*2<=arr.length)
			isMoreThanHalf = false;
		
		return isMoreThanHalf;
	}
	
	//����2
	public int moreThanHalfNum_2(int [] arr){
		if(arr == null || arr.length == 0)
			return -1;
		int result = arr[0];
		int times = 1;
		for(int i = 0;i<arr.length;i++){
			if(times == 0){
				result = arr[i];
				times = 1;
			}else if(arr[i] == result)
				times++;
			else
				times--;
		}
		if(!checkMoreThanHalf(arr, result))
			result = -1;
		
		return result;
	}

	public static void main(String[] args) {
		
		Offer29 of29 = new Offer29();
		
		//���ܲ��ԣ�1������������д���һ�����ִ����������鳤��һ�������
		int [] arr11 = {1,2,3,2,2,2,5,4,2};
		//System.out.println(of29.moreThanHalfNum(arr11));
		System.out.println(of29.moreThanHalfNum_2(arr11));
		
		//���ܲ��ԣ�2������������в�����һ�����ִ����������鳤��һ�������
		int [] arr21 = {1,2,3,2,1,3,5,4,2};
		//System.out.println(of29.moreThanHalfNum(arr21));
		System.out.println(of29.moreThanHalfNum_2(arr21));
		
		//����������ԣ�3�������������ֻ��һ������
		int [] arr31 = {1};
		//System.out.println(of29.moreThanHalfNum(arr31));
		System.out.println(of29.moreThanHalfNum_2(arr31));
		
		//����������ԣ�3������NULLָ��
		int [] arr41 = null;
		//System.out.println(of29.moreThanHalfNum(arr41));
		System.out.println(of29.moreThanHalfNum_2(arr41));

	}

}
