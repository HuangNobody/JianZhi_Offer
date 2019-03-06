public class Offer43 {

	private static final int maxValue = 6;
	//方法1， 递归，效率低
	public static void printProbability(int number){
		if(number <1)
			return ;
		int maxSum = number * maxValue;
		int [] probabilities = new int[maxSum - number+1];
		for(int i = number;i <= maxSum;i++)
			probabilities[i-number] = 0;//初始化，开始统计之前都为0次
		
		double total = Math.pow(maxValue, number);
		probability(number, probabilities);
		//probability(number,pProbabilities);这个函数计算n~6n每种情况出现的次数
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

	//总共original个骰子，当前第 current个骰子，当前的和，贯穿始终的数组
	public static void probability(int original, int current, int sum,int[] probabilities) {
		if(current == 1)
			probabilities[sum-original]++;
		else
			for(int i = 1;i<=maxValue;i++)
				probability(original, current-1, sum+i, probabilities);
	}
	
	//方法2， 基于循环，性能好
	public void printProbability_2(int number){
		if(number<1)
			return;
		int [][] probabilities = new int[2][maxValue* number+1];
		for(int i = 0;i<maxValue;i++){//初始化数组
			probabilities[0][i] = 0;
			probabilities[1][i] = 0;
		}
		int flag = 0;
		for(int i = 1;i<=maxValue;i++){//当第一次抛掷骰子时，有6种可能，每种可能出现一次
			probabilities[flag][i] = 1;
		}
		//从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
		//在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
		//n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
		for(int k = 2;k<= number;k++){
			for(int i = 0;i<k;i++)//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
				probabilities[1-flag][i] = 0;
			for(int i =k;i<= maxValue*k;i++){//第k次掷骰子，和最小为k，最大为g_maxValue*k
				probabilities[1-flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
				for(int j = 1;j<=i && j<=maxValue;j++)
					probabilities[1-flag][i] += probabilities[flag][i-j];
			}
			flag = 1-flag;
		}
		
		double total = Math.pow(maxValue, number);
		for(int i = number;i<=maxValue*number;i++){
			double ratio = probabilities[flag][i]/total;
			System.out.println("sum: "+i+"ratio： "+ratio);
		}
	}

	public static void main(String[] args) {
		
		Offer43 of43 = new Offer43();
		
		//功能测试，1，1个筛子的各点数的概率
		int number1 = 1;
		//of43.printProbability(number1);
		//of43.printProbability_2(number1);
		
		//功能测试，2，2个筛子的各点数的概率
		int number2 = 2;
		//of43.printProbability(number2);
		//of43.printProbability_2(number2);
		
		//功能测试，3，2个筛子的各点数的概率
		int number3 = 3;
		//of43.printProbability(number3);
		//of43.printProbability_2(number3);
		
		
		
		//功能测试，4，2个筛子的各点数的概率
		int number4 = 4;
		//of43.printProbability(number4);
		//of43.printProbability_2(number4);
		
		//特殊输入测试，5，输入0
		int number5 = 0;
		//of43.printProbability(number5);
		//of43.printProbability_2(number5);
		
		//性能测试，6，输入比较大的数字，如11
		int number6 = 11;
		//of43.printProbability(number6);
		of43.printProbability_2(number6);

	}

}
