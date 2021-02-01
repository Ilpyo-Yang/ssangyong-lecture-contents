package my.day19.e.ENUM;

public enum EnteranceFee_2 {
      
   // !!! ����� ������ ��� CHILD, TEENAGER, ADULT, OLD �ϳ� �ϳ��� EntranceFee_2 ��ü��� ���̴�.!!!
   // ��ü������ �� ���ɴ뺰 ���αݾ�(�߻�޼ҵ� ���� ��ü ������ �ݵ�� ������ �ϵ��� �����ϴ� ����)�� �޸� �����Ͽ� ���� ����� �ݾ��� ����ϵ��� �Ѵ�.
   
   CHILD(0){
      @Override
      int getRealFee(int inwonsu) {
         return 0;
      }
   }, 
   
   TEENAGER(150){
      @Override
      int getRealFee(int inwonsu) {
         if(inwonsu >= 20)
            return (int)(DEFAULT_FEE*inwonsu*0.8);
         else
            return DEFAULT_FEE*inwonsu;
      }
   }, 
   
   ADULT(300){
      @Override
      int getRealFee(int inwonsu) {
         if(inwonsu >= 20)
            return (int)(DEFAULT_FEE*inwonsu*0.9);
         else
            return DEFAULT_FEE*inwonsu;
      }      
   }, 
   
   OLD(100){
      @Override
      int getRealFee(int inwonsu) {
         if(inwonsu >= 20)
            return (int)(DEFAULT_FEE*inwonsu*0.7);
         else
            return DEFAULT_FEE*inwonsu;
      }      
   };
   
   protected final int DEFAULT_FEE;
   // !!!! private ���� �ϸ� ���� ������ ������� ������ �Ұ���������. !!!!
   // !!!! protected �� �ؾ߸� ���� ������ ������� ������ ����������. !!!!
   // enum(������)�� �ν��Ͻ� ������ �ݵ�� final �̾�� �Ѵٴ� ��Ģ�� ������ 
   // FEE�� ������ ������� �����ϱ� ���� �뵵�̹Ƿ� final �� ���� ���̴�. 
   
   EnteranceFee_2(int defaultFee) {
   // enum(������)�� �����ڴ� ���������ڰ� private �� �����Ǿ��� �ִ� ���̴�.   
      this.DEFAULT_FEE = defaultFee;
   }
   
   public int getFee() {
   // �ܺο��� FEE ���� ���� �� �ֵ��� ���������ڸ� public ���� �ش�.   
      return DEFAULT_FEE;
   }
   
   // !!!! �����ο����� ���� ������ ����� ���� ����� �ݾ��� �˷��ִ� �߻�(�̿ϼ�)�޼ҵ� !!!!
   abstract int getRealFee(int inwonsu);

}