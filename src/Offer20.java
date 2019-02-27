public class Offer20 {

	//ѭ����ӡ����
	public void printMatrixClockwisely(int [][] numbers){
		if(numbers == null)
			return;
		int rows = numbers.length;
		if(rows<=0)
			return;//��һ�����Ǻ�����Ĳ���һ�𣬾ͻ��ڲ�������Ϊarr={{}}ʱ���columns = numbers[0].length����
		int columns = numbers[0].length;
		//if( columns <=0 )�����ж�����ɾ��û��Ӱ��
		//	return;
		
		int start = 0;
		while(columns >start*2 && rows > start*2){
			printMatrixCircle(numbers, start);
			start++;
		}
	}

	//��ӡһȦ�Ĺ���
	public void printMatrixCircle(int[][] numbers, int start) {
		
		int endX = numbers[0].length -1 -start;
		int endY = numbers.length - 1 - start;
		
		//�����Ҵ�ӡһ��
		for(int i  = start; i<= endX;i++){
			int number = numbers[start][i];
			printNumber(number);
		}
		
		
		//���ϵ��´�ӡһ��
		if(start<endY){
			for(int i = start+1; i<=endY;i++){
				int number = numbers[i][endX];
				printNumber(number);
			}
		}
		
		//���ҵ����ӡһ��
		if(start<endY && start<endX){
			for(int i = endX-1;i>=start;i--){
				int number = numbers[endY][i];
				printNumber(number);
			}
		}
		
		//���µ��ϴ�ӡһ��
		if(start<endX && start<endY-1){
			for(int i = endX-1;i>=start+1;i--){
				int number = numbers[i][start];
				printNumber(number);
			}
		}
	}

	public void printNumber(int number) {
		// TODO Auto-generated method stub
		System.out.print(number+"  ");
	}
	
	public static void main(String [] args){
		Offer20 of20 = new Offer20();
		
		//��������
		//�����ж��ж���
		int array1[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};
		of20.printMatrixClockwisely(array1);
		System.out.println();
		
		//����ֻ��һ��
		int array2[][] = {{1,2,3,4}};
		of20.printMatrixClockwisely(array2);
		System.out.println();
		
		//����ֻ��һ��
		int array3[][] = {{1},{2},{3},{4}};
		of20.printMatrixClockwisely(array3);
		System.out.println();
		
		//������ֻ��һ��һ��
		int array4[][] = {{1}};
		of20.printMatrixClockwisely(array4);
		System.out.println();
		
		//������û��Ԫ��
		int array5[][] = {{}};
		of20.printMatrixClockwisely(array5);
		System.out.println();
		
		//������û��Ԫ�أ����columns = numbers[0].length;�ᱨ����������ں����β��и���columns��rows
		int array6[][] = {};
		of20.printMatrixClockwisely(array6);
		System.out.println();
		
		//����Ϊnull
		int array7[][] = null;
		of20.printMatrixClockwisely(array7);
		System.out.println();
	}	
}
