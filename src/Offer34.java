public class Offer34 {

	//方法1，每个数字都要计算一遍 ，时间效率低
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
	
	//方法2，空间换时间
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
			 while(uglyArray[multiply2]*2 == uglyArray[i] )//也可以是<=
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
		
		//功能测试，1，输入2
		int index11 = 2;
		//System.out.println("第"+index11+"个丑数是： "+of34.getUglyNumber(index11));
		System.out.println("第"+index11+"个丑数是： "+of34.getUglyNumber_2(index11));
		
		//功能测试，2，输入3
		int index21 = 3;
		//System.out.println("第"+index21+"个丑数是： "+of34.getUglyNumber(index21));
		System.out.println("第"+index21+"个丑数是： "+of34.getUglyNumber_2(index21));
		
		//功能测试，3，输入4
		int index31 = 4;
		//System.out.println("第"+index31+"个丑数是： "+of34.getUglyNumber(index31));
		System.out.println("第"+index31+"个丑数是： "+of34.getUglyNumber_2(index31));
		
		//功能测试，4，输入5
		int index41 = 5;
		//System.out.println("第"+index41+"个丑数是： "+of34.getUglyNumber(index41));
		System.out.println("第"+index41+"个丑数是： "+of34.getUglyNumber_2(index41));
		
		//功能测试，5，输入6
		int index51 = 6;
		//System.out.println("第"+index51+"个丑数是： "+of34.getUglyNumber(index51));
		System.out.println("第"+index51+"个丑数是： "+of34.getUglyNumber_2(index51));
		
		//特殊输入测试，6，边界值1
		int index61 = 1;
		//System.out.println("第"+index61+"个丑数是： "+of34.getUglyNumber(index61));
		System.out.println("第"+index61+"个丑数是： "+of34.getUglyNumber_2(index61));
		
		//特殊输入测试，7，边界值0
		int index71 = 0;
		//System.out.println("第"+index71+"个丑数是： "+of34.getUglyNumber(index71));
		System.out.println("第"+index71+"个丑数是： "+of34.getUglyNumber_2(index71));
		
		//性能测试，8，1500
		int index81 = 1500;
		//System.out.println("第"+index81+"个丑数是： "+of34.getUglyNumber(index81));
		System.out.println("第"+index81+"个丑数是： "+of34.getUglyNumber_2(index81));

	}

}
