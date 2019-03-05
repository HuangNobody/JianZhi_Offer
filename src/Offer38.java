public class Offer38 {

	public int getFirstK(int [] data, int k, int start, int end){
		if(start>end)
			return -1;//闭区间
		int mid = start+(end-start)/2;
		
		if(data[mid] == k){
			if((mid>0 && data[mid-1]!=k) || mid ==0)
					return mid;
			end = mid-1;
		}else if(data[mid]>k)
			end = mid -1;
		else
			start = mid+1;
		
		return getFirstK(data, k, start, end);
	}
	
	public int getLastK(int [] data, int k, int start, int end){
		if(start>end)
			return -1;
		
		int mid = start+((end-start)>>1);
		
		if(data[mid] == k){
			if((mid<end&& data[mid+1]!=k) || mid == end)
				return mid;
			start = mid+1;
		}else if(data[k] <k)
			start =mid +1;
		else
			end = mid-1;
		
		return getLastK(data, k, start, end);
	}
	
	public int getNumberOfK(int [] data, int length, int k){
		if(data == null || length <=0)
			return 0;
		int number = 0;
		int start = 0;
		int end = length-1;
		int firstK = getFirstK(data, k, 0, length-1);
		int lastK = getLastK(data, k, 0, length-1);
		if(firstK >-1 && lastK>-1)
			number = lastK-firstK+1;
		return number;
	}
	
	public static void main(String[] args) {
		
		Offer38 of38 = new Offer38();
		
		//功能测试，1，数组中包含查找的数字，出现多次
		int [] data1 = {1,2,3,3,3,3,4,5};
		int k1 = 3;
		int length1 = data1.length;
		System.out.println("测试1，"+k1+"出现的次数： "+of38.getNumberOfK(data1, length1, k1));
		
		//功能测试，2，数组中没有查找的数字
		int [] data2 = {1,2,3,3,3,3,4,5};
		int k2 = 6;
		int length2 = data2.length;
		System.out.println("测试2，"+k2+"出现的次数： "+of38.getNumberOfK(data2, length2, k2));
		
		//功能测试，3，数组中包含查找的数字，出现多次
		int [] data3 = {1,2,3,3,3,3,4,5};
		int k3 = 5;
		int length3 = data3.length;
		System.out.println("测试3，"+k3+"出现的次数： "+of38.getNumberOfK(data3, length3, k3));
		
		//边界值测试，4，查找数组中的最大值
		int [] data4 = {1,2,3,3,3,3,4,5};
		int k4 = 5;
		int length4 = data4.length;
		System.out.println("测试4，"+k4+"出现的次数： "+of38.getNumberOfK(data4, length4, k4));
		
		//边界值测试，5，查找数组中的最小值
		int [] data5 = {1,2,3,3,3,3,4,5};
		int k5 = 1;
		int length5 = data5.length;
		System.out.println("测试5，"+k5+"出现的次数： "+of38.getNumberOfK(data5, length5, k5));
		
		//边界值测试，6，数组中只有数字
		int [] data6 = {7};
		int k6 = 7;
		int length6 = data6.length;
		System.out.println("测试6，"+k6+"出现的次数： "+of38.getNumberOfK(data6, length6, k6));
		
		//特殊输入测试，7，表示数组的指针为NULL
		//int [] data7 = null;
		//int k7 = 7;
		//int length7 = data7.length;
		//System.out.println("测试6，"+k6+"出现的次数： "+of38.getNumberOfK(data7, length7, k7));

	}

}
