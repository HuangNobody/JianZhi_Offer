import java.util.Arrays;
import java.util.Comparator;

public class Offer33 {
	
	public String printMinNumber(int [] numbers){
		if(numbers == null || numbers.length<=0)
			return null;//null
		int length = numbers.length;
		String[] str = new String[length];
		StringBuilder stringbuilder = new StringBuilder();
		for(int i = 0;i<length;i++)                 //valueOf(char[] data)
			str[i] = String.valueOf(numbers[i]);//Returns the string representation of the char array argument.
		
		/*�ڻ��������У�compareTo()�ǱȽ�����Character ������ Boolean�У�����boolean��ʵ��������ʵ�����бȽϣ�
		��String �У����ǰ����ֵ�˳����бȽϣ����ص�ֵ��һ��int �͡�*/
		
		Arrays.sort(str, new Comparator<String>(){
			public int compare(String s1, String s2){
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);
			}
		});
		
		for(int i = 0;i< length;i++)
			stringbuilder.append(str[i]);
		
		return stringbuilder.toString();
	}
	
	public static void main(String[] args) {

		Offer33 of33 = new Offer33();
		
		//���ܲ��ԣ�1��������������ж������
		int [] array11 = {3,32,321};
		System.out.println("1����С����������ǣ� "+of33.printMinNumber(array11));
		
		//���ܲ��ԣ�2������������е��������ظ�����λ
		int [] array21 = {3,32,321,32};
		System.out.println("2����С����������ǣ� "+of33.printMinNumber(array21));
		
		//���ܲ��ԣ�3������������е�����ֻ��һ������
		int [] array31 = {32};
		System.out.println("3����С����������ǣ� "+of33.printMinNumber(array31));
		
		//����������ԣ�4����ʾ�����ָ��ΪNULL
		int [] array41 = null;
		System.out.println("4����С����������ǣ� "+of33.printMinNumber(array41));

	}

}
