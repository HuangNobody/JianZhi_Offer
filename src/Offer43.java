public class Offer43 {

	private static final int maxValue = 6;
	//����1�� �ݹ飬Ч�ʵ�
	public static void printProbability(int number){
		if(number <1)
			return ;
		int maxSum = number * maxValue;
		int [] probabilities = new int[maxSum - number+1];
		for(int i = number;i <= maxSum;i++)
			probabilities[i-number] = 0;//��ʼ������ʼͳ��֮ǰ��Ϊ0��
		
		double total = Math.pow(maxValue, number);
		probability(number, probabilities);
		//probability(number,pProbabilities);�����������n~6nÿ��������ֵĴ���
		for(int i = number;i<=maxSum;i++){
			double ratio = probabilities[i-number]/total;
			System.out.println("i: "+ i+" ratio: "+ratio);
		}
	}
	
	public static void probability(int number, int[] probabilities) {
		for(int i = 1;i<= maxValue;i++){
			probability(number, number, i, probabilities);
		}
	}

	//�ܹ�original�����ӣ���ǰ�� current�����ӣ���ǰ�ĺͣ��ᴩʼ�յ�����
	public static void probability(int original, int current, int sum,int[] probabilities) {
		if(current == 1)
			probabilities[sum-original]++;
		else
			for(int i = 1;i<=maxValue;i++)
				probability(original, current-1, sum+i, probabilities);
	}
	
	//����2�� ����ѭ�������ܺ�
	public void printProbability_2(int number){
		if(number<1)
			return;
		int [][] probabilities = new int[2][maxValue* number+1];
		for(int i = 0;i<maxValue;i++){//��ʼ������
			probabilities[0][i] = 0;
			probabilities[1][i] = 0;
		}
		int flag = 0;
		for(int i = 1;i<=maxValue;i++){//����һ����������ʱ����6�ֿ��ܣ�ÿ�ֿ��ܳ���һ��
			probabilities[flag][i] = 1;
		}
		//�ӵڶ��ο�ʼ�����ӣ������һ�������еĵ�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ�����
		//����һѭ���У����Ǽ���һ�������ӣ���ʱ��Ϊn�����ӳ��ִ���Ӧ�õ�����һ��ѭ�������ӵ�����Ϊn-1,n-2,n-3,n-4,n-5��
		//n-6�Ĵ����ܺͣ��������ǰ���һ������ĵ�n��������Ϊǰһ�������Ӧ��n-1,n-2,n-3,n-4,n-5��n-6֮��
		for(int k = 2;k<= number;k++){
			for(int i = 0;i<k;i++)//��k�������ӣ�����СΪk��С��k������ǲ����ܷ����ģ����������ܷ����Ĵ�������Ϊ0��
				probabilities[1-flag][i] = 0;
			for(int i =k;i<= maxValue*k;i++){//��k�������ӣ�����СΪk�����Ϊg_maxValue*k
				probabilities[1-flag][i] = 0;//��ʼ������Ϊ�������Ҫ�ظ�ʹ�ã���һ�ε�ֵҪ��0
				for(int j = 1;j<=i && j<=maxValue;j++)
					probabilities[1-flag][i] += probabilities[flag][i-j];
			}
			flag = 1-flag;
		}
		
		double total = Math.pow(maxValue, number);
		for(int i = number;i<=maxValue*number;i++){
			double ratio = probabilities[flag][i]/total;
			System.out.println("sum: "+i+"ratio�� "+ratio);
		}
	}

	public static void main(String[] args) {
		
		Offer43 of43 = new Offer43();
		
		//���ܲ��ԣ�1��1��ɸ�ӵĸ������ĸ���
		int number1 = 1;
		//of43.printProbability(number1);
		//of43.printProbability_2(number1);
		
		//���ܲ��ԣ�2��2��ɸ�ӵĸ������ĸ���
		int number2 = 2;
		//of43.printProbability(number2);
		//of43.printProbability_2(number2);
		
		//���ܲ��ԣ�3��2��ɸ�ӵĸ������ĸ���
		int number3 = 3;
		//of43.printProbability(number3);
		//of43.printProbability_2(number3);
		
		
		
		//���ܲ��ԣ�4��2��ɸ�ӵĸ������ĸ���
		int number4 = 4;
		//of43.printProbability(number4);
		//of43.printProbability_2(number4);
		
		//����������ԣ�5������0
		int number5 = 0;
		//of43.printProbability(number5);
		//of43.printProbability_2(number5);
		
		//���ܲ��ԣ�6������Ƚϴ�����֣���11
		int number6 = 11;
		//of43.printProbability(number6);
		of43.printProbability_2(number6);

	}

}
