package my.day19.d.ENUM;

// �Ʒ��� ���� �� package my.day19.c.ENUM.EnteraceFee_2 Ŭ������ enum �� ����Ͽ� ������ ���̴�.

//>> === enum(������)�� ���(field, method)�߰��ϱ� === << //
// ��� enum(������)�� �߻� Ŭ���� Enum �� �ڼ��̴�. �׷��Ƿ� field ��  �����ڿ� method �� ���� �� �ִ� ���̴�.
public enum EnteranceFee_2 {

	CHILD(0), TEENAGER(150), ADULT(300), OLD(100);  // ���� ; �� �ٿ��� �Ѵ�.
	// !!! ����� ������ ��� CHILD, TEENAGER, ADULT, OLD �ϳ� �ϳ��� EntranceFee_2 ��ü��� ���̴�.!!!

	private final int FEE;
	// enum(������)�� �ν��Ͻ� ������ �ݵ�� final �̾�� �Ѵٴ� ��Ģ�� ������ 
    // fee�� ������ ������� �����ϱ� ���� �뵵�̹Ƿ� final �� ���� ���̴�. 
	
	// �Ķ���Ϳ� �ִ� �����ڸ� �ۼ������ �Ѵ�.
	// enum(������)�� �����ڴ� ���������ڰ� private �� �����Ǿ��� �ִ� ���̴�.
	EnteranceFee_2(int fee){
		this.FEE = fee;
	}
	
	public int getFee() {
		// �ܺο��� FEE ���� ���� �� �ֵ��� ���������ڸ� public ���� �ش�.
			return FEE;
	}
}
