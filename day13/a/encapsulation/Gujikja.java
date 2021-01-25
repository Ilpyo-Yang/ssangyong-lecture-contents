package my.day13.a.encapsulation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Gujikja {

	/*
		   а╒╠ыа╕гяюз(а╒╠ыаЖа╓юз, accessmodifier)   юз╠Бюз╫ее╛╥║╫╨Ё╩╨н      ╣©юофпе╟аЖ©║юж╢б╢ы╦╔е╛╥║╫╨      ╢ы╦╔фпе╟аЖ©║юж╢бгою╖(юз╫д)е╛╥║╫╨        ╠в©эюг©╣©╙  
		   ----------------------------------------------------------------------------------------------------------------------- 
		   public                                    O                    O                         O                 O  
		   protected                                 O                    O                         O                 X
		   default                                   O                    O                         X                 X
		   private                                   O                    X                         X                 X
	 */	
	
		//field
		private String userid;
		private String passwd;
		private String name;
		private String jubun;   //аж╧н╧Ьхё 7юз╦╝		©╧:9501151 Ё╡юз	9501152 ©╘юз 
						//аж╧н╧Ьхё 7юз╦╝		©╧:0101153 Ё╡юз	0101154 ©╘юз
		
		static int count; //gujikja ╟╢ц╪юг ╟Ё╪Ж╦╕ ╬к╬ф©ю╥а╢б ©К╣╣
	
		Gujikja() {}      //╩Щ╥╚╣г╬Н юж╢б ╠Б╨╩╩Щ╪╨юз
		
		
		
		//method     => field╦╕ цЁ╦╝го╟Мюз гр ╤╖ ╩Г©К
		//static ╦ч╪╜╣Е Ё╩©║╢б юн╫╨ео╫╨ ╦ч╪╜╣Е╟║ ╣И╬Н©ц ╪Ж ╬Ь╢ы.
		public void setUserid(String userid) {
			int len = userid.length();
			if(5<=len&&len<=10)
				this.userid = userid;     //аЖ©╙╨╞╪Ж©м юн╫╨ео╫╨╨╞╪Жюг ╠╦╨п
			else
				System.out.println(">>> ╬фюл╣П╢б 5╠шюз юл╩С 10╠шюз юлгоюл╬Н╬ъ гу╢о╢ы. <<<");
		}
		
		public void setPasswd(String passwd) {
			Boolean bool = MyUtil.isCheckPasswd(passwd);
			if (bool) 
				this.passwd = passwd;
			else
				System.out.println(">>> ╬охё╢б 8╠шюз юл╩С 15╠шюз юлгоюг ╢К╪р╧╝юз, ╪Щюз, ф╞╪Ж╧╝юз╥н х╔гу╣г╬Н╬ъ гу╢о╢ы. <<<");
		}
		
		public void setName(String name) {
			// name©║╢б гя╠ш╦╦ гЦ©Кго╟з╢ы.
			if(name==null) {
				System.out.println(">>> ╪╨╦Мю╨ ╟Ь╧И╬Ьюл гя╠ш╥н╦╦ 2~5╠шюз╠НаЖ╦╦ ╟║╢игу╢о╢ы. <<<");
				return;
			}
			
			// а╓╠тг╔гЖ╫д(Regular Expression)юл╤У?
	    	// ==> ф╞а╓гя ╠тд╒ю╩ ╟║аЬ ╧╝юз©╜юг аЩгую╩ г╔гЖго╠Б ю╖гь ╬╡юл╢б гЭ╫д╬П╬Н 
	    	
	    	// == 1. а╓╠тг╔гЖ╫д(Regular Expression) фпеою╩ юш╪╨гя╢ы. ==
			// 2~5 ╠шюз, ╟Ь╧Ию╨ ╬х╣г╟М гя╠ш╦╦
	    	Pattern p = Pattern.compile("^[╟║-фR]{2,5}$"); 	    	
	    	
	    	// == 2. ╧╝юз©╜юл аж╬НаЬ а╓╠т╫дфпео╟З юод║го╢баЖ фг╨╟го╢б ╟╢ц╪╦╕ ╩Щ╪╨гя╢ы. ==
	    	Matcher m = p.matcher(name);
	    	
	    	// == 3. фг╨╟го╣╣╥о гя╢ы. ==
	    	//аж╬НаЬ а╓╠т╫д фпео╟З юод║го╦И true, юод║гоаЖ ╬йю╦╦И false╦╕ ╦╝ео╫цдяаь╢ы.
	    	boolean b = m.matches();

			if (b) 
				this.name = name;
			else
				System.out.println(">>> ╪╨╦Мю╨ ╟Ь╧И╬Ьюл гя╠ш╥н╦╦ 2~5╠шюз╠НаЖ╦╦ ╟║╢игу╢о╢ы. <<<");
		}
		
		public void setJubun(String jubun) {
			boolean bool = MyUtil.isCheckJubun(jubun);
			if (bool) 
				this.jubun = jubun;
			else
				System.out.println(">>> аж╧н╧Ьхё 7юз╦╝╟║ ©ц╧ы╦ёаЖ ╬й╫ю╢о╢ы. <<<");
		
		}
		
		// userid, passwd, name, jubun fieldюг ╟╙юл ╦П╣н nullюл ╬ф╢о╤С╦И 
		// true╦╕ return гьаж╟М, юШ╬Н╣╣ гя ╟Ё юл╩Сюл null юл╤С╦И false╦╕ ╦╝еогьаж╢б ╦ч╪╜╣Е╦╕ ╩Щ╪╨гя╢ы.
		
		public boolean isUseGujikja() {
			if(userid!=null &&
				passwd!=null &&
				name!=null &&
				jubun!=null) 
				return true;
			else return false;
		}
		
		public String getName() {
			return name;
		}



		public String getUserid() {
			return userid;
		}



		public String getPasswd() {
			return passwd;
		}



		public String getJubun() {
			return jubun;
		}
		
	
}//end of public class Gujikja ----------------------------------
