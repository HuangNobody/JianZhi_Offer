import java.util.Arrays;

public class Offer44 {

	public boolean isContinuous(int [] numbers){
		if(numbers == null || numbers.length<1)
			return false;
		
		Arrays.sort(numbers);//这里也可以用其他的排序算法
		
		int numberOfZero = 0;
		int numberOfGap = 0;
		//统计数组中0 个数
		for(int i = 0;i<numbers.length&& numbers[i]==0;i++)
			numberOfZero++;
		//统计数组中的间隔数目
		int small = numberOfZero;
		int big = small +1;
		while(big<numbers.length){
			//两个数字相等，有对子，不可能是顺子
			if(numbers[small] == numbers[big])
				return false;
			
			numberOfGap += numbers[big] - numbers[small] -1;
			small = big;
			big++;
		}
		
		return (numberOfGap > numberOfZero) ? false:true;
	}
	
	public static void main(String[] args) {
		
		Offer44 of44 = new Offer44();
		
		//功能测试，1，抽出的牌中有一个大小王
		int [] num1 = {1,3,4,7,0};
		System.out.println(of44.isContinuous(num1));

		//功能测试，2，抽出的牌中有2个大小王
		int [] num2 = {1,0,4,5,0};
		System.out.println(of44.isContinuous(num2));
		
		//功能测试，3，抽出的牌中没有大小王
		int [] num3 = {1,3,4,5,6};
		System.out.println(of44.isContinuous(num3));
		
		//功能测试，4，抽出的牌中有对子
		int [] num4 = {1,3,3,5,4};
		System.out.println(of44.isContinuous(num4));
		
		//特殊输入测试 ，输入NULL指针
		int [] num5 = null;
		System.out.println(of44.isContinuous(num5));
	}

}
