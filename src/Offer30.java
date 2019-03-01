

import java.util.ArrayList;

public class Offer30 {
	
	public ArrayList<Integer> getLeastNumbers_1(int [] input, int k){
		ArrayList<Integer> leastNumbers = new ArrayList<>();
		if(input == null || k<=0 || k> input.length){
			System.out.print("�����ֵ���Ϸ���");
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
	
	//ѡ��partition����
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
	
	//����2�����ڶѵ�����
	public ArrayList<Integer> getLeastNumbers_2(int [] input, int k){
		ArrayList<Integer> leastNumbers = new ArrayList<>();
		while(input == null || k<=0 || k> input.length){
			System.out.print("�����ֵ���Ϸ���");
			return leastNumbers;
		}
		
		int [] numbers = new int[k];//���ڷ���С��k����
		for(int i = 0;i<k;i++){
			numbers[i] = input[i];//�ȷ���ǰk����
		}
		for(int i = k/2-1;i>=0;i--)
			adjustHeap(numbers, i, k-1);//ѭ��������ʼ��
		for(int i=k ;i<input.length;i++){
			if(input[i]<numbers[0]){
				numbers[0] = input[i];
				adjustHeap(numbers, 0, k-1);//���µ�������
			}
		}
		
		for(int n:numbers)
			leastNumbers.add(n);
		
		return leastNumbers;
	}
	
	//���ѵĵ�����������������
	public void adjustHeap(int[] numbers, int parent, int length) {
		int temp = numbers[parent];// temp���浱ǰ���ڵ�
		int child = 2*parent+1;// �Ȼ������
		
		while(child<=length){//������<=������<�������Ͳ��ԣ��Ͷ�����Աȣ�����Ϊʲô����ΪadjustHeap(numbers, 0, k-1);�����length=k-1;����ʵ���죬Ӧ����k
			  // ������Һ��ӽ�㣬�����Һ��ӽ���ֵ�������ӽ�㣬��ѡȡ�Һ��ӽ��
			if(child+1<=length && numbers[child]<numbers[child+1])
				child++;
			// ���������ֵ�Ѿ����ں��ӽ���ֵ����ֱ�ӽ���
			if(temp> numbers[child])
				break;
			// �Ѻ��ӽ���ֵ���������
			numbers[parent] = numbers[child];
			// ѡȡ���ӽ������ӽ��,��������ɸѡ
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
		
		//���ܲ��ԣ�1�������������û����ͬ������
		int [] arr11 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr11, 4));
		printArray(of30.getLeastNumbers_2(arr11, 4));
		
		//���ܲ��ԣ�2�������������������ͬ������
		int [] arr21 = {4,5,1,6,2,3,3,8};
		//printArray(of30.getLeastNumbers_1(arr21, 4));
		printArray(of30.getLeastNumbers_2(arr21, 4));
		
		//�߽�ֵ���ԣ�3�� �����k=1
		int [] arr31 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr31, 1));
		printArray(of30.getLeastNumbers_2(arr31, 1));
		
		//�߽�ֵ���ԣ�4�� �����k=arr.length
		int [] arr41 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr41, 8));
		printArray(of30.getLeastNumbers_2(arr41, 8));
		
		//����������ԣ�5��k<1
		int [] arr51 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr51, -1));
		printArray(of30.getLeastNumbers_2(arr51, -1));
		
		//����������ԣ�6��k>arr.length
		int [] arr61 = {4,5,1,6,2,7,3,8};
		//printArray(of30.getLeastNumbers_1(arr61, 10));
		printArray(of30.getLeastNumbers_2(arr61, 10));
		
		//����������ԣ�7��arr=null
		int [] arr71 = null;
		//printArray(of30.getLeastNumbers_1(arr71, 10));
		printArray(of30.getLeastNumbers_2(arr71, 10));

	}

}
