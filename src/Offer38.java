public class Offer38 {

	public int getFirstK(int [] data, int k, int start, int end){
		if(start>end)
			return -1;//������
		int mid = start+(end-start)/2;
		
		if(data[mid] == k){
			if((mid>0 && data[mid-1]!=k) || mid ==0)
					return mid;
			end = mid-1;
		}else if(data[mid]>k)
			end = mid -1;
		else
			start = mid+1;
		
		return getFirstK(data, k, start, end);
	}
	
	public int getLastK(int [] data, int k, int start, int end){
		if(start>end)
			return -1;
		
		int mid = start+((end-start)>>1);
		
		if(data[mid] == k){
			if((mid<end&& data[mid+1]!=k) || mid == end)
				return mid;
			start = mid+1;
		}else if(data[k] <k)
			start =mid +1;
		else
			end = mid-1;
		
		return getLastK(data, k, start, end);
	}
	
	public int getNumberOfK(int [] data, int length, int k){
		if(data == null || length <=0)
			return 0;
		int number = 0;
		int start = 0;
		int end = length-1;
		int firstK = getFirstK(data, k, 0, length-1);
		int lastK = getLastK(data, k, 0, length-1);
		if(firstK >-1 && lastK>-1)
			number = lastK-firstK+1;
		return number;
	}
	
	public static void main(String[] args) {
		
		Offer38 of38 = new Offer38();
		
		//���ܲ��ԣ�1�������а������ҵ����֣����ֶ��
		int [] data1 = {1,2,3,3,3,3,4,5};
		int k1 = 3;
		int length1 = data1.length;
		System.out.println("����1��"+k1+"���ֵĴ����� "+of38.getNumberOfK(data1, length1, k1));
		
		//���ܲ��ԣ�2��������û�в��ҵ�����
		int [] data2 = {1,2,3,3,3,3,4,5};
		int k2 = 6;
		int length2 = data2.length;
		System.out.println("����2��"+k2+"���ֵĴ����� "+of38.getNumberOfK(data2, length2, k2));
		
		//���ܲ��ԣ�3�������а������ҵ����֣����ֶ��
		int [] data3 = {1,2,3,3,3,3,4,5};
		int k3 = 5;
		int length3 = data3.length;
		System.out.println("����3��"+k3+"���ֵĴ����� "+of38.getNumberOfK(data3, length3, k3));
		
		//�߽�ֵ���ԣ�4�����������е����ֵ
		int [] data4 = {1,2,3,3,3,3,4,5};
		int k4 = 5;
		int length4 = data4.length;
		System.out.println("����4��"+k4+"���ֵĴ����� "+of38.getNumberOfK(data4, length4, k4));
		
		//�߽�ֵ���ԣ�5�����������е���Сֵ
		int [] data5 = {1,2,3,3,3,3,4,5};
		int k5 = 1;
		int length5 = data5.length;
		System.out.println("����5��"+k5+"���ֵĴ����� "+of38.getNumberOfK(data5, length5, k5));
		
		//�߽�ֵ���ԣ�6��������ֻ������
		int [] data6 = {7};
		int k6 = 7;
		int length6 = data6.length;
		System.out.println("����6��"+k6+"���ֵĴ����� "+of38.getNumberOfK(data6, length6, k6));
		
		//����������ԣ�7����ʾ�����ָ��ΪNULL
		//int [] data7 = null;
		//int k7 = 7;
		//int length7 = data7.length;
		//System.out.println("����6��"+k6+"���ֵĴ����� "+of38.getNumberOfK(data7, length7, k7));

	}

}
