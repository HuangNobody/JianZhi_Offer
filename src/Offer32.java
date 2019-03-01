

public class Offer32 {
	
	//����1�������ò���offer
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

	//����2.�����ֹ�������
	public int numberOf1Between1AndN(int n){
		if(n<=0)
			return 0;
		String strNumber = String.valueOf(n);//������ת�����ַ���
		int length = strNumber.length();
		int firstDigit = strNumber.charAt(0) - '0';//���ַ���ת��������,Returns the char value at the specified index.
		//ֻ�и�λ
		if(length == 1 && firstDigit == 0)
			return 0;
		if(length ==1 && firstDigit > 0)
			return 1;
		
		//����λ�⣬ʣ�µ�����
		String remainedString = strNumber.substring(1);//��1��ʼ������λ�ã�����һ�����ַ�����substring(int beginIndex);Returns a new string that is a substring of this string.
		int remainedNumber = Integer.parseInt(remainedString);//�ַ���ת����ʮ�������֣�parseInt(String s),Parses���� the string argument as a signed decimal integer.
		
		//1��������λ�Ĵ���
		int countOfFirstDigit;
		if(firstDigit == 1)//�����λ���ֵ���1�������10000~12345�������λ����1�Ĵ���Ϊ2345+1=2346�Σ�
			countOfFirstDigit = remainedNumber +1;//��2���ǰѳ���λ����ַ���ת��Ϊ������10000~12345�����λ����1������Ϊ��ȥ��������ͺ���ʣ�µ������ټ�1.
		else//��1��1345~21345�У���λ�ϳ���1��������10000~19999�У���10^4�������n�ĳ���Ϊlength������10^(length-1)�Ρ�
			countOfFirstDigit = (int)Math.pow(10,length-1);
		
		//(length-1):��ѡһλΪ1��10^(length0-2):����λ��0-9��ѡ��
		//firstDigit����λ��ѡ������
		//���˵�һλ����֮�⣬����λ����1�Ĵ������ٰ�1346~21345�ֳ�2�Σ�1346~11346,11236~21346��
		//ÿһ���г�ȥ���е�һ����Ϊ1֮�⣬������ÿλ������ȡ0~9��������2*10^3�Ρ�������first*10^(length-2)��
		
		int countOfOtherDigit = firstDigit *(length -1)*(int)Math.pow(10, length-2);
		
		// �ݹ�����ʣ��������1���ֵĴ���
		int remainedCount = numberOf1Between1AndN(remainedNumber);
		int result = countOfFirstDigit + countOfOtherDigit + remainedCount;
		return result;
	}
	
	public static void main(String[] args) {
		
		Offer32 of32 = new Offer32();
		
		//���ܲ��ԣ�1������5
		//System.out.println(of32.numberOf1Between1AndN(5));
		System.out.println(of32.numberOf1Between1AndN_1(5));
		
		//���ܲ��ԣ�2������10
		//System.out.println(of32.numberOf1Between1AndN(10));
		System.out.println(of32.numberOf1Between1AndN_1(10));
		
		//���ܲ��ԣ�3������55
		//System.out.println(of32.numberOf1Between1AndN(55));
		System.out.println(of32.numberOf1Between1AndN_1(55));
		
		//���ܲ��ԣ�4������99
		//System.out.println(of32.numberOf1Between1AndN(99));
		System.out.println(of32.numberOf1Between1AndN_1(99));
		
		//�߽�ֵ���ԣ�5������0
		//System.out.println(of32.numberOf1Between1AndN(0));
		System.out.println(of32.numberOf1Between1AndN_1(0));
		
		//�߽�ֵ���ԣ�6������1
		//System.out.println(of32.numberOf1Between1AndN(1));
		System.out.println(of32.numberOf1Between1AndN_1(1));
		
		//���ܲ��ԣ�7������ϴ�����֣���10000
		//System.out.println(of32.numberOf1Between1AndN(10000));
		System.out.println(of32.numberOf1Between1AndN_1(10000));
		
		//���ܲ��ԣ�8������ϴ�����֣���21235
		//System.out.println(of32.numberOf1Between1AndN(21235));
		System.out.println(of32.numberOf1Between1AndN_1(21235));


	}

}
