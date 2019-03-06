public class Offer42 {
	
	//问题1，翻转单词顺序
	//方法1
	public void reverse(char [] data, int begin, int end){
		if(data == null || end-begin<1|| data.length<2)
			return;
		while(begin<end){
			char temp = data[begin];
			data[begin] = data[end];
			data[end] = temp;
			begin++;
			end--;
		}
	}
	
	public String reverseSentence(String str){
		if(str == null || str.length()<2)
			return str;
		char [] chars = str.toCharArray();
		int length = chars.length-1;
		reverse(chars, 0, length);// 先把整个字符串反过来
		int begin = 0;
		int end = 0;
		while(end <length){
			if(chars[end] == ' '){
				reverse(chars, begin, end-1);
				begin = end+1;
			}
			end++;
		}
		reverse(chars, begin, end);
		return String.valueOf(chars);//将字符数组以字符串的形式输出
	}
	
	//方法2
	public String reverseSentence_2(String str){
		if(str == null || str.length()<2)
			return str;
		char [] chars = str.toCharArray();
		int length = chars.length-1;
		reverse(chars, 0, length);// 先把整个字符串反过来
		int begin = 0;
		int end = 0;
		while(begin<length){
			if(chars[begin] == ' '){//空格
				begin++;
				end++;
			}else if(end == chars.length || chars[end] == ' '){//判断end是否找到了句子的开头或者是否到了句子的结尾
				reverse(chars, begin, end-1);
				end++;//end继续向后移动
				begin = end;//把空格处赋给start，让start重新指向下一个单词的开始
			}else
				end++;
		}
		return String.valueOf(chars);
	} 
	
	//方法3
	public String reverseSentence_3(String str){
		StringBuilder sb = new StringBuilder("");
		if(str==null||str.length()<=0|| str.trim().equals("")){//trim()返回字符串的副本，省略前导和尾随空格。
			return str;
		}
		String [] strSet = str.split(" ");//过滤空格
		int length = strSet.length;
		for(int i = length-1;i>0;i--){
			sb.append(strSet[i]+" ");
		}
		sb.append(strSet[0]);
		return sb.toString();
	}
	
	//问题2
	public String leftRotateString(String str, int n){
		if(str == null || n<=0 || n>str.length()|| str.length()<2)
			return str;
		char [] chars = str.toCharArray();
		int length = chars.length;
		reverse(chars, 0, n-1);// 翻转前n个字符
		reverse(chars, n, length-1);// 翻转后面的字符
		reverse(chars, 0, length-1);// 翻转整个字符串
		return String.valueOf(chars);
	}
	
	public static void main(String[] args) {
		
		Offer42 of42 = new Offer42();
		/*
		//功能测试，1，句子中有多个单词
		String str1 = "I am a student.";
		//System.out.println(of42.reverseSentence(str1));
		//System.out.println(of42.reverseSentence_2(str1));
		System.out.println(of42.reverseSentence_3(str1));
		
		//功能测试，2，句子中只有一个单词
		String str2 = "student";
		//System.out.println(of42.reverseSentence(str2));
		//System.out.println(of42.reverseSentence_2(str2));
		System.out.println(of42.reverseSentence_3(str2));
		
		//特殊输入测试，3，字符串指针为NULL指针
		String str3 = null;
		//System.out.println(of42.reverseSentence(str3));
		//System.out.println(of42.reverseSentence_2(str3));
		System.out.println(of42.reverseSentence_3(str3));
		
		//特殊输入测试，4，字符串内容为空
		String str4 = "";
		//System.out.println(of42.reverseSentence(str4));
		//System.out.println(of42.reverseSentence_2(str4));
		System.out.println(of42.reverseSentence_3(str4));
		
		//特殊输入测试，5，字符串内容只有空格
		String str5 = "   ";
		//System.out.println(of42.reverseSentence(str5));
		//System.out.println(of42.reverseSentence_2(str5));
		System.out.println(of42.reverseSentence_3(str5));
	*/
		//功能测试，1，把长度为n的字符串左旋转0个字符
		String str1 = "abcdefg";
		int n1 = 0;
		System.out.println(of42.leftRotateString(str1, n1));
		
		//功能测试，2，把长度为n的字符串左旋转1个字符
		String str2 = "abcdefg";
		int n2 = 1;
		System.out.println(of42.leftRotateString(str2, n2));
		
		//功能测试，3，把长度为n的字符串左旋转3个字符
		String str3 = "abcdefg";
		int n3 = 2;
		System.out.println(of42.leftRotateString(str3, n3));
		
		//功能测试，4，把长度为n的字符串左旋转n-1个字符
		String str4 = "abcdefg";
		int n4 = str4.length()-1;
		System.out.println(of42.leftRotateString(str4, n4));
		
		//功能测试，5，把长度为n的字符串左旋转n个字符
		String str5 = "abcdefg";
		int n5 = str4.length();
		System.out.println(of42.leftRotateString(str5, n5));
		
		//功能测试，6，把长度为n的字符串左旋转n+1个字符
		String str6 = "abcdefg";
		int n6 = str4.length()+1;
		System.out.println(of42.leftRotateString(str6, n6));
		
		//特殊输入测试，7，字符串的指针为NULL
		String str7 = null;
		int n7 = str4.length();
		System.out.println(of42.leftRotateString(str7, n7));
	}
}
