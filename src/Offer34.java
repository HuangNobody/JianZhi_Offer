public class Offer34 {

	//����1��ÿ�����ֶ�Ҫ����һ�� ��ʱ��Ч�ʵ�
	public boolean isUgly(int number){
		while(number%2==0)
			number /= 2;
		while(number %3 == 0)
			number /= 3;
		while(number %5 == 0)
			number /=5;
		return (number == 1) ? true:false;
	}
	
	public int getUglyNumber(int index){
		if(index <= 0)
			return 0;
		
		int number = 0;
		int uglyFound = 0;
		while(uglyFound <index){
			number++;
			if(isUgly(number))
				uglyFound++;
		}
		return number;
	}
	
	//����2���ռ任ʱ��
	public int getUglyNumber_2(int index){
		if(index <= 0)
			return 0;
		
		int [] uglyArray = new int[index];
		uglyArray[0] = 1;
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		for(int i = 1;i<index;i++){
			int min = min(uglyArray[multiply2]*2, uglyArray[multiply3]*3, uglyArray[multiply5]*5);
			uglyArray[i] = min;
			 while(uglyArray[multiply2]*2 == uglyArray[i] )//Ҳ������<=
				 multiply2++;
			 while(uglyArray[multiply3]*3 ==  uglyArray[i])
				 multiply3++;
			 while(uglyArray[multiply5]*5 == uglyArray[i])
				 multiply5++;
		}
		return uglyArray[index-1];
	}
	
	
	public int min(int number1, int number2, int number3) {
		int min = (number1<number2) ? number1 :number2;
		return min<number3? min:number3;
	}

	public static void main(String[] args) {

		Offer34 of34 = new Offer34();
		
		//���ܲ��ԣ�1������2
		int index11 = 2;
		//System.out.println("��"+index11+"�������ǣ� "+of34.getUglyNumber(index11));
		System.out.println("��"+index11+"�������ǣ� "+of34.getUglyNumber_2(index11));
		
		//���ܲ��ԣ�2������3
		int index21 = 3;
		//System.out.println("��"+index21+"�������ǣ� "+of34.getUglyNumber(index21));
		System.out.println("��"+index21+"�������ǣ� "+of34.getUglyNumber_2(index21));
		
		//���ܲ��ԣ�3������4
		int index31 = 4;
		//System.out.println("��"+index31+"�������ǣ� "+of34.getUglyNumber(index31));
		System.out.println("��"+index31+"�������ǣ� "+of34.getUglyNumber_2(index31));
		
		//���ܲ��ԣ�4������5
		int index41 = 5;
		//System.out.println("��"+index41+"�������ǣ� "+of34.getUglyNumber(index41));
		System.out.println("��"+index41+"�������ǣ� "+of34.getUglyNumber_2(index41));
		
		//���ܲ��ԣ�5������6
		int index51 = 6;
		//System.out.println("��"+index51+"�������ǣ� "+of34.getUglyNumber(index51));
		System.out.println("��"+index51+"�������ǣ� "+of34.getUglyNumber_2(index51));
		
		//����������ԣ�6���߽�ֵ1
		int index61 = 1;
		//System.out.println("��"+index61+"�������ǣ� "+of34.getUglyNumber(index61));
		System.out.println("��"+index61+"�������ǣ� "+of34.getUglyNumber_2(index61));
		
		//����������ԣ�7���߽�ֵ0
		int index71 = 0;
		//System.out.println("��"+index71+"�������ǣ� "+of34.getUglyNumber(index71));
		System.out.println("��"+index71+"�������ǣ� "+of34.getUglyNumber_2(index71));
		
		//���ܲ��ԣ�8��1500
		int index81 = 1500;
		//System.out.println("��"+index81+"�������ǣ� "+of34.getUglyNumber(index81));
		System.out.println("��"+index81+"�������ǣ� "+of34.getUglyNumber_2(index81));

	}

}
