public class Offer11_1 {
	
	public double Power(double base, int exponent){
		double result = 1.0;
		for(int i =1;i<=exponent;i++){
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		Offer11_1 of111 = new Offer11_1();
		//��������
		System.out.println("����Ϊ2,ָ��Ϊ2�����н����"+ of111.Power(2, 2));
		System.out.println("����Ϊ2,ָ��Ϊ-2�����н����"+ of111.Power(2, -2));//û�����������
		System.out.println("����Ϊ2,ָ��Ϊ0�����н����"+ of111.Power(2, 0));//û�����������
		System.out.println("����Ϊ2,ָ��Ϊ1�����н����"+ of111.Power(2, 1));
		System.out.println("����Ϊ-2,ָ��Ϊ2�����н����"+ of111.Power(-2, 2));
		System.out.println("����Ϊ-2,ָ��Ϊ-2�����н����"+ of111.Power(-2, -2));//û�����������
		System.out.println("����Ϊ-2,ָ��Ϊ0�����н����"+ of111.Power(-2, 0));
		System.out.println("����Ϊ0,ָ��Ϊ2�����н����"+ of111.Power(0, 2));
		System.out.println("����Ϊ0,ָ��Ϊ-2�����н����"+ of111.Power(0, -2));//���н������
		System.out.println("����Ϊ0,ָ��Ϊ0�����н����"+ of111.Power(0, 0));//���н������
	}
}
