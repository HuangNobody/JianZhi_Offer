public class Offer41 {

	//����1
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
			System.out.println("������û���ҵ���Ϊ"+sum+"��������");
		return found;
	}
	
	//����2
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
		//���ܲ��ԣ�1�������д��ں�ΪS��������
		int [] data = {1,2,4,7,11,15};
		int sum = 15;
		of41.findNumbersWithSum(data, sum);
		
		//���ܲ��ԣ�2�������в����ں�Ϊs��������
		int [] data2 = {1,2,4,7,15,17};
		int sum2 = 15;
		of41.findNumbersWithSum(data2, sum2);
		
		//����������ԣ�3����ʾ�����ָ��ΪNULL
		int [] data3 = null;
		int sum3 = 15;
		of41.findNumbersWithSum(data3, sum3);
		*/
		
		//���ܲ��� ��1�����ں�Ϊs ���������У���9
		int sum1 = 9;
		of41.findContinuousSequence(sum1);
		System.out.println();
		
		//���ܲ��� ��2�����ں�Ϊs ���������У���100
		int sum2 = 100;
		of41.findContinuousSequence(sum2);
		System.out.println();
		
		//���ܲ��� ��3�������ں�Ϊs ���������У���4
		int sum3 = 4;
		of41.findContinuousSequence(sum3);
		System.out.println();
		
		//���ܲ��� ��4�������ں�Ϊs ���������У���0
		int sum4 = 0;
		of41.findContinuousSequence(sum4);
		System.out.println();
		
		//�߽�ֵ���ԣ�5���������е���С��Ϊ3
		int sum5 = 3;
		of41.findContinuousSequence(sum5);
		System.out.println();
		
		
		
	}
}
