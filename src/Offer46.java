public class Offer46 {

	//方法1
	/*
	解题思路：
	1.需利用逻辑与的短路特性实现递归终止。 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
	3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
	*/
	public int sum_1(int n){
		int sum = n;
		boolean ans = (n>0)&&((sum+=sum_1(n-1))>0);
		return sum;
	}
	
	//方法2
	public int sum_2(int n){
		int sum = n;
		boolean ans = (n==0)||((sum+=sum_2(n-1))==0);
		return sum;
	}
	
	public static void main(String[] args) {
		
		Offer46 of46 = new Offer46();
		
		//功能测试，1，输入5，求1+2+3+4+5
		int n1 = 5;
		//System.out.println(of46.sum_1(n1));
		System.out.println(of46.sum_2(n1));
		
		//功能测试，2，输入10，求1+2+3+4+5+...+10
		int n2 = 10;
		//System.out.println(of46.sum_1(n2));
		System.out.println(of46.sum_2(n2));
		
		//边界值测试，3，输入0
		int n3 = 0;
		//System.out.println(of46.sum_1(n3));
		System.out.println(of46.sum_2(n3));
		
		//边界值测试，4，输入1
		int n4 = 1;
		//System.out.println(of46.sum_1(n4));
		System.out.println(of46.sum_2(n4));

	}

}
