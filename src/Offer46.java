public class Offer46 {

	//����1
	/*
	����˼·��
	1.�������߼���Ķ�·����ʵ�ֵݹ���ֹ�� 2.��n==0ʱ��(n>0)&&((sum+=Sum_Solution(n-1))>0)ִֻ��ǰ����жϣ�Ϊfalse��Ȼ��ֱ�ӷ���0��
	3.��n>0ʱ��ִ��sum+=Sum_Solution(n-1)��ʵ�ֵݹ����Sum_Solution(n)��
	*/
	public int sum_1(int n){
		int sum = n;
		boolean ans = (n>0)&&((sum+=sum_1(n-1))>0);
		return sum;
	}
	
	//����2
	public int sum_2(int n){
		int sum = n;
		boolean ans = (n==0)||((sum+=sum_2(n-1))==0);
		return sum;
	}
	
	public static void main(String[] args) {
		
		Offer46 of46 = new Offer46();
		
		//���ܲ��ԣ�1������5����1+2+3+4+5
		int n1 = 5;
		//System.out.println(of46.sum_1(n1));
		System.out.println(of46.sum_2(n1));
		
		//���ܲ��ԣ�2������10����1+2+3+4+5+...+10
		int n2 = 10;
		//System.out.println(of46.sum_1(n2));
		System.out.println(of46.sum_2(n2));
		
		//�߽�ֵ���ԣ�3������0
		int n3 = 0;
		//System.out.println(of46.sum_1(n3));
		System.out.println(of46.sum_2(n3));
		
		//�߽�ֵ���ԣ�4������1
		int n4 = 1;
		//System.out.println(of46.sum_1(n4));
		System.out.println(of46.sum_2(n4));

	}

}
