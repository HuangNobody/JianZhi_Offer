public class Offer14_2 {
	
	public void reOrder(int [] array){
		if(array == null || array.length == 0)
			return;
		int begin = 0;
		int end = array.length-1;
		while(begin<end){
			while(begin<end && !isEven(array[begin]))
				begin++;
			while(begin<end && isEven(array[end]))
				end--;
			if(begin<end){
				int temp = array[begin];
				array[begin] = array[end];
				array[end] = temp;
			}
		}
		
		//��������������Ԫ��
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+", ");
		}
		System.out.println();
	}
	
	public boolean isEven(int n){
		return (n&0x1)==0;
	}
	
	public static void main(String[] args) {
		//��������1.���ܲ���
		Offer14_2 of142 = new Offer14_2();
		int [] number1 = {1,2,3,4,5};
		System.out.println("���������е�������ż��������֣�");
		of142.reOrder(number1);
	
		int [] number2 = {2,4,1,5,3};
		System.out.println("���������������ż��������������ǰ�棺");
		of142.reOrder(number2);
		
		int [] number3 = {1,5,3,2,4};
		System.out.println("���������������������������ż��ǰ�棺");
		of142.reOrder(number3);
		
		//�����������
		int [] number4 = null;
		System.out.println("����NULLָ�룺");
		of142.reOrder(number4);
		
		int [] number5 = {1};
		System.out.println("���������ֻ����һ�����֣�");
		of142.reOrder(number5);
		
	}
}

