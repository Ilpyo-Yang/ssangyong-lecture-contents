package my.day13.b.inheritance2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Member {

	// Gujikja Å¬·¡½º¿Í Company Å¬·¡½º°¡ °øÅëÀ¸·Î °¡Á®¾ß ÇÏ´Â field »ı¼º 
	private String id;      // ¾ÆÀÌµğ(5±ÛÀÚ ÀÌ»ó 10±ÛÀÚ ÀÌÇÏ±îÁö¸¸ »ç¿ë°¡´ÉÇÔ)
	private String passwd;  // ¾ÏÈ£ 
	private String name;    // ÀÌ¸§(È¸»ç¸í, °³ÀÎ¼º¸í)
	
	
	// Gujikja Å¬·¡½º¿Í Company Å¬·¡½º°¡ °øÅëÀ¸·Î °¡Á®¾ß ÇÏ´Â method »ı¼º
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		
		if(id != null && !id.trim().isEmpty() &&
		   5 <= id.length() && id.length() <= 10 )
		   this.id = id;
		else
		   System.out.println(">> ¾ÆÀÌµğ´Â °ø¹é¸¸À¸·Î´Â ºÒ°¡ÇÕ´Ï´Ù. \n"
		   		            + " ¶ÇÇÑ 5±ÛÀÚ ÀÌ»ó 10±ÛÀÚ ÀÌÇÏ±îÁö¸¸ °¡´ÉÇÕ´Ï´Ù.<<");
		
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {

		boolean bool = MyUtil.isCheckPasswd(passwd);
		
		if(bool) 
			this.passwd = passwd;
		
		else 
			System.out.println(">> ¾ÏÈ£´Â 8±ÛÀÚ ÀÌ»ó 15±ÛÀÚ ÀÌÇÏÀÇ ¿µ´ë,¼Ò¹®ÀÚ ¹× ¼ıÀÚ, Æ¯¼ö¹®ÀÚ°¡ È¥ÇÕµÇ¾î¾ß ÇÕ´Ï´Ù. <<");
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		// name ¿¡´Â ÇÑ±Û¸¸ Çã¿ëÇÏ°Ú´Ù.
		
		if(name == null) {
			System.out.println(">> ¼º¸íÀº °ø¹é¾øÀÌ ÇÑ±Û·Î¸¸ 2±ÛÀÚ ºÎÅÍ 5±ÛÀÚ±îÁö¸¸ °¡´ÉÇÕ´Ï´Ù. <<");
		    return;
		}
		
		// Á¤±ÔÇ¥Çö½Ä(Regular Expression)ÀÌ¶õ?
		// ==> Æ¯Á¤ÇÑ ±ÔÄ¢À» °¡Áø ¹®ÀÚ¿­ÀÇ ÁıÇÕÀ» Ç¥ÇöÇÏ±â À§ÇØ ¾²ÀÌ´Â Çü½Ä¾ğ¾î
		
		// == 1. Á¤±ÔÇ¥Çö½Ä(Regular Expression) ÆĞÅÏÀ» ÀÛ¼ºÇÑ´Ù. == //
		Pattern p = Pattern.compile("^[°¡-ÆR]{2,5}$");
		
		// == 2. ¹®ÀÚ¿­ÀÌ ÁÖ¾îÁø Á¤±Ô½Ä ÆĞÅÏ°ú ÀÏÄ¡ÇÏ´ÂÁö ÆÇº°ÇÏ´Â °´Ã¼¸¦ »ı¼ºÇÑ´Ù. == //
		Matcher m = p.matcher(name);
		
		// == 3. ÆÇº°ÇÏµµ·Ï ÇÑ´Ù. == //
		// ÁÖ¾îÁø Á¤±Ô½Ä ÆĞÅÏ°ú ÀÏÄ¡ÇÏ¸é  true, ÀÏÄ¡ÇÏÁö ¾ÊÀ¸¸é false ¸¦ ¸®ÅÏ½ÃÄÑÁØ´Ù.
		boolean b = m.matches();
		
		if(b) 
			this.name = name;
		
		else 
			System.out.println(">> ¼º¸íÀº °ø¹é¾øÀÌ ÇÑ±Û·Î¸¸ 2±ÛÀÚ ºÎÅÍ 5±ÛÀÚ±îÁö¸¸ °¡´ÉÇÕ´Ï´Ù. <<");
		
	}
	
	///////////////////////////////////////////
	public void setCompanName(String name) {
		this.name = name;
	}
	
	
	
}
