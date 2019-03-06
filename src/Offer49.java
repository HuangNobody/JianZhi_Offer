public class Offer49 {

	public int strToInt(String str){
		if(str == null || str.length() == 0 || hasNonNumerical(str))
			return 0;// 如果字符串为空并且包含非数字字符
		
		// 此时的字符串肯定是数字字符串
		// 因为返回值限定为int型，所以无需考虑大数问题
		char firstChar = str.charAt(0);
		int sumExcludeFirst = 0;// 先将除第一位的数字转换成整数
		int sum = 0;
		for(int i = 1;i<str.length();i++){
			char c = str.charAt(i);// 拿出当前字符
			int convert = c-'0';//将字符转换成整数
			
			if(firstChar =='+'&& sum<=Integer.MAX_VALUE)
				sum += convert*Math.pow(10, str.length()-1-i);
			
			if(firstChar == '-'&& sum >=Integer.MIN_VALUE)
				sum -= convert*Math.pow(10, str.length()-1-i);
			
			if(firstChar >='0'&&firstChar <='9'&& sum<=Integer.MAX_VALUE)
				sum += convert *Math.pow(10, str.length()-1-i);
		}
		
		int first = firstChar - '0';//将字符转换程整数
		if(firstChar >= '0'&& firstChar <= '9')
			sum += first*Math.pow(10, str.length()-1);
		if(sum>Integer.MAX_VALUE ||sum < Integer.MIN_VALUE)
			return 0;
		
		return sum;
	}
	
	// 判断一个字符串除第一个字符外是否包含非数字字符，第一个字符可以是+或者是—
	public boolean hasNonNumerical(String str) {
		int length = str.length();
		
		// 取出第0位，若第0位如果是数字或者是+，—则继续遍历，否则直接返回false
		char c = str.charAt(0);
		if((c>='0'&&c<='9') || (c=='+') || (c=='-')){// 有必要进行之后的遍历
			for(int i = 1;i<length;i++){
				c = str.charAt(i);// 取出当前字符
				if(c<'0'||c>'9')
					return true;// 证明包含非数字字符，直接跳出循环，返回false
			}
		}else
			return true;// 首位就包含除正负号外的非数字字符
		
		return false;
	}

	public static void main(String[] args) {
		
		Offer49 of49 = new Offer49();
		
		//功能测试，1，输入的字符串表示正数
		String str1 = "123";
		System.out.println(of49.strToInt(str1));
		
		//功能测试，2，输入的字符串表示正数
		String str2 = "+123";
		System.out.println(of49.strToInt(str2));
		
		//功能测试，3，输入的字符串表示负数
		String str3 = "-123";
		System.out.println(of49.strToInt(str3));
		
		//功能测试，4，输入的字符串表示0
		String str4 = "0";
		System.out.println(of49.strToInt(str4));
		
		//边界值测试，5，最大的正整数
		String str5 = "Integer.MAX_VALUE";
		System.out.println(of49.strToInt(str5));
		
		//边界值测试，6，最小的负整数
		String str6 = "Integer.MIN_VALUE";
		System.out.println(of49.strToInt(str6));
		
		//特殊输入测试，7，输入字符串为NULL指针
		String str7 = null;
		System.out.println(of49.strToInt(str7));
		
		//特殊输入测试，8，输入字符串为空字符串
		String str8 = "";
		System.out.println(of49.strToInt(str8));
		
		//特殊输入测试，8，输入字符串有非数字字符
		String str9 = "+123-=";
		System.out.println(of49.strToInt(str9));

	}

}
