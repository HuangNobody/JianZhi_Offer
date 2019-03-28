/*
 *  ��ת������ص㣺
 *         1����ת֮���������Է�Ϊ��������������飬��ǰ����������Ԫ�ض����ڻ���ں����������Ԫ�ء�
 *         2����С�������Ԫ��λ������������ķֽ�
 * ����˼·�������������У�����ʹ�ö��ֲ��ҷ����в���
 * ������������ָ����м�ָ��Ԫ�ش�С��ϵ�ж��м�Ԫ����λ��ǰ��������黹�Ǻ���������飬��С���ҷ�Χ
 * ��Ҫ���ǵ�������
 *         1���������鱾�����Ǹ������һ����ת
 *         2��������������ظ�Ԫ�أ���ô�п��ܳ���������ָ��Ԫ�����м�Ԫ����ͬ���޷��ж��м�Ԫ������ǰ�������黹�Ǻ��������飬��ʱ��˳�����

 * �������������ǰ���0��Ԫ�ذᵽ����棬���������鱾������Ȼ�������һ����ת��
 * ��ʱ�������еĵ�һ�����־�����С�����֣�����ֱ�ӷ��أ������ ��indexMid��ʼ��Ϊindex1��ԭ��
 * 
 * ��һ��ָ�����ս�ָ��ǰ������������һ��Ԫ�أ����ڶ���ָ���ָ�����������ĵ�һ��Ԫ�ء�Ҳ�����������ջ�ָ������
 * ���ڵ�Ԫ�أ����ڶ���ָ��ָ��ĸ�������С��Ԫ�ء������ѭ��������������
 */
public class Offer08 {

	//����1
	public int minOfRotateArrays(int [] arrays) {
		if(arrays == null || arrays.length <= 0)
			//throw new RuntimeException("Invalid arrays");
			return 0;
		int index1 = 0;
		int index2 = arrays.length -1;
		int indexMid = index1;

		while(arrays[index1] >= arrays[index2]){
			if(index2 - index1 == 1){
				indexMid = index2;
				break;
			}
			
			indexMid = (index1 + index2)/2;
			//����±�Ϊindex1�� index2��indexMinָ�������������ȣ���ֻ��˳�����
			if(arrays[index1] == arrays[index2] && arrays[index1] == arrays[indexMid])
				return minInOrder(arrays, index1, index2);
			
			//��ת���鲿�����򣬿���ʹ�ö��ֲ���
			if(arrays[indexMid] >= arrays[index1])
				index1 = indexMid;
			else if(arrays[indexMid] <= arrays[index2])
				index2 = indexMid;
		}
		return arrays[indexMid];
	}

	//method 2, ţ��������֤�����о����ָ���
	public int minNumberInRotateArray(int [] array) {
		if(array == null || array.length==0)
			return 0;

		int left = 0;
		int right = array.length-1;

		while(left<right){
			int mid = left+(right-left)/2;
			if(array[mid]>array[right]){
				left = mid+1;
			}else if(array[mid] == array[right]){
				right = right -1;
			}else{
				right = mid;
			}
		}
		return array[left];
	}
	
	public int minInOrder(int [] arrays, int index1, int index2){//˳�����
		int result = arrays[index1];
		for(int i = index1+1; i<=index2;i++){
			if(result > arrays[i])
				result = arrays[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Offer08 of8 = new Offer08();
		//��������
		//1,���ܲ��ԣ�������������������������һ����ת�����������ظ����������û���ظ������֣�
		int [] array1 = {3,4,5,1,2};
		System.out.println("�������������һ����ת���飬���ظ����֣�"+ of8.minOfRotateArrays(array1));
		
		int [] array2 = {3,4,5,1,1,2};
		int [] array3 = {1,0,1,1,1};//�������һ���벻�����ر���Ҫ������������ַ�û�ã�ֻ����˳�����
		int [] array4 = {1,1,1,0,1};//�������һ���벻�����ر���Ҫ������������ַ�û�ã�ֻ����˳�����
		System.out.println("�������������һ����ת���飬���ظ����֣�"+ of8.minOfRotateArrays(array2));
		System.out.println("�������������һ����ת���飬���ظ����֣�"+ of8.minOfRotateArrays(array3));
		System.out.println("�������������һ����ת���飬���ظ����֣�"+ of8.minOfRotateArrays(array4));
		
		//2,�߽�ֵ���ԣ��������������һ��������������顢ֻ����һ�����ֵ����飩
		int [] array5 = {1,2,3,4,5};
		System.out.println("����������һ�������������飺"+ of8.minOfRotateArrays(array5));
		
		int [] array6 = {1};
		System.out.println("����������ֻ����һ�����ֵ����飺"+ of8.minOfRotateArrays(array6));
		
		//3������������ԣ�����NULLָ�룩
		int [] array7 = null;
		System.out.println("����NULLָ�룺"+ of8.minOfRotateArrays(array7));
	}
}
