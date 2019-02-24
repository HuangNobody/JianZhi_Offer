import java.util.Arrays;

public class Offer12_2 {
	
	public void print1ToMaxNDigits(int n){
		if(n<0)
			return;
		char [] number = new char[n];
		for(int i = 0;i<10;i++){//������i<10,����i<n
			number[0] = (char) (i+ '0');
			print1ToMaxOfNDigitsRecursively(number, n, 0);
		}
	}
	
	private void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
		if(index == length-1){
			printNumber(number);
			return;
		}
		
		for(int i= 0;i<10;i++){
			number[index+1] = (char) (i+'0');
			print1ToMaxOfNDigitsRecursively(number, length,index+1);
		}
	}

	public void printNumber(char[] number){//��ӡ�ַ�����ʾ�����֣�ֻ����������һ����0���ַ�֮��ſ��Ǵ�ӡ
		int nLength = number.length;
		int i =0;
		while(i<nLength && number[i] == '0') //i < size��ǰ������Խ��
			i++;
		if(i == nLength)
			return;
		char[] printNum = Arrays.copyOfRange(number, i, nLength);//��������
		System.out.println(printNum);	
	}
	
	public static void main(String[] args) {
		//��������
		//���ܲ��ԣ�����1��2��3.����
		Offer12_2 of122 = new Offer12_2();
		//System.out.println("����1�������1������1λ����");
		//of122.print1ToMaxNDigits(1);
		System.out.println("����2�������1������2λ����");
		of122.print1ToMaxNDigits(2);
		System.out.println("����3�������1������3λ����");
		of122.print1ToMaxNDigits(3);
		
		//����������ԣ�����-1��0��
		System.out.println("����-1�������1������-1λ����");
		of122.print1ToMaxNDigits(-1);
		System.out.println("����0�������1������0λ����");
		of122.print1ToMaxNDigits(0);
	}
}
