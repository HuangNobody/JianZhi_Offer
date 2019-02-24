
public class Offer_04 {
	public String replaceSpace(String str){
		if(str == null||str.length()<=0)//str == null�ж��ַ����Ǹ�nullָ�룬str.length()<=0�ж��ַ����ǿ��ַ���
			return null;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<str.length();i++){
			if(String.valueOf(str.charAt(i)).equals(" ")){//String.valueOf������Returns the string representation of the char argument.
				sb.append("%20");
			}else{
				sb.append(str.charAt(i));
			}
		}
		return String.valueOf(sb);
	}
	public static void main(String[] args) {
		Offer_04 of4 = new Offer_04();

		//��������
		//1��������ַ����а����ո񣨿ո�λ���ַ�������ǰ�棬�ո�λ���ַ���������棬�ո�λ���ַ������м䣬�ַ���������������ո񣩡�
		String str1 = " We are happy.";
		System.out.println(of4.replaceSpace(str1));
		String str2 = "We are happy. ";
		System.out.println(of4.replaceSpace(str2));
		String str3 = "We  are happy.";
		System.out.println(of4.replaceSpace(str3));
		
		//2��������ַ�����û�пո�
		String str4 = "Wearehappy.";
		System.out.println(of4.replaceSpace(str4));
		
		//����������ԣ��ַ����Ǹ�nullָ�� ���ַ����Ǹ����ַ������ַ���ֻ��һ���ո��ַ����ַ���ֻ����������ո񣩡�
		String str5 = null;
		System.out.println(of4.replaceSpace(str5));
		
		String str6 = "";//""��ʾ���ַ���
		System.out.println(of4.replaceSpace(str6));
		String str7 = " ";//" "��ʾһ���ո��ַ�
		System.out.println(of4.replaceSpace(str7));
		String str8 = "   ";//" "��ʾ3���ո��ַ�
		System.out.println(of4.replaceSpace(str8));
		
	}
}
/**
 * StringBuilder a = new StringBuilder("we are happy.");
 * String b = " " + a;//��StringBuilder����ת����String����
 * StringBuilder a = new StringBuilder(a);//��String����ת��ΪStringBuilder����
 * */
