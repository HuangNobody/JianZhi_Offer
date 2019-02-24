public class Offer09 {
	
	//�ݹ飬Ч�ʺܵͣ����Թٲ���ϲ��
	public long Fibonacci_Recursive(int n){
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		return Fibonacci_Recursive(n-1) + Fibonacci_Recursive(n-2);
	}
	
	//ʱ�临�Ӷ�O(n)����Ҫ�����
	public long Fibonacci(int n){
		int result[] = {0,1};
		if(n<2)
			return result[n];
		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		for(int i = 2;i<=n;i++){
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusOne = fibN;
			fibNMinusTwo = fibNMinusOne;
		}
		return fibN;
	}
	
	public static void main(String[] args) {
		
		Offer09 of9 = new Offer09();
		
		//��������
		//1�����ܲ��ԣ�������3��5��10�ȣ�
		int n1 = 3;
		System.out.println("�������֣�"+n1+", ������:"+of9.Fibonacci(n1));
		int n2 = 5;
		System.out.println("�������֣�"+n2+", ������:"+of9.Fibonacci(n2));
		int n3 = 10;
		System.out.println("�������֣�"+n3+", ������:"+of9.Fibonacci(n3));
		
		//2,�߽�ֵ���ԣ�������0��1��2��
		int n4 = 0;
		System.out.println("�������֣�"+n4+", ������:"+of9.Fibonacci(n4));
		int n5 = 1;
		System.out.println("�������֣�"+n5+", ������:"+of9.Fibonacci(n5));
		int n6 = 2;
		System.out.println("�������֣�"+n6+", ������:"+of9.Fibonacci(n6));
		
		//3�����ܲ��ԣ�����ϴ�����֣���40��50��100�ȣ�
		int n7 = 40;
		System.out.println("�������֣�"+n7+", ������:"+of9.Fibonacci(n7));
		int n8 = 50;
		System.out.println("�������֣�"+n8+", ������:"+of9.Fibonacci(n8));
		int n9 = 100;//������������long�ķ�Χ�������Ϊ0
		System.out.println("�������֣�"+n9+", ������:"+of9.Fibonacci(n9));
	}
}
