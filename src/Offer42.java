public class Offer42 {
	
	//����1����ת����˳��
	//����1
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
		reverse(chars, 0, length);// �Ȱ������ַ���������
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
		return String.valueOf(chars);//���ַ��������ַ�������ʽ���
	}
	
	//����2
	public String reverseSentence_2(String str){
		if(str == null || str.length()<2)
			return str;
		char [] chars = str.toCharArray();
		int length = chars.length-1;
		reverse(chars, 0, length);// �Ȱ������ַ���������
		int begin = 0;
		int end = 0;
		while(begin<length){
			if(chars[begin] == ' '){//�ո�
				begin++;
				end++;
			}else if(end == chars.length || chars[end] == ' '){//�ж�end�Ƿ��ҵ��˾��ӵĿ�ͷ�����Ƿ��˾��ӵĽ�β
				reverse(chars, begin, end-1);
				end++;//end��������ƶ�
				begin = end;//�ѿո񴦸���start����start����ָ����һ�����ʵĿ�ʼ
			}else
				end++;
		}
		return String.valueOf(chars);
	} 
	
	//����3
	public String reverseSentence_3(String str){
		StringBuilder sb = new StringBuilder("");
		if(str==null||str.length()<=0|| str.trim().equals("")){//trim()�����ַ����ĸ�����ʡ��ǰ����β��ո�
			return str;
		}
		String [] strSet = str.split(" ");//���˿ո�
		int length = strSet.length;
		for(int i = length-1;i>0;i--){
			sb.append(strSet[i]+" ");
		}
		sb.append(strSet[0]);
		return sb.toString();
	}
	
	//����2
	public String leftRotateString(String str, int n){
		if(str == null || n<=0 || n>str.length()|| str.length()<2)
			return str;
		char [] chars = str.toCharArray();
		int length = chars.length;
		reverse(chars, 0, n-1);// ��תǰn���ַ�
		reverse(chars, n, length-1);// ��ת������ַ�
		reverse(chars, 0, length-1);// ��ת�����ַ���
		return String.valueOf(chars);
	}
	
	public static void main(String[] args) {
		
		Offer42 of42 = new Offer42();
		/*
		//���ܲ��ԣ�1���������ж������
		String str1 = "I am a student.";
		//System.out.println(of42.reverseSentence(str1));
		//System.out.println(of42.reverseSentence_2(str1));
		System.out.println(of42.reverseSentence_3(str1));
		
		//���ܲ��ԣ�2��������ֻ��һ������
		String str2 = "student";
		//System.out.println(of42.reverseSentence(str2));
		//System.out.println(of42.reverseSentence_2(str2));
		System.out.println(of42.reverseSentence_3(str2));
		
		//����������ԣ�3���ַ���ָ��ΪNULLָ��
		String str3 = null;
		//System.out.println(of42.reverseSentence(str3));
		//System.out.println(of42.reverseSentence_2(str3));
		System.out.println(of42.reverseSentence_3(str3));
		
		//����������ԣ�4���ַ�������Ϊ��
		String str4 = "";
		//System.out.println(of42.reverseSentence(str4));
		//System.out.println(of42.reverseSentence_2(str4));
		System.out.println(of42.reverseSentence_3(str4));
		
		//����������ԣ�5���ַ�������ֻ�пո�
		String str5 = "   ";
		//System.out.println(of42.reverseSentence(str5));
		//System.out.println(of42.reverseSentence_2(str5));
		System.out.println(of42.reverseSentence_3(str5));
	*/
		//���ܲ��ԣ�1���ѳ���Ϊn���ַ�������ת0���ַ�
		String str1 = "abcdefg";
		int n1 = 0;
		System.out.println(of42.leftRotateString(str1, n1));
		
		//���ܲ��ԣ�2���ѳ���Ϊn���ַ�������ת1���ַ�
		String str2 = "abcdefg";
		int n2 = 1;
		System.out.println(of42.leftRotateString(str2, n2));
		
		//���ܲ��ԣ�3���ѳ���Ϊn���ַ�������ת3���ַ�
		String str3 = "abcdefg";
		int n3 = 2;
		System.out.println(of42.leftRotateString(str3, n3));
		
		//���ܲ��ԣ�4���ѳ���Ϊn���ַ�������תn-1���ַ�
		String str4 = "abcdefg";
		int n4 = str4.length()-1;
		System.out.println(of42.leftRotateString(str4, n4));
		
		//���ܲ��ԣ�5���ѳ���Ϊn���ַ�������תn���ַ�
		String str5 = "abcdefg";
		int n5 = str4.length();
		System.out.println(of42.leftRotateString(str5, n5));
		
		//���ܲ��ԣ�6���ѳ���Ϊn���ַ�������תn+1���ַ�
		String str6 = "abcdefg";
		int n6 = str4.length()+1;
		System.out.println(of42.leftRotateString(str6, n6));
		
		//����������ԣ�7���ַ�����ָ��ΪNULL
		String str7 = null;
		int n7 = str4.length();
		System.out.println(of42.leftRotateString(str7, n7));
	}
}
