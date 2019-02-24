
public class Offer11_3 {
	
	public double Power(double base, int exponent){
		if(equal(base, 0.0) && exponent < 0)
			throw new RuntimeException("while exponent is minus, the base can't be zero");
		int absExponent = exponent;
		if(exponent < 0)
			absExponent = ~exponent +1;//������λȡ��+1�õ������෴����-2��+2��Ϊ�෴��
		double result = powerWithUnsignedExponent(base, absExponent);
		if(exponent<0)
			result = 1.0/result;
		return result;
	}
	
	public boolean equal(double number1, double number2){
		if(number1 - number2 > -0.0000001 && (number1-number2) < 0.0000001)
			return true;
		return false;
	}

	public double powerWithUnsignedExponent(double base, int exponent){//��ʼʱ�Ұ�int exponent
		if(exponent ==0)     //��С��д��double���ͣ����exponent >> 1��exponent & 0x1��������>>��&δ����
			return 1;
		if(exponent == 1)
			return base;
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result *= result;
		if((exponent & 0x1) == 1)
			result *= base;
		return result;
	}
	
	public static void main(String[] args) {
		Offer11_3 of113 = new Offer11_3();
		//��������
		System.out.println("����Ϊ2,ָ��Ϊ2�����н����"+ of113.Power(2.0, 2));
		System.out.println("����Ϊ2,ָ��Ϊ-2�����н����"+ of113.Power(2, -2));
		System.out.println("����Ϊ2,ָ��Ϊ0�����н����"+ of113.Power(2, 0));
		System.out.println("����Ϊ2,ָ��Ϊ1�����н����"+ of113.Power(2, 1));
		System.out.println("����Ϊ-2,ָ��Ϊ2�����н����"+ of113.Power(-2, 2));
		System.out.println("����Ϊ-2,ָ��Ϊ-2�����н����"+ of113.Power(-2, -2));
		System.out.println("����Ϊ-2,ָ��Ϊ0�����н����"+ of113.Power(-2, 0));
		System.out.println("����Ϊ0,ָ��Ϊ2�����н����"+ of113.Power(0, 2));
		System.out.println("����Ϊ0,ָ��Ϊ-2�����н����"+ of113.Power(0, -2));
		System.out.println("����Ϊ0,ָ��Ϊ0�����н����"+ of113.Power(0, 0));
	}
}
