public class Offer41 {

	//问题1
	public boolean findNumbersWithSum(int [] data, int sum){
		boolean found = false;
		if(data == null || data.length<=0){
			System.out.println("invalid input");
			return found;
		}
		
		int left = 0;
		int right = data.length-1;
		//int num1 = 0;
		//int num2 = 0;
		while(left<right){
			int curSum = data[left]+data[right];
			if(curSum == sum){
				//num1 = data[left];
				//num2 = data[right];
				System.out.println(data[left]+" + "+data[right]+" = "+ sum);
				found = true;
				break;
			}else if(curSum > sum)
				right--;
			else
				left++;
		}
		//System.out.print(num1);
		//System.out.print(num2);
		if(!found)
			System.out.println("数组中没有找到和为"+sum+"的两个数");
		return found;
	}
	
	//问题2
	public void findContinuousSequence(int sum){
		boolean found = false;
		if(sum<3)
			return;
		int small = 1;
		int big = 2;
		int middle = (1+sum)/2;
		int curSum = small +big;
		
		while(small < middle){
			if(curSum == sum)
				printContinusSequence(small, big);
			while(small < big && curSum > sum){
				curSum -= small;
				small++;
				
				if(curSum == sum)
					printContinusSequence(small, big);
			}
			
			big++;
			curSum += big;
		}
	}
	
	public void printContinusSequence(int small, int big) {
		for(int i =small;i<= big;i++)
			System.out.print(i+"  ");
		System.out.println();
	}

	public static void main(String[] args) {
		
		Offer41 of41 = new Offer41();
		/*
		//功能测试，1，数组中存在和为S的两个数
		int [] data = {1,2,4,7,11,15};
		int sum = 15;
		of41.findNumbersWithSum(data, sum);
		
		//功能测试，2，数组中不存在和为s的两个数
		int [] data2 = {1,2,4,7,15,17};
		int sum2 = 15;
		of41.findNumbersWithSum(data2, sum2);
		
		//特殊输入测试，3，表示数组的指针为NULL
		int [] data3 = null;
		int sum3 = 15;
		of41.findNumbersWithSum(data3, sum3);
		*/
		
		//功能测试 ，1，存在和为s 的连续序列，如9
		int sum1 = 9;
		of41.findContinuousSequence(sum1);
		System.out.println();
		
		//功能测试 ，2，存在和为s 的连续序列，如100
		int sum2 = 100;
		of41.findContinuousSequence(sum2);
		System.out.println();
		
		//功能测试 ，3，不存在和为s 的连续序列，如4
		int sum3 = 4;
		of41.findContinuousSequence(sum3);
		System.out.println();
		
		//功能测试 ，4，不存在和为s 的连续序列，如0
		int sum4 = 0;
		of41.findContinuousSequence(sum4);
		System.out.println();
		
		//边界值测试，5，连续序列的最小和为3
		int sum5 = 3;
		of41.findContinuousSequence(sum5);
		System.out.println();
		
		
		
	}
}
