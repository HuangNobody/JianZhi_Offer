public class Offer49 {

	public int strToInt(String str){
		if(str == null || str.length() == 0 || hasNonNumerical(str))
			return 0;// ����ַ���Ϊ�ղ��Ұ����������ַ�
		
		// ��ʱ���ַ����϶��������ַ���
		// ��Ϊ����ֵ�޶�Ϊint�ͣ��������迼�Ǵ�������
		char firstChar = str.charAt(0);
		int sumExcludeFirst = 0;// �Ƚ�����һλ������ת��������
		int sum = 0;
		for(int i = 1;i<str.length();i++){
			char c = str.charAt(i);// �ó���ǰ�ַ�
			int convert = c-'0';//���ַ�ת��������
			
			if(firstChar =='+'&& sum<=Integer.MAX_VALUE)
				sum += convert*Math.pow(10, str.length()-1-i);
			
			if(firstChar == '-'&& sum >=Integer.MIN_VALUE)
				sum -= convert*Math.pow(10, str.length()-1-i);
			
			if(firstChar >='0'&&firstChar <='9'&& sum<=Integer.MAX_VALUE)
				sum += convert *Math.pow(10, str.length()-1-i);
		}
		
		int first = firstChar - '0';//���ַ�ת��������
		if(firstChar >= '0'&& firstChar <= '9')
			sum += first*Math.pow(10, str.length()-1);
		if(sum>Integer.MAX_VALUE ||sum < Integer.MIN_VALUE)
			return 0;
		
		return sum;
	}
	
	// �ж�һ���ַ�������һ���ַ����Ƿ�����������ַ�����һ���ַ�������+�����ǡ�
	public boolean hasNonNumerical(String str) {
		int length = str.length();
		
		// ȡ����0λ������0λ��������ֻ�����+�������������������ֱ�ӷ���false
		char c = str.charAt(0);
		if((c>='0'&&c<='9') || (c=='+') || (c=='-')){// �б�Ҫ����֮��ı���
			for(int i = 1;i<length;i++){
				c = str.charAt(i);// ȡ����ǰ�ַ�
				if(c<'0'||c>'9')
					return true;// ֤�������������ַ���ֱ������ѭ��������false
			}
		}else
			return true;// ��λ�Ͱ�������������ķ������ַ�
		
		return false;
	}

	public static void main(String[] args) {
		
		Offer49 of49 = new Offer49();
		
		//���ܲ��ԣ�1��������ַ�����ʾ����
		String str1 = "123";
		System.out.println(of49.strToInt(str1));
		
		//���ܲ��ԣ�2��������ַ�����ʾ����
		String str2 = "+123";
		System.out.println(of49.strToInt(str2));
		
		//���ܲ��ԣ�3��������ַ�����ʾ����
		String str3 = "-123";
		System.out.println(of49.strToInt(str3));
		
		//���ܲ��ԣ�4��������ַ�����ʾ0
		String str4 = "0";
		System.out.println(of49.strToInt(str4));
		
		//�߽�ֵ���ԣ�5������������
		String str5 = "Integer.MAX_VALUE";
		System.out.println(of49.strToInt(str5));
		
		//�߽�ֵ���ԣ�6����С�ĸ�����
		String str6 = "Integer.MIN_VALUE";
		System.out.println(of49.strToInt(str6));
		
		//����������ԣ�7�������ַ���ΪNULLָ��
		String str7 = null;
		System.out.println(of49.strToInt(str7));
		
		//����������ԣ�8�������ַ���Ϊ���ַ���
		String str8 = "";
		System.out.println(of49.strToInt(str8));
		
		//����������ԣ�8�������ַ����з������ַ�
		String str9 = "+123-=";
		System.out.println(of49.strToInt(str9));

	}

}
