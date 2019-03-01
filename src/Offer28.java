

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
				
				permutation(str, begin+1);//采用递归调用，每次begin+1后 带入新的递归
				
				/*交换一遍后再交换一次，能够保证最后的到的还是原数组，好办法！*/
				temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		//功能测试，1，（输入的字符串有多个字符
		//2，输入的字符串只有一个字符
		//3，特殊输入测试，输入的字符串内容为空
		//4，特殊输入测试，null指针
		
		System.out.println("请输入一个字符串： ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char [] arr = new char[str.length()];
		arr = str.toCharArray();
		permutation(arr);
		
		

	}

}
