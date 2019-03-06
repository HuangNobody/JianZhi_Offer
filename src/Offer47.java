public class Offer47 {

	public int add(int num1, int num2){
		int sum,carry;
		do{
			sum = num1^num2;
			carry = (num1 & num2)<<1;
			
			num1 = sum;
			num2 = carry;
		}while(num2!=0);
		
		return num1;
	}
	
	public static void main(String[] args) {
		Offer47 of47 = new Offer47();
		
		//1，输入正数
		int num1 = 5;
		int num2 = 7;
		System.out.println(of47.add(num1, num2));
		
		//2，输入负数
		int num3 = -5;
		int num4 = -7;
		System.out.println(of47.add(num3, num4));
		
		//2，输入0
		int num5 = 0;
		int num6 = -7;
		System.out.println(of47.add(num5, num6));

	}

}
