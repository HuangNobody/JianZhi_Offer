public class Offer40 {
	
	public void findNumsAppearOnce(int [] data){
		if(data == null || data.length<2)
			return;
		
		int resultExclusiveOR = 0;
		int nums1 =0;
		int nums2 = 0;
		for(int i = 0;i<data.length;i++)
			resultExclusiveOR ^= data[i];
		
		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		
		for(int j = 0;j<data.length;j++){
			if(isBit1(data[j],indexOf1))
				nums1 ^= data[j];
			else
				nums2 ^= data[j];
		}
		System.out.print(nums1+", ");
		System.out.print(nums2+", ");
		System.out.println();
	}
	
	//判断在num的二进制表示中从右边数起的indexBit位是不是1
	public boolean isBit1(int num, int indexBit) {
		num = num>>indexBit;
		return (num & 1)==0;
	}

	//用来在整数num的二进制表示中找到最右边是1的位
	public int findFirstBitIs1(int num) {
		int indexBit = 0;
		while((num & 1)==0){
			num = num>>1;
			indexBit++;
		}
		return indexBit;
	}
	
	public static void main(String[] args) {
		
		Offer40 of40 = new Offer40();
		
		//功能测试，1，数组中多对重复的数字
		int [] data = {2,4,3,6,3,2,5,5};
		of40.findNumsAppearOnce(data);
		
		//功能测试，2，数组中没有重复的数字
		int [] data2 ={1,2};//最多只能有两个不同的数字，题目里限制了
		of40.findNumsAppearOnce(data2);
	}

}
