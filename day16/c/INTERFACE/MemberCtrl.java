package my.day16.c.INTERFACE;

import java.util.Scanner;

public class MemberCtrl implements InterMemberCtrl {

	@Override
	// ������ �ߺ����̵� �˻�
	public boolean duplicateIdGujikja(String id, Member[] mbrArr) {
		
		boolean bool = false;
		
		for (int i=0; i<Member.count; i++) {
			if(mbrArr[i] instanceof Gujikja) {
				String storedId = mbrArr[i].getId();
				if(storedId.equals(id))	{
					bool = true;
					break;
				}
			}
		}
		return bool;
	}

	@Override
	// ����ȸ�� �ߺ����̵� �˻�
	public boolean duplicateIdCompany(String id, Member[] mbrArr) {
		boolean bool = false;
		
		for (int i=0; i<Member.count; i++) {
			if(mbrArr[i] instanceof Company) {
				String storedId = mbrArr[i].getId();
				if(storedId.equals(id))	{
					bool = true;
					break;
				}
			}
		}
		return bool;
	}


	// ȸ������(������ , ����ȸ��)
	   @Override
	   public boolean register(Scanner sc, Member[] mbrArr, int n) {
	   // int n �� n���� 1�̸� �����ڷ� ȸ������, n���� 2�̸� ����ȸ��� ȸ������.   
	      
	      boolean result = false;
	      
	      Member mbr = null;
	      
	      if(n==1) {
	       // �����ڷ� ȸ������
	         mbr = new Gujikja();
	         
	         do {
	            System.out.print("1. ������ ���̵� : ");
	            String id = sc.nextLine();
	            
	            mbr.setId(id);
	            id = mbr.getId();
	            
	            if(id != null) {
	               boolean bool = duplicateIdGujikja(id, mbrArr);
	               
	               if(bool)
	                  System.out.println(">> �̹� ������� ���̵� �Դϴ�. << \n"); 
	               else
	                  break;
	            }
	            
	         } while(true);
	         
	         ////////////////////////////////////////////
	                  
	         do {
	            System.out.print("2. ��ȣ : ");
	            String passwd = sc.nextLine();
	            
	            mbr.setPasswd(passwd);
	            passwd = mbr.getPasswd();
	            
	            if(passwd != null) 
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	                  
	         do {
	            System.out.print("3. ���� : ");
	            String name = sc.nextLine();
	            
	            mbr.setName(name);
	            name = mbr.getName();
	            
	            if(name != null)
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	         do {
	            System.out.print("4. �ֹι�ȣ ���� 7�ڸ��� : ");
	            String jubun = sc.nextLine();
	            
	            ((Gujikja) mbr).setJubun(jubun); 
	            jubun = ((Gujikja) mbr).getJubun();
	            
	            if(jubun != null) 
	               break;
	            
	         } while(true);
	         ////////////////////////////////////////////
	         
	      }// end of if(n==1)-----------------------------
	      
	      else if(n==2) {
	       // ����ȸ��� ȸ������   
	         mbr = new Company();
	         
	         do {
	            System.out.print("1. ����ȸ�� ���̵� : ");
	            String id = sc.nextLine();
	            
	            mbr.setId(id);
	            id = mbr.getId();
	            
	            if(id != null) {
	               boolean bool = duplicateIdCompany(id, mbrArr);
	               
	               if(bool)
	                  System.out.println(">> �̹� ������� ���̵� �Դϴ�. << \n"); 
	               else
	                  break;
	            }
	            
	         } while(true);
	         
	         ////////////////////////////////////////////
	                  
	         do {
	            System.out.print("2. ��ȣ : ");
	            String passwd = sc.nextLine();
	            
	            mbr.setPasswd(passwd);
	            passwd = mbr.getPasswd();
	            
	            if(passwd != null) 
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	         
	         do {
	            System.out.print("3. ȸ��� : ");
	            String name = sc.nextLine();
	            
	            mbr.setName(name);
	            name = mbr.getName();
	            
	            if(name != null)
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	         
	         do {
	            System.out.print("4. ȸ������Ÿ�� : ");
	            String jobType = sc.nextLine();
	            
	            ((Company) mbr).setJobType(jobType);
	            jobType = ((Company) mbr).getJobType(); 
	            
	            if(jobType != null) 
	               break;
	            
	         } while(true);
	         
	         /////////////////////////////////////////////
	         
	         do {
	            System.out.print("5. �ں��� : ");
	            String sseedMoneny = sc.nextLine();
	            
	            ((Company) mbr).setSeedMoney(Long.parseLong(sseedMoneny));
	            long seedMoneny = ((Company) mbr).getSeedMoney();
	            
	            if(seedMoneny > 0) 
	               break;
	            
	         } while(true);
	         /////////////////////////////////////////////
	         
	      } // end of else if(n==2)-------------------------

	      if(Member.count < mbrArr.length) {
	         mbrArr[Member.count++] = mbr;
	         result = true;
	      }
	      
	      return result;
	   }
	   
	   
	@Override
	// ��� ȸ������ ���(������, ����ȸ��)
	public void veiwInfoAll(Member[] mbrArr, int n) {
		if(n==1)
		for (int i=0; i<Member.count; i++) {
			if(mbrArr[i] instanceof Gujikja)
				System.out.println("\n1. ���̵� : "+mbrArr[i].getId()+"\n"
						+ "2. ��й�ȣ : "+mbrArr[i].getPasswd()+"\n"
						+ "3. �̸� : "+mbrArr[i].getName()+"\n"
						+ "4. �ֹε�Ϲ�ȣ �� 7�ڸ� : "+((Gujikja)mbrArr[i]).getJubun());
		if(n==2)
		for (int j=0; j<Member.count; j++) 	
			if(mbrArr[i] instanceof Company)
				System.out.println("\n1. ���̵� : "+mbrArr[i].getId()+"\n"
						+ "2. ��й�ȣ : "+mbrArr[i].getPasswd()+"\n"
						+ "3. ȸ��� : "+mbrArr[i].getName()+"\n"
						+ "4. ���� : "+((Company)mbrArr[i]).getJobType()+"\n"
						+ "5. �ں��� : "+((Company)mbrArr[i]).getSeedMoney());
		}
	}

	@Override
	// Ư�� �� ���� ȸ������ ���(������, ����ȸ��)
	public String showInfo(Member mbr) {
		String info = null;
		
		if(mbr instanceof Gujikja)
			info =  "1. ���̵� : "+mbr.getId()+"\n"
					+ "2. ��й�ȣ : "+mbr.getPasswd()+"\n"
					+ "3. �̸� : "+mbr.getName()+"\n"
					+ "4. �ֹε�Ϲ�ȣ �� 7�ڸ� : "+((Gujikja)mbr).getJubun();
		else if(mbr instanceof Company)
			info =  "1. ���̵� : "+mbr.getId()+"\n"
					+ "2. ��й�ȣ : "+mbr.getPasswd()+"\n"
					+ "3. ȸ��� : "+mbr.getName()+"\n"
					+ "4. ���� : "+((Company)mbr).getJobType()+"\n"
					+ "5. �ں��� : "+((Company)mbr).getSeedMoney();
		
		return info;
	}
	
		
	@Override
	// ȸ��(������, ����ȸ��)���� ��밡������ �˾ƺ��� ��
	public boolean isUse(Member mbr) {
		String id = mbr.getId();
		String passwd = mbr.getPasswd();
		String name = mbr.getName();
		
		if(mbr instanceof Gujikja) {
			String jubun = ((Gujikja)mbr).getJubun();
			
			if(id!=null && passwd!=null && name!=null && jubun!=null) 
				return true;
		}
		else {
			String jobType = ((Company)mbr).getJobType();
			Long seedMoney = ((Company)mbr).getSeedMoney();
			
			if(id!=null && passwd!=null && name!=null && jobType!=null && seedMoney!=null) 
				return true;
		}
			
		return false;
	} // end of public boolean isUse(Member mbr) -----------------------------------------------
	
	@Override
	// ȸ������ ����(������, ����ȸ��)
	public Member updateMemberInfo(Scanner sc, Member[] mbrArr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member login(Scanner sc, Member[] mbrArr, int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
