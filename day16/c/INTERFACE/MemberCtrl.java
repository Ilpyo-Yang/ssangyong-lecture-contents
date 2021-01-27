package my.day16.c.INTERFACE;

import java.util.Scanner;

public class MemberCtrl implements InterMemberCtrl {

	@Override
	// 구직자 중복아이디 검사
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
	// 구인회사 중복아이디 검사
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


	// 회원가입(구직자 , 구인회사)
	   @Override
	   public boolean register(Scanner sc, Member[] mbrArr, int n) {
	   // int n 은 n값이 1이면 구직자로 회원가입, n값이 2이면 구인회사로 회원가입.   
	      
	      boolean result = false;
	      
	      Member mbr = null;
	      
	      if(n==1) {
	       // 구직자로 회원가입
	         mbr = new Gujikja();
	         
	         do {
	            System.out.print("1. 구직자 아이디 : ");
	            String id = sc.nextLine();
	            
	            mbr.setId(id);
	            id = mbr.getId();
	            
	            if(id != null) {
	               boolean bool = duplicateIdGujikja(id, mbrArr);
	               
	               if(bool)
	                  System.out.println(">> 이미 사용중인 아이디 입니다. << \n"); 
	               else
	                  break;
	            }
	            
	         } while(true);
	         
	         ////////////////////////////////////////////
	                  
	         do {
	            System.out.print("2. 암호 : ");
	            String passwd = sc.nextLine();
	            
	            mbr.setPasswd(passwd);
	            passwd = mbr.getPasswd();
	            
	            if(passwd != null) 
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	                  
	         do {
	            System.out.print("3. 성명 : ");
	            String name = sc.nextLine();
	            
	            mbr.setName(name);
	            name = mbr.getName();
	            
	            if(name != null)
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	         do {
	            System.out.print("4. 주민번호 앞의 7자리만 : ");
	            String jubun = sc.nextLine();
	            
	            ((Gujikja) mbr).setJubun(jubun); 
	            jubun = ((Gujikja) mbr).getJubun();
	            
	            if(jubun != null) 
	               break;
	            
	         } while(true);
	         ////////////////////////////////////////////
	         
	      }// end of if(n==1)-----------------------------
	      
	      else if(n==2) {
	       // 구인회사로 회원가입   
	         mbr = new Company();
	         
	         do {
	            System.out.print("1. 구인회사 아이디 : ");
	            String id = sc.nextLine();
	            
	            mbr.setId(id);
	            id = mbr.getId();
	            
	            if(id != null) {
	               boolean bool = duplicateIdCompany(id, mbrArr);
	               
	               if(bool)
	                  System.out.println(">> 이미 사용중인 아이디 입니다. << \n"); 
	               else
	                  break;
	            }
	            
	         } while(true);
	         
	         ////////////////////////////////////////////
	                  
	         do {
	            System.out.print("2. 암호 : ");
	            String passwd = sc.nextLine();
	            
	            mbr.setPasswd(passwd);
	            passwd = mbr.getPasswd();
	            
	            if(passwd != null) 
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	         
	         do {
	            System.out.print("3. 회사명 : ");
	            String name = sc.nextLine();
	            
	            mbr.setName(name);
	            name = mbr.getName();
	            
	            if(name != null)
	               break;
	         
	         } while(true);
	         
	         ////////////////////////////////////////////
	         
	         do {
	            System.out.print("4. 회사직종타입 : ");
	            String jobType = sc.nextLine();
	            
	            ((Company) mbr).setJobType(jobType);
	            jobType = ((Company) mbr).getJobType(); 
	            
	            if(jobType != null) 
	               break;
	            
	         } while(true);
	         
	         /////////////////////////////////////////////
	         
	         do {
	            System.out.print("5. 자본금 : ");
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
	// 모든 회원정보 출력(구직자, 구인회사)
	public void veiwInfoAll(Member[] mbrArr, int n) {
		if(n==1)
		for (int i=0; i<Member.count; i++) {
			if(mbrArr[i] instanceof Gujikja)
				System.out.println("\n1. 아이디 : "+mbrArr[i].getId()+"\n"
						+ "2. 비밀번호 : "+mbrArr[i].getPasswd()+"\n"
						+ "3. 이름 : "+mbrArr[i].getName()+"\n"
						+ "4. 주민등록번호 앞 7자리 : "+((Gujikja)mbrArr[i]).getJubun());
		if(n==2)
		for (int j=0; j<Member.count; j++) 	
			if(mbrArr[i] instanceof Company)
				System.out.println("\n1. 아이디 : "+mbrArr[i].getId()+"\n"
						+ "2. 비밀번호 : "+mbrArr[i].getPasswd()+"\n"
						+ "3. 회사명 : "+mbrArr[i].getName()+"\n"
						+ "4. 직종 : "+((Company)mbrArr[i]).getJobType()+"\n"
						+ "5. 자본금 : "+((Company)mbrArr[i]).getSeedMoney());
		}
	}

	@Override
	// 특정 한 명의 회원정보 출력(구직자, 구인회사)
	public String showInfo(Member mbr) {
		String info = null;
		
		if(mbr instanceof Gujikja)
			info =  "1. 아이디 : "+mbr.getId()+"\n"
					+ "2. 비밀번호 : "+mbr.getPasswd()+"\n"
					+ "3. 이름 : "+mbr.getName()+"\n"
					+ "4. 주민등록번호 앞 7자리 : "+((Gujikja)mbr).getJubun();
		else if(mbr instanceof Company)
			info =  "1. 아이디 : "+mbr.getId()+"\n"
					+ "2. 비밀번호 : "+mbr.getPasswd()+"\n"
					+ "3. 회사명 : "+mbr.getName()+"\n"
					+ "4. 직종 : "+((Company)mbr).getJobType()+"\n"
					+ "5. 자본금 : "+((Company)mbr).getSeedMoney();
		
		return info;
	}
	
		
	@Override
	// 회원(구직자, 구인회사)으로 사용가능한지 알아보는 것
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
	// 회원정보 변경(구직자, 구인회사)
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
