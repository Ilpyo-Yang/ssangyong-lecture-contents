package my.day13.b.inheritance2;

import java.util.Scanner;

public class GujikjaCompanyCtrl {

	// == ������(Gujikja) �ű� ȸ�������� ���ִ� �޼ҵ� �����ϱ� ==  
	public Gujikja registerGujikja(Scanner sc, Gujikja[] guArr) {
		
		Gujikja gu = new Gujikja();
		
		do {
			System.out.print("1. ���̵� : ");
			String id = sc.nextLine(); 
			
			gu.setId(id);
			id = gu.getId();
			
			if(id != null) { 
                			
				// == �ߺ����̵� �˻��ϱ� == //
				boolean idFlag = false;
				
				for(int i=0; i<Gujikja.count; i++) {
					if( id.equals(guArr[i].getId()) ) {     
						System.out.println(">> �̹� ������� ���̵� �Դϴ�. <<\n");
						idFlag = true;
						break;
					}
				}// end of for---------------------
				
				if(!idFlag)
					break;
			}
			
		} while (true);
		
		////////////////////////////////////////////
		
		do {
			System.out.print("2. ��ȣ : ");
			String passwd = sc.nextLine();
			
			gu.setPasswd(passwd);
			passwd = gu.getPasswd();
			
			if(passwd != null) 
				break;
			
		} while(true);
		
		////////////////////////////////////////////
		
		do {
			System.out.print("3. ���� : ");
			String name = sc.nextLine();
			
			gu.setName(name);
			name = gu.getName();
			
			if(name != null)
			   break;
			
		} while(true);
		
		////////////////////////////////////////////
		
		do {
			System.out.print("4. �ֹι�ȣ ���� 7�ڸ��� : ");
			String jubun = sc.nextLine();
			
			gu.setJubun(jubun);
			jubun = gu.getJubun();
			
			if(jubun != null) 
				break;
			
		} while(true);
		
		/////////////////////////////////////////////
		
		return gu;
		
	}// end of public Gujikja registerGujikja(Scanner sc, Gujikja[] guArr)-------
	
	
	// == ����ȸ��(Company) �ű� ȸ�������� ���ִ� �޼ҵ� �����ϱ� ==  
	public Company registerCompany(Scanner sc, Company[] coArr) {
		
		Company co = new Company();
		
		do {
			System.out.print("1. ���̵� : ");
			String id = sc.nextLine(); 
			
			co.setId(id);
			id = co.getId();
			
			if(id != null) { 
                			
				// == �ߺ����̵� �˻��ϱ� == //
				boolean idFlag = false;
				
				for(int i=0; i<Company.count; i++) {
					if( id.equals(coArr[i].getId()) ) {     
						System.out.println(">> �̹� ������� ���̵� �Դϴ�. <<\n");
						idFlag = true;
						break;
					}
				}// end of for---------------------
				
				if(!idFlag)
					break;
			}
			
		} while (true);
		
		////////////////////////////////////////////
		
		do {
			System.out.print("2. ��ȣ : ");
			String passwd = sc.nextLine();
			
			co.setPasswd(passwd);
			passwd = co.getPasswd();
			
			if(passwd != null) 
				break;
			
		} while(true);
		
		////////////////////////////////////////////
		
		do {
			System.out.print("3. ȸ��� : ");
			String name = sc.nextLine();
			
			co.setName(name);
			name = co.getName();
			
			if(name != null)
			   break;
			
		} while(true);
		
		////////////////////////////////////////////
		
		do {
			System.out.print("4. ȸ������Ÿ�� : ");
			String jobType = sc.nextLine();
			
			co.setJobType(jobType);
			jobType = co.getJobType();
			
			if(jobType != null) 
				break;
			
		} while(true);
		
		/////////////////////////////////////////////
		
		do {
			System.out.print("5. �ں��� : ");
			String sseedMoneny = sc.nextLine();
			
			co.setSeedMoney(Long.parseLong(sseedMoneny));
			long seedMoneny = co.getSeedMoney();
			
			if(seedMoneny > 0) 
				break;
			
		} while(true);
		
		/////////////////////////////////////////////
		
		return co;
		
	}// end of public Company registerCompany(Scanner sc, Company[] coArr)--------
	
	
	// == �������� ������ ��� �����ִ� �޼ҵ� �����ϱ� == 
	public void showAllGujikja(Gujikja[] guArr) {
		
		System.out.println("------------------------------------------------------");
		System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","���̵�","��ȣ","����","���糪��","����");
		System.out.println("------------------------------------------------------");
		
		for(int i=0; i<Gujikja.count; i++) {
		
			guArr[i].viewInfo();
			
		}// end of for-----------------------
		
		System.out.print("\n");
		
	}// end of public void showAllGujikja(Gujikja[] guArr)----------
	
	
	// == �������� ������ ��� �����ִ� �޼ҵ� �����ϱ� == 
	public void showAllCompany(Company[] coArr) {
		
		System.out.println("------------------------------------------------------");
		System.out.printf("%-10s\t%-15s\t%-4s\t%-4s\t%-10s\n","���̵�","��ȣ","ȸ���","����","�ں���");
		System.out.println("------------------------------------------------------");
		
		for(int i=0; i<Company.count; i++) {
		
			coArr[i].viewInfo();
			
		}// end of for-----------------------
		
		System.out.print("\n");
		
	}// end of public void showAllCompany(Company[] coArr)----------
	
	
	// == �����ڷ� �α����ϴ� �޼��� �����ϱ� ==
	public Gujikja loginByGujikja(Scanner sc, Gujikja[] guArr) {
		Gujikja gu = null;
		
		System.out.print("\n�� ���̵� : ");
		String id = sc.nextLine();
		
		System.out.print("�� ��ȣ : ");
		String passwd = sc.nextLine();
		
		for (int i=0; i<Gujikja.count; i++) {
			if(id.equals(guArr[i].getId()) && passwd.equals(guArr[i].getPasswd())){
				System.out.println("\n>> �α��� ����!! <<\n");
				gu = guArr[i];
				break;
			}
		}
		if (gu==null){
			System.out.println(">> �α��� ����!! <<\n");
		}
		return gu;
	}//end of public Gujikja loginByGujikja(Scanner sc, Gujikja guArr) --------------
	
	
	// == ����ȸ��� �α��� �ϴ� �޼ҵ� �����ϱ� == 
	   public Company loginByCompany(Scanner sc, Company[] coArr) {
	      
	      Company co = null;
	      
	      System.out.print("\n�����̵� : ");
	      String id = sc.nextLine();
	      
	      System.out.print("����ȣ : ");
	      String passwd = sc.nextLine();
	      
	      for(int i=0; i<Company.count; i++) {
	         
	         if(id.equals(coArr[i].getId()) && passwd.equals(coArr[i].getPasswd())) { 
	            System.out.println(">> �α��� ����!! << \n");
	            co = coArr[i];
	            break;
	         }
	         
	      }// end of for-----------------------------
	      
	      if(co == null)
	         System.out.println(">> �α��� ����!! << \n");
	      
	      return co;
	   }// end of public Company loginByCompany(Scanner sc, Company[] coArr)------------
	   
