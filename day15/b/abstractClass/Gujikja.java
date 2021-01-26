package my.day15.b.abstractClass;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Gujikja extends Member {

// 	Gujikja е╛╥║╫╨╢б Member е╛╥║╫╨юг юз╫д е╛╥║╫╨╟║ ╣г╬НаЬ╢ы.
//  ╠в╥╞╧г╥н юз╫д е╛╥║╫╨юн Gujikja ©║╪╜╢б ╨н╦П е╛╥║╫╨юн Member ©║╪╜ ╪╠╬П╣г╬НаЬ ╟м╣Ию╩ 
//  ╩С╪с╧ч╬ф ╩Г©Кгр ╪Ж юж╟т ╣х╢ы.	
	
	// ╠╦аВюз 
	
	// field 
	private String jubun;   // аж╧н╧Ьхё ╬уюг 7юз╦╝ ╠НаЖ╦╦   
	                        // ©╧: "9501151"  Ё╡юз   "0105103"  Ё╡юз
	                        // ©╧: "9501152"  ©╘юз   "0105104"  ©╘юз
	
	
	
	// method 
	@Override
	public void setName(String name) {
		
		// name ©║╢б гя╠ш╦╦ гЦ©Кго╟з╢ы.
		
		if(name == null) {
			System.out.println(">> ╪╨╦Мю╨ ╟Ь╧И╬Ьюл гя╠ш╥н╦╦ 2╠шюз ╨нем 5╠шюз╠НаЖ╦╦ ╟║╢игу╢о╢ы. <<");
		    return;
		}
		
		// а╓╠тг╔гЖ╫д(Regular Expression)юл╤У?
		// ==> ф╞а╓гя ╠тд╒ю╩ ╟║аЬ ╧╝юз©╜юг аЩгую╩ г╔гЖго╠Б ю╖гь ╬╡юл╢б гЭ╫д╬П╬Н
		
		// == 1. а╓╠тг╔гЖ╫д(Regular Expression) фпеою╩ юш╪╨гя╢ы. == //
		Pattern p = Pattern.compile("^[╟║-фR]{2,5}$");
		
		// == 2. ╧╝юз©╜юл аж╬НаЬ а╓╠т╫д фпео╟З юод║го╢баЖ фг╨╟го╢б ╟╢ц╪╦╕ ╩Щ╪╨гя╢ы. == //
		Matcher m = p.matcher(name);
		
		// == 3. фг╨╟го╣╣╥о гя╢ы. == //
		// аж╬НаЬ а╓╠т╫д фпео╟З юод║го╦И  true, юод║гоаЖ ╬йю╦╦И false ╦╕ ╦╝ео╫цдяаь╢ы.
		boolean b = m.matches();
		
		if(b) 
			super.saveName(name);
		
		else 
			System.out.println(">> ╪╨╦Мю╨ ╟Ь╧И╬Ьюл гя╠ш╥н╦╦ 2╠шюз ╨нем 5╠шюз╠НаЖ╦╦ ╟║╢игу╢о╢ы. <<");
		
	}
	
	public void setJubun(String jubun) {
		
	   boolean bool = MyUtil.isCheckJubun(jubun);
	   
	   if(bool)
		   this.jubun = jubun;
		
	   else 
		   System.out.println(">> аж╧н╧Ьхё ╬уюг 7юз╦╝╟║ ©ц╧ы╦ёаЖ ╬й╫ю╢о╢ы. <<");
	}
	
	public String getJubun() {
		return jubun;
	}
	
	// == ╠╦аВюзюг ╪╨╨╟ю╩ ╬к╬ф©ю╢б ╦ч╪р╣Е ╩Щ╪╨ == 
	public String getGender() {
		
		String gender = ""; 
		
		switch (jubun.substring(6)) {
			case "1":
			case "3":	
				gender = "Ё╡";
				break;
	
			case "2":
			case "4":	
				gender = "©╘";
				break;
		}// end of switch-------------------
		
		return gender;
		
	}// end of String getGender()-------------
		
		
	// == ╠╦аВюзюг гЖюГЁ╙юл ╬к╬ф©ю╢б ╦ч╪р╣Е ╩Щ╪╨ == 
	public int getAge() {
		//  "9501151"   "0105104"
		
		// гЖюГЁ╙юл = гЖюГЁБ╣╣ - еб╬НЁ╜ЁБ╣╣ + 1 
		
		Calendar currentDate = Calendar.getInstance(); 
		// гЖюГЁ╞б╔©м ╫ц╟ёю╩ ╬Р╬Н©б╢ы.
		
		int currentYear = currentDate.get(Calendar.YEAR);
		
		String sgenderNum = jubun.substring(6);  
		// "1" ╤г╢б "2" ╤г╢б "3" ╤г╢б "4" 
		
		String sbirthYear = jubun.substring(0, 2); 
		// "95" ╤г╢б "01"
		
		int nbirthYear = Integer.parseInt(sbirthYear); 
		// 95 ╤г╢б 1
		
		if("1".equals(sgenderNum) || "2".equals(sgenderNum)) {
			// ╠╦аВюз╟║ 1900ЁБ╢К ╩Щ
			return currentYear - (1900 + nbirthYear) + 1;
		}
		else {
			// ╠╦аВюз╟║ 2000ЁБ╢К ╩Щ
			return currentYear - (2000 + nbirthYear) + 1;
		}
		
	}// end of int getAge()------------------- 
	
	
	// (userid, passwd, name, jubun) field юг  ╟╙юл ╦П╣н null ╬ф╢о╤С╦И 
	// true ╦╕ ╦╝еогьаж╟М, юШ╬Н╣╣ 1╟Ё юл╩Сюл null юл╤С╦И false ╦╕ ╦╝еогьаж╢б
	// ╦ч╪р╣Е╦╕ ╩Щ╪╨гя╢ы.
	
	@Override
	public void viewInfo() {
		System.out.printf("%-10s\t%-15s\t%-8s\t%3d\t%-2s\n",getId(),getPasswd(),getName(),getAge(),getGender());
	}// end of public void viewInfo()-------------------
	
	@Override
	public String toString() {
		String info = "1. ╬фюл╣П : "+getId()+"\n"
				+"2. ╬охё : "+getPasswd()+"\n"
				+"3. ╪╨╦М : "+getName()+"\n"
				+"4. аж╧н╧Ьхё 7юз╦╝ : "+getJubun()+"\n";
								
		return info; 
	}

	// The type Gujikja must implement the inherited abstract method Member.showInfo()
	@Override
	public String showInfo() {
		
		//╪╨╨╟
		String gender = "";
		if(jubun.substring(6)=="1"||jubun.substring(6)=="3")
			gender = "Ё╡юз";
		else  gender = "©╘юз";
		
		//гЖюГЁ╙юл = гЖюГЁБ╣╣ - (еб╬НЁ╜ЁБ╣╣) + 1
		int age = 0;
		Calendar currentDate = Calendar.getInstance();	// гЖюГЁ╞б╔©м ╫ц╟ёю╩ ╬к╥ааж╢б ╟мюл╢ы.
		int currentYear = currentDate.get(Calendar.YEAR);
		
		//еб╬НЁ╜ ЁБ╣╣
		int birthYear = 0; 
		switch (jubun.substring(6)) {
		case "1":
		case "2":
			birthYear = 1900 + Integer.parseInt(jubun.substring(0, 2));
			// аж╧н╧Ьхё ╬уюг 2юз╦╝╦╦ юп╬Н©ю╢б ╟м 
			break;

		default:
			birthYear = 2000 + Integer.parseInt(jubun.substring(0, 2));
			break;
		}
		age = currentYear-birthYear+1;

		
		
		String info = "1. ╬фюл╣П : "+getId()+"\n"
				+"2. ╬охё : "+getPasswd()+"\n"
				+"3. ╪╨╦М : "+getName()+"\n"
				+"4. аж╧н╧Ьхё 7юз╦╝ : "+getJubun()+"\n"
				+"5. ╪╨╨╟ : "+gender+"\n"	
				+"6. Ё╙юл : "+age+"╪╪\n";
		return info; 
	}

	@Override
	public boolean isUse() {
		
		if(super.getId() != null &&
		   this.getPasswd() != null &&
		   getName() != null &&
		   jubun != null) 
			return true;
		
		else 
			return false;
	
	}// end of public boolean isUseGujikja()------------------
	

	
} // end of public class Gujikja-----------------





