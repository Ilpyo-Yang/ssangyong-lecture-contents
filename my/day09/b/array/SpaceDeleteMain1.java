package my.day09.b.array;

public class SpaceDeleteMain1 {

	public static void main(String[] args) {

		//=== �Ի繮�� : ���ڿ� �� ���� �����ϱ� === //
		String str = "  korea   seou l �ֿ� ���� ��������  ";
		
		char[] chArr = str.toCharArray();

		//------------------------------------------------------------------------------
		//|' '|' '|k|o|r|e|a|' '|' '|' '|s|e|o|u|' '|l|' '|��|��|' '|��|��|' '|��|��|��|��|
		//------------------------------------------------------------------------------
		
		int len = 0;
		
		for (int i=0; i<chArr.length; i++) {
			if(chArr[i]!=' ') {
				len++;
			}
		}
		
		char[] resultchArr = new char[len];
	
		for(int i=0, j=0; i<chArr.length; i++, j++) {
			if(chArr[i] !=' ') {
				resultchArr[j] = chArr[i];
			} else j--;
		}
		
		//-----------------------------------------
		//|k|o|r|e|a|s|e|o|u|l|��|��|��|��|��|��|��|��|
		//-----------------------------------------
		
		System.out.println(String.valueOf(resultchArr));
		
		//"koreaseoul�ֿ밭�ϱ�������";
		
		//ArrayIndexOutOfBondsException => �迭ũ�⸦ �ʰ��ϴ� ��� �߻��ϴ� ����!

	}

}
