
public class Offer14_1 {
	
	public void reOrderOddEven(int [] number){
		if(number == null || number.length == 0)
			return ;
		
		int begin = 0;
		int end = number.length-1;
		while(begin<end){//����ƶ�begin��ֱ����ָ��ż��
			while(begin<end && (number[begin]&0x1) != 0)//
				begin++;
			while(begin<end &&(number[end]&0x1) ==0)
				end--;
			if(begin<end){
				int temp = number[begin];
				number[begin] = number[end];
				number[end] =temp;
			}
		}
		
		//��������������Ԫ��
		for(int i =0;i<number.length;i++){
			System.out.print(number[i]+", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//��������1.���ܲ���
		Offer14_1 of141 = new Offer14_1();
		int [] number1 = {1,2,3,4,5};
		System.out.println("���������е�������ż��������֣�");
		of141.reOrderOddEven(number1);
		
		int [] number2 = {2,4,1,5,3};
		System.out.println("���������������ż��������������ǰ�棺");
		of141.reOrderOddEven(number2);
		
		int [] number3 = {1,5,3,2,4};
		System.out.println("���������������������������ż��ǰ�棺");
		of141.reOrderOddEven(number3);
		
		//�����������
		int [] number4 = null;
		System.out.println("����NULLָ�룺");
		of141.reOrderOddEven(number4);
		
		int [] number5 = {1};
		System.out.println("���������ֻ����һ�����֣�");
		of141.reOrderOddEven(number5);
	}
}
