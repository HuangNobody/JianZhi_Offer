import java.util.LinkedHashMap;

public class Offer35 {

	//����1������ʵ�ֹ�ϣ��
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
 * LinkedHashMap�������ǳ��ˣ�����Ȼ������ʱ��Ϳռ��ϵĿ���������ͨ��ά��һ��������������Ŀ��˫������
 * LinkedHashMap��֤��Ԫ�ص�����˳�򡣸õ���˳������ǲ���˳������Ƿ���˳��	
 */
	//����2
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
		
		//���ܲ��ԣ�1���ַ����д���ֻ����һ�ε��ַ�
		String str1 = "abaccdeff";
		System.out.println("����1,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar(str1));
		System.out.println("����1,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar_2(str1));
		
		//���ܲ��ԣ�2���ַ����в�����ֻ����һ�ε��ַ�
		String str2 = "aaab";//abacbdcdeeff
		System.out.println("����2,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar(str2));
		System.out.println("����2,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar_2(str2));
		
		//���ܲ��ԣ�3���ַ����������ַ�ֻ����һ��
		String str3 = "abcDFRG";//abacbdcdeeff
		System.out.println("����3,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar(str3));
		System.out.println("����3,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar_2(str3));
		
		//����������ԣ�4,�ַ���ΪNULLָ��
		String str4 = null;//abacbdcdeeff
		System.out.println("����4,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar(str4));
		System.out.println("����4,��һ��ֻ����һ�ε��ַ���λ��Ϊ��  "+of35.firstNotReaptingChar_2(str4));

	}

}
