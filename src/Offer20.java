public class Offer20 {

	//循环打印矩阵
	public void printMatrixClockwisely(int [][] numbers){
		if(numbers == null)
			return;
		int rows = numbers.length;
		if(rows<=0)
			return;//这一句若是和下面的并在一起，就会在测试用例为arr={{}}时语句columns = numbers[0].length报错
		int columns = numbers[0].length;
		//if( columns <=0 )这句的判断条件删除没有影响
		//	return;
		
		int start = 0;
		while(columns >start*2 && rows > start*2){
			printMatrixCircle(numbers, start);
			start++;
		}
	}

	//打印一圈的功能
	public void printMatrixCircle(int[][] numbers, int start) {
		
		int endX = numbers[0].length -1 -start;
		int endY = numbers.length - 1 - start;
		
		//从左到右打印一行
		for(int i  = start; i<= endX;i++){
			int number = numbers[start][i];
			printNumber(number);
		}
		
		
		//从上到下打印一列
		if(start<endY){
			for(int i = start+1; i<=endY;i++){
				int number = numbers[i][endX];
				printNumber(number);
			}
		}
		
		//从右到左打印一行
		if(start<endY && start<endX){
			for(int i = endX-1;i>=start;i--){
				int number = numbers[endY][i];
				printNumber(number);
			}
		}
		
		//从下到上打印一列
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
		
		//测试用例
		//数组有多行多列
		int array1[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};
		of20.printMatrixClockwisely(array1);
		System.out.println();
		
		//数组只有一行
		int array2[][] = {{1,2,3,4}};
		of20.printMatrixClockwisely(array2);
		System.out.println();
		
		//数组只有一列
		int array3[][] = {{1},{2},{3},{4}};
		of20.printMatrixClockwisely(array3);
		System.out.println();
		
		//数组中只有一行一列
		int array4[][] = {{1}};
		of20.printMatrixClockwisely(array4);
		System.out.println();
		
		//数组中没有元素
		int array5[][] = {{}};
		of20.printMatrixClockwisely(array5);
		System.out.println();
		
		//数组中没有元素，语句columns = numbers[0].length;会报错所以最好在函数形参中给出columns和rows
		int array6[][] = {};
		of20.printMatrixClockwisely(array6);
		System.out.println();
		
		//数组为null
		int array7[][] = null;
		of20.printMatrixClockwisely(array7);
		System.out.println();
	}	
}
