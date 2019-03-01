

public class Offer32 {
	
	//方法1，估计拿不到offer
	private boolean invalidInput = false;
	
	public int numberOf1Between1AndN_1(int n){
		if(n<=0){
			invalidInput = true;
			return 0;
		}
		
		int number = 0;
		for(int i = 1;i<=n;i++){
			number += numberOf1(i);
		}
		
		return number;
	}

	public int numberOf1(int n) {
		int number = 0;
		
		while(n>0){
			if(n%10 == 1)
				number++;
			n = n/10;
		}
		return number;
	}

	//方法2.从数字规律左手
	public int numberOf1Between1AndN(int n){
		if(n<=0)
			return 0;
		String strNumber = String.valueOf(n);//将数字转换成字符串
		int length = strNumber.length();
		int firstDigit = strNumber.charAt(0) - '0';//将字符串转换成数字,Returns the char value at the specified index.
		//只有个位
		if(length == 1 && firstDigit == 0)
			return 0;
		if(length ==1 && firstDigit > 0)
			return 1;
		
		//除首位外，剩下的数字
		String remainedString = strNumber.substring(1);//从1开始到最后的位置，返回一个子字符串；substring(int beginIndex);Returns a new string that is a substring of this string.
		int remainedNumber = Integer.parseInt(remainedString);//字符串转换成十进制数字，parseInt(String s),Parses解析 the string argument as a signed decimal integer.
		
		//1出现在首位的次数
		int countOfFirstDigit;
		if(firstDigit == 1)//如果首位数字等于1，比如从10000~12345，则最高位出现1的次数为2345+1=2346次，
			countOfFirstDigit = remainedNumber +1;//（2）是把除高位外的字符串转化为整数。10000~12345中最高位出现1个次数为除去最高数字滞后于剩下的数字再加1.
		else//（1）1345~21345中，万位上出现1的数字在10000~19999中，有10^4个。如果n的长度为length，则共有10^(length-1)次。
			countOfFirstDigit = (int)Math.pow(10,length-1);
		
		//(length-1):任选一位为1；10^(length0-2):其余位从0-9中选；
		//firstDigit：首位可选的数字
		//除了第一位的数之外，其他位上有1的次数：再把1346~21345分成2段，1346~11346,11236~21346，
		//每一段中除去其中的一个数为1之外，其他的每位均可以取0~9，所以有2*10^3次。即共有first*10^(length-2)次
		
		int countOfOtherDigit = firstDigit *(length -1)*(int)Math.pow(10, length-2);
		
		// 递归求在剩下数字中1出现的次数
		int remainedCount = numberOf1Between1AndN(remainedNumber);
		int result = countOfFirstDigit + countOfOtherDigit + remainedCount;
		return result;
	}
	
	public static void main(String[] args) {
		
		Offer32 of32 = new Offer32();
		
		//功能测试，1，输入5
		//System.out.println(of32.numberOf1Between1AndN(5));
		System.out.println(of32.numberOf1Between1AndN_1(5));
		
		//功能测试，2，输入10
		//System.out.println(of32.numberOf1Between1AndN(10));
		System.out.println(of32.numberOf1Between1AndN_1(10));
		
		//功能测试，3，输入55
		//System.out.println(of32.numberOf1Between1AndN(55));
		System.out.println(of32.numberOf1Between1AndN_1(55));
		
		//功能测试，4，输入99
		//System.out.println(of32.numberOf1Between1AndN(99));
		System.out.println(of32.numberOf1Between1AndN_1(99));
		
		//边界值测试，5，输入0
		//System.out.println(of32.numberOf1Between1AndN(0));
		System.out.println(of32.numberOf1Between1AndN_1(0));
		
		//边界值测试，6，输入1
		//System.out.println(of32.numberOf1Between1AndN(1));
		System.out.println(of32.numberOf1Between1AndN_1(1));
		
		//性能测试，7，输入较大的数字，如10000
		//System.out.println(of32.numberOf1Between1AndN(10000));
		System.out.println(of32.numberOf1Between1AndN_1(10000));
		
		//性能测试，8，输入较大的数字，如21235
		//System.out.println(of32.numberOf1Between1AndN(21235));
		System.out.println(of32.numberOf1Between1AndN_1(21235));


	}

}
