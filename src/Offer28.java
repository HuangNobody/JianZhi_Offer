

import java.util.Scanner;

public class Offer28 {
	
	public static void permutation(char [] str){
		if(str == null)
			return;
		permutation(str, 0);
	}
	
	public static void permutation(char[] str, int begin) {
		if(begin == str.length)
			System.out.println(str);
		else{
			for(int i = begin; i<str.length;i++){
				char temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;
				
				permutation(str, begin+1);//���õݹ���ã�ÿ��begin+1�� �����µĵݹ�
				
				/*����һ����ٽ���һ�Σ��ܹ���֤���ĵ��Ļ���ԭ���飬�ð취��*/
				temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		//���ܲ��ԣ�1����������ַ����ж���ַ�
		//2��������ַ���ֻ��һ���ַ�
		//3������������ԣ�������ַ�������Ϊ��
		//4������������ԣ�nullָ��
		
		System.out.println("������һ���ַ����� ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char [] arr = new char[str.length()];
		arr = str.toCharArray();
		permutation(arr);
		
		

	}

}
