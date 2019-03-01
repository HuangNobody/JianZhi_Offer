

import java.util.ArrayList;

public class Offer30 {
	
	public ArrayList<Integer> getLeastNumbers_1(int [] input, int k){
		ArrayList<Integer> leastNumbers = new ArrayList<>();
		if(input == null || k<=0 || k> input.length){
			System.out.print("输入的值不合法。");
			return leastNumbers;
		}
			
		int start = 0;
		int end = input.length-1;
		int index = partition(input, start, end);
		while(index != k-1){
			if(index<k-1){
				start = index + 1;
				index = partition(input, start, end);
			}else{
				end = index -1;
				index = partition(input, start, end);
			}
		}
		for(int i = 0;i<k;i++){
			leastNumbers.add(input[i]);
		}
		
		return leastNumbers;
	}
	
	//选用partition函数
	public int partition(int [] arr, int left, int right){
		int result = arr[left];
		if(left>right)
			return -1;
		while(left<right){
			while(left<right && arr[right] >= result)
				right--;
			arr[left] = arr[right];
			while(left<right && arr[left] < result)
				left++;
			arr[right] = arr[left];
		}
		arr[left] = result;
		return left;
	}
	
	//方法2，基于堆的容器
	public ArrayList<Integer> getLeastNumbers_2(int [] input, int k){
		ArrayList<Integer> leastNumbers = new ArrayList<>();
		while(input == null || k<=0 || k> input.length){
			System.out.print("输入的值不合法。");
			return leastNumbers;
		}
		
		int [] numbers = new int[k];//用于放最小的k个数
		for(int i = 0;i<k;i++){
			numbers[i] = input[i];//先放入前k个数
		}
		for(int i = k/2-1;i>=0;i--)
			adjustHeap(numbers, i, k-1);//循环建立初始堆
		for(int i=k ;i<input.length;i++){
			if(input[i]<numbers[0]){
				numbers[0] = input[i];
				adjustHeap(numbers, 0, k-1);//重新调整最大堆
			}
		}
		
		for(int n:numbers)
			leastNumbers.add(n);
		
		return leastNumbers;
	}
	
	//最大堆的调整方法，见堆排序
	public void adjustHeap(int[] numbers, int parent, int length) {
		int temp = numbers[parent];// temp保存当前父节点
		int child = 2*parent+1;// 先获得左孩子
		
		while(child<=length){//这里是<=，若是<输出结果就不对，和堆排序对比，想想为什么，因为adjustHeap(numbers, 0, k-1);输入的length=k-1;若真实冷天，应该是k
			  // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
			if(child+1<=length && numbers[child]<numbers[child+1])
				child++;
			// 如果父结点的值已经大于孩子结点的值，则直接结束
			if(temp> numbers[child])
				break;
			// 把孩子结点的值赋给父结点
			numbers[parent] = numbers[child];
			// 选取孩子结点的左孩子结点,继续向下筛选
			parent = child;
			child = 2 *child+1;
		}
		numbers[parent] = temp;
	}

	public static void printArray(ArrayList<Integer> array){
		for(Integer temp:array){
			System.out.print(temp+"  ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		Offer30 of30 = new Offer30();
		
		//功能测试，1，输入的数组中没有相同的数字
		int [] arr11 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr11, 4));
		printArray(of30.getLeastNumbers_2(arr11, 4));
		
		//功能测试，2，输入的数组中有有相同的数字
		int [] arr21 = {4,5,1,6,2,3,3,8};
		//printArray(of30.getLeastNumbers_1(arr21, 4));
		printArray(of30.getLeastNumbers_2(arr21, 4));
		
		//边界值测试，3， 输入的k=1
		int [] arr31 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr31, 1));
		printArray(of30.getLeastNumbers_2(arr31, 1));
		
		//边界值测试，4， 输入的k=arr.length
		int [] arr41 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr41, 8));
		printArray(of30.getLeastNumbers_2(arr41, 8));
		
		//特殊输入测试，5，k<1
		int [] arr51 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr51, -1));
		printArray(of30.getLeastNumbers_2(arr51, -1));
		
		//特殊输入测试，6，k>arr.length
		int [] arr61 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr61, 10));
		printArray(of30.getLeastNumbers_2(arr61, 10));
		
		//特殊输入测试，7，arr=null
		int [] arr71 = null;
		//printArray(of30.getLeastNumbers_1(arr71, 10));
		printArray(of30.getLeastNumbers_2(arr71, 10));

	}

}
