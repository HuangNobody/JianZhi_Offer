public class Offer10_3 {
	
	public int NumberOf3(int n){
		int count = 0;
		while(n!=0){
			count++;
			n = (n-1)&n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Offer10_3 o103 = new Offer10_3();
		//��������
		//1�������������߽�ֵ1��0x7FFFFFFF��
			
		int n1 = 1;
		System.out.println("�������֣�" + n1 + " ,��������1�ĸ�����" + o103.NumberOf3(n1));
		int n2 = 0x7FFFFFFF;
		System.out.println("�������֣�" + n2 + " ,��������1�ĸ�����" + o103.NumberOf3(n2));
			
		//3��0
		int n5 = 0;//����Ѳ�������3���ڲ�������2���棬û�����⣡������������
		System.out.println("�������֣�" + n5 + " ,��������1�ĸ�����" + o103.NumberOf3(n5));
		
		//2,�����������߽�ֵ0x80000000,0xFFFFFFFF��
		int n3 = 0x80000000;//û����ѭ��
		System.out.println("�������֣�" + n3 + " ,��������1�ĸ�����" + o103.NumberOf3(n3));
		int n4 = 0xFFFFFFFF;//û����ѭ��
		System.out.println("�������֣�" + n4 + " ,��������1�ĸ�����" + o103.NumberOf3(n4));	
	}
}
