import java.util.Arrays;

public class Offer12_1 {
	
	public void print1ToMaxNDigits(int n){
		if(n <= 0)
			throw new RuntimeException("n can't lower zero");
		char []number = new char[n];//�����c++���ԣ���������n+1�����һλ�š�\0��������java��n����ҪŪ����
		for(int i = 0;i<n;i++){
			number[i] = '0';
		}
		
		while(!increment(number)){
			printNumber(number);
		}
	}
	
	public boolean increment(char[] number){//��ʾ���ֵ��ַ���number������1
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nLength = number.length;
		for(int i = nLength-1;i>=0;i--){
			int nSum = number[i] - '0' + nTakeOver;
			if(i == nLength-1)
				nSum++;
			
			if(nSum >=10){
				if(i == 0)
					isOverflow = true;
				else{
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			}else{
				number[i] = (char) ('0' + nSum);
				break;
			}
		}
		return isOverflow;
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
		/*
		boolean isBeginning = true;
		int nLength = number.length;
		for(int i =0;i<nLength;i++){
			if(isBeginning && number[i] !='0')
				isBeginning = false;
			if(!isBeginning){
				char[] printNum = Arrays.copyOfRange(number, i, nLength);//��������
				System.out.println(printNum);
			}
		}
		��γ��򣬵�n=2ʱ�������1������2λ��ʱ�������11��ʼ�������11��1;12��12;13��3...
		*/
	}
	
	public static void main(String[] args) {
		
		//��������
		//���ܲ��ԣ�����1��2��3.����
		Offer12_1 of121 = new Offer12_1();
		System.out.println("����1�������1������1λ����");
		of121.print1ToMaxNDigits(1);
		System.out.println("����2�������1������2λ����");
		of121.print1ToMaxNDigits(2);

		System.out.println("����3�������1������3λ����");
		of121.print1ToMaxNDigits(3);
		
		//����������ԣ�����-1��0��
		System.out.println("����-1�������1������-1λ����");
		of121.print1ToMaxNDigits(-1);
		System.out.println("����0�������1������0λ����");
		of121.print1ToMaxNDigits(0);
	}
}
