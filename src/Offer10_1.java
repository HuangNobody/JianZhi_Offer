public class Offer10_1 {

	//�ⷨ1������������ѭ���Ľⷨ
	public int NumberOf1(int n){
		int count = 0;
		while(n != 0){//�п����Ǹ���
			if((n&1) !=0)//���n&1����û�и������ŵĻ����ᱨ����ʾ"&"����δ����
				count++;
			n = n>>1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Offer10_1 o101 = new Offer10_1();
		//��������
		//1�������������߽�ֵ1��0x7FFFFFFF��
		
		int n1 = 1;
		System.out.println("�������֣�" + n1 + " ,��������1�ĸ�����" + o101.NumberOf1(n1));
		int n2 = 0x7FFFFFFF;
		System.out.println("�������֣�" + n2 + " ,��������1�ĸ�����" + o101.NumberOf1(n2));
		
		//3��0
		int n5 = 0;//����Ѳ�������3���ڲ�������2���棬��Ϊ2������������������������ѭ�����ʲ�������3���������
		System.out.println("�������֣�" + n5 + " ,��������1�ĸ�����" + o101.NumberOf1(n5));
		
		//2,�����������߽�ֵ0x80000000,0xFFFFFFFF��
		int n3 = 0x80000000;//��ѭ��������ʱû���������Ҳû�п�������֣�
		System.out.println("�������֣�" + n3 + " ,��������1�ĸ�����" + o101.NumberOf1(n3));
		int n4 = 0xFFFFFFFF;//��ѭ��������ʱû���������Ҳû�п�������֣�
		System.out.println("�������֣�" + n4 + " ,��������1�ĸ�����" + o101.NumberOf1(n4));
	}
}