	// ====== Method Overloading(�޼ҵ� �����ε�) =======  
	// �޼����� �̸��� ������ �Ķ������ ���� �Ǵ� ����, ������ �ٸ� ��� �ٸ� �޼���� ����.
	// 
	  public int abc(int a) {
		  return 0;
	  }
	  public double abc() {
		  return 0;
	  }
	   
	// == �������� �� ���� �����ϱ� �޼ҵ� �����ϱ� ==  
	   public Gujikja updateMyInfo(Scanner sc, Gujikja gu) {
		   System.out.println(gu);
		   
		   System.out.println("\n~~~~~ �� ���� �����ϱ� ~~~~~\n");
		   
		  
		   do {
			    System.out.print("�� ��ȣ���� => ");
			    String passwd = sc.nextLine();
				
				gu.setPasswd(passwd);
				passwd = gu.getPasswd();
				
				if(passwd != null) 
					break;
				
			} while(true);
		   
		   System.out.print("�� ������ => ");
		   String name = sc.nextLine();
		   
		   System.out.print("�� �ֹι�ȣ 7�ڸ� ���� => ");
		   String jubun = sc.nextLine();
		   
		   gu.setPasswd(passwd);
		   
		   return null;
	}
	   
	// == ����ȸ���� �� ���� �����ϱ� �޼ҵ� �����ϱ� ==  
	   public Company updateMyInfo(Scanner sc, Company co) {
		   System.out.println(co);
		   return null;
		}
	
}
