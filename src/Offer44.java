import java.util.Arrays;

public class Offer44 {

	public boolean isContinuous(int [] numbers){
		if(numbers == null || numbers.length<1)
			return false;
		
		Arrays.sort(numbers);//����Ҳ�����������������㷨
		
		int numberOfZero = 0;
		int numberOfGap = 0;
		//ͳ��������0 ����
		for(int i = 0;i<numbers.length&& numbers[i]==0;i++)
			numberOfZero++;
		//ͳ�������еļ����Ŀ
		int small = numberOfZero;
		int big = small +1;
		while(big<numbers.length){
			//����������ȣ��ж��ӣ���������˳��
			if(numbers[small] == numbers[big])
				return false;
			
			numberOfGap += numbers[big] - numbers[small] -1;
			small = big;
			big++;
		}
		
		return (numberOfGap > numberOfZero) ? false:true;
	}
	
	public static void main(String[] args) {
		
		Offer44 of44 = new Offer44();
		
		//���ܲ��ԣ�1�������������һ����С��
		int [] num1 = {1,3,4,7,0};
		System.out.println(of44.isContinuous(num1));

		//���ܲ��ԣ�2�������������2����С��
		int [] num2 = {1,0,4,5,0};
		System.out.println(of44.isContinuous(num2));
		
		//���ܲ��ԣ�3�����������û�д�С��
		int [] num3 = {1,3,4,5,6};
		System.out.println(of44.isContinuous(num3));
		
		//���ܲ��ԣ�4������������ж���
		int [] num4 = {1,3,3,5,4};
		System.out.println(of44.isContinuous(num4));
		
		//����������� ������NULLָ��
		int [] num5 = null;
		System.out.println(of44.isContinuous(num5));
	}

}
