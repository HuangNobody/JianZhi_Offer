import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Offer45 {

	//方法1
	public int lastRemaining(int n, int m){
		if(n<1 ||m<1)
			return -1;
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<n;i++)
			list.add(i);
		
		int current = 0;//从1到m计数
		int currentSize = n;//用以记录链表中元素的个数
		
		Iterator<Integer> iterator = list.iterator();
		while(currentSize>1){
			for(current = 1;current<=m;current++){
				if(iterator.hasNext())
					iterator.next();
				else{//到链表末尾
					iterator = list.iterator();
					iterator.next();
				}
			}
			iterator.remove();
			currentSize--;
		}
		iterator = list.iterator();
		return iterator.next();
	}
	
	//方法2，确实很牛逼，但是我肯定自己想不出来
	public int lastRemaining_2(int n, int m){
		if(n<1 || m<1)
			return -1;
		int last = 0;
		for(int i = 2;i<=n;i++)
			last = (last + m)%i;
		return last;
	}
	
	public static void main(String[] args) {

		Offer45 of45 = new Offer45();
		
		//功能测试，1，输入的m<n
		int n1 = 5;
		int m1 = 3;
		//System.out.println(of45.lastRemaining(n1, m1));
		System.out.println(of45.lastRemaining_2(n1, m1));
		
		//功能测试，2，输入的m<n
		int n2= 5;
		int m2 = 2;
		//System.out.println(of45.lastRemaining(n2, m2));
		System.out.println(of45.lastRemaining_2(n2, m2));
		
		//功能测试，3，输入的m=n
		int n3 = 5;
		int m3 = 5;
		//System.out.println(of45.lastRemaining(n3, m3));
		System.out.println(of45.lastRemaining_2(n3, m3));
		
		//功能测试，4，输入的m>n
		int n4 = 5;
		int m4 = 6;
		//System.out.println(of45.lastRemaining(n4, m4));
		System.out.println(of45.lastRemaining_2(n4, m4));
		
		//特殊输入测试，5，圆圈中有0个数字
		int n5 = 0;
		int m5 = 6;
		//System.out.println(of45.lastRemaining(n5, m5));
		System.out.println(of45.lastRemaining_2(n5, m5));
		
		//性能测试，6，n=4000,m=997
		int n6 = 4000;
		int m6 = 997;
		//System.out.println(of45.lastRemaining(n6, m6));
		System.out.println(of45.lastRemaining_2(n6, m6));

	}

}
