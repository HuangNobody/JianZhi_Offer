
public class Offer03 {
	
	public boolean Find(int [][] arrays, int target){
		if(arrays == null){
			return false;
		}
		int row = 0;
		int column = arrays[0].length-1;
		
		while(row<arrays.length && column>=0){
			if(arrays[row][column] == target){
				return true;
			}else if(arrays[row][column]>target){
				column--;
			}else{
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]arrays = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		Offer03 of03 = new Offer03();
		//��������
		//1����ά�����а������ҵ����֣����ҵ������������е����ֵ����Сֵ�����ҵ����ֽ��������е����ֵ����Сֵ֮�䣩
		int target1 = 15;
		int target2 = 1;
		int target3 = 7;
		System.out.println(of03.Find(arrays, target1));
		System.out.println(of03.Find(arrays, target2));
		System.out.println(of03.Find(arrays, target3));
		
		//2����ά������û�в��ҵ����֣����ҵ����ִ��������е����ֵ�����ҵ�����С�������е���Сֵ��
		//���ҵ���������������ֵ����Сֵ֮�䵫��������û��������֣�
		int target4 = 16;
		int target5 = 0;
		int target6 = 3;
		System.out.println(of03.Find(arrays, target4));
		System.out.println(of03.Find(arrays, target5));
		System.out.println(of03.Find(arrays, target6));
		
		//3������������ԣ������ָ�룩
		int target7 = 7;
		int [][] arrays_2 = null;
		System.out.println(of03.Find(arrays_2, target7));
	}
}
