/*
问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
      从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
      从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
 */
public class Offer04 {
	//方法1
	public String replaceSpace(String str){
		if(str == null||str.length()<=0)//str == null判断字符串是个null指针，str.length()<=0判断字符串是空字符串
			return null;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<str.length();i++){
			if(String.valueOf(str.charAt(i)).equals(" ")){//String.valueOf（）：Returns the string representation of the char argument.
				sb.append("%20");
			}else{
				sb.append(str.charAt(i));
			}
		}
		return String.valueOf(sb);
	}
	
		//方法2,在牛客上通过了              面试时估计不行，不能用replace函数
	public String replaceSpace_2(StringBuffer str) {
		if(str == null || str.length() == 0)
			return null;
		for(int i = 0;i<str.length();i++){
			if(str.charAt(i) == ' '){
				//str.charAt(i) = '%20';
				str.replace(i,i+1,"%20");
				//start?-- 开始的索引（包括）。end?-- 结束索引（不包括）。str?-- 字符串，将取代以前的内容
			}
		}
		return str.toString();
	}

	//方法3，
	public String replaceSpace_3(StringBuffer str) {
		if(str == null )
			return null;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<str.length();i++){
			if(str.charAt(i) == ' '){
				sb.append("%20");
			}else{
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	//方法四
	//从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
	public String replaceSpace_4(String str){
		if(str == null)
			return null;

		char [] charArr = str.toCharArray();

		int countSpace = 0;//计算str中空格数量
		for(int i = 0;i<charArr.length;i++){
			if(str.charAt(i) == ' ')
				countSpace++;
		}
		char [] newCharArr = new char[charArr.length+2*countSpace];

		for(int i = charArr.length-1,j = newCharArr.length-1;i>=0&&j>=0;i--){
			if(charArr[i]!=' '){
				newCharArr[j--] = charArr[i];
			}else{
				newCharArr[j--] = '0';
				newCharArr[j--] = '2';
				newCharArr[j--] = '%';
			}
		}

		return String.valueOf(newCharArr);
	}
	
	public static void main(String[] args) {
		Offer04 of4 = new Offer04();

		//测试用例
		//1，输入的字符串中包含空格（空格位于字符串的最前面，空格位于字符串的最后面，空格位于字符串的中间，字符串中有连续多个空格）。
		String str1 = " We are happy.";
		System.out.println(of4.replaceSpace(str1));
		String str2 = "We are happy. ";
		System.out.println(of4.replaceSpace(str2));
		String str3 = "We  are happy.";
		System.out.println(of4.replaceSpace(str3));
		
		//2，输入的字符串中没有空格
		String str4 = "Wearehappy.";
		System.out.println(of4.replaceSpace(str4));
		
		//特殊输入测试（字符串是个null指针 、字符串是个空字符串、字符串只有一个空格字符、字符串只有连续多个空格）。
		String str5 = null;
		System.out.println(of4.replaceSpace(str5));
		
		String str6 = "";//""表示空字符串
		System.out.println(of4.replaceSpace(str6));
		String str7 = " ";//" "表示一个空格字符
		System.out.println(of4.replaceSpace(str7));
		String str8 = "   ";//" "表示3个空格字符
		System.out.println(of4.replaceSpace(str8));
		
	}
}
/**
 * StringBuilder a = new StringBuilder("we are happy.");
 * String b = " " + a;//将StringBuilder类型转换成String类型
 * StringBuilder a = new StringBuilder(a);//将String类型转换为StringBuilder类型
 *
 * 1.String对象不可变、StringBuffer对象可变的含义： 举个例子：String str = "aa"; str = "aa"+"bb";
 * 此时str的值为"aabb"，但是"aabb"不是在开始的字符串"aa"后面直接连接的"bb"，而是又新生成了字符串"aabb"，
 * 字符串"aa"一旦被初始化，那么它的值不可能再改变了。 StringBuffer strb = StringBuffer("aa");
 * strb.append("bb"); 此时的strb的值也为"aabb"，但是"aabb"是直接在开始的字符串"aa"后面连接的“bb”，并没有生成新的字符串。
 * */
