import java.util.LinkedHashMap;

public class Offer35 {

	//方法1，数组实现哈希表
	public int firstNotReaptingChar(String str){
		int index = 0;
		if(str == null){
			return -1;
		}

		
		char [] charArray = str.toCharArray();
		int [] count = new int[52];
		
		for(int i = 0;i<charArray.length;i++){
			if(charArray[i] >= 65 && charArray[i]<=90)
				count[charArray[i]-65]++;
			
			if(charArray[i]>=97&& charArray[i]<=122)
				count[charArray[i]-71]++;
		}
		
		for(int i = 0;i<charArray.length;i++){
			if(charArray[i]>=65 && charArray[i]<=90)
				if(count[charArray[i]-65] == 1){
					index = i;
					break;
				}
			if(charArray[i]>=97 && charArray[i]<=122)
				if(count[charArray[i]-71] == 1){
					index = i;
					break;
				}
		}
		return index;
	}
	
/*
 * LinkedHashMap就闪亮登场了，它虽然增加了时间和空间上的开销，但是通过维护一个运行于所有条目的双向链表，
 * LinkedHashMap保证了元素迭代的顺序。该迭代顺序可以是插入顺序或者是访问顺序。	
 */
	//方法2
	public Character firstNotReaptingChar_2(String str){
		if(str == null)
			return null;
		char [] strChar = str.toCharArray();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(char item : strChar){
			if(map.containsKey(item))
				map.put(item, map.get(item)+1);
			else
				map.put(item, 1);
		}
		for(char key:map.keySet()){
			if(map.get(key) == 1)
				return key;
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		
		Offer35 of35 = new Offer35();
		
		//功能测试，1，字符串中存在只出现一次的字符
		String str1 = "abaccdeff";
		System.out.println("测试1,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar(str1));
		System.out.println("测试1,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar_2(str1));
		
		//功能测试，2，字符串中不存在只出现一次的字符
		String str2 = "aaab";//abacbdcdeeff
		System.out.println("测试2,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar(str2));
		System.out.println("测试2,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar_2(str2));
		
		//功能测试，3，字符串中所有字符只出现一次
		String str3 = "abcDFRG";//abacbdcdeeff
		System.out.println("测试3,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar(str3));
		System.out.println("测试3,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar_2(str3));
		
		//特殊输入测试，4,字符串为NULL指针
		String str4 = null;//abacbdcdeeff
		System.out.println("测试4,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar(str4));
		System.out.println("测试4,第一个只出现一次的字符的位置为：  "+of35.firstNotReaptingChar_2(str4));

	}

}
