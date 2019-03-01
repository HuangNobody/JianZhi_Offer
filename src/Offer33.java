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
		
		/*在基本数据中，compareTo()是比较两个Character 对象；在 Boolean中，是用boolean的实例于其它实例进行比较；
		在String 中，则是按照字典顺序进行比较，返回的值是一个int 型。*/
		
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
		
		//功能测试，1，输入的数组中有多个数字
		int [] array11 = {3,32,321};
		System.out.println("1，最小的数字组合是： "+of33.printMinNumber(array11));
		
		//功能测试，2，输入的数组中的数字有重复的数位
		int [] array21 = {3,32,321,32};
		System.out.println("2，最小的数字组合是： "+of33.printMinNumber(array21));
		
		//功能测试，3，输入的数组中的数字只有一个数字
		int [] array31 = {32};
		System.out.println("3，最小的数字组合是： "+of33.printMinNumber(array31));
		
		//特殊输入测试，4，表示数组的指针为NULL
		int [] array41 = null;
		System.out.println("4，最小的数字组合是： "+of33.printMinNumber(array41));

	}

}
