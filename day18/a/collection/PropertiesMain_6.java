package my.day18.a.collection;

import java.util.*;

public class PropertiesMain_6 {

/*
	    Properties �� HashMap�� �������� Hashtable�� ��ӹ޾� ������ ������,
	    Hashtable �� Ű�� ��(Object, Object)�� ���·� �����ϴµ� ���ؼ�
	    Properties �� (String Ű, String �����)�� ���·� �����ϴ� �ܼ�ȭ�� �÷��� Ŭ�����̴�.
	    Ű�� �����ؾ� �Ѵ�. ��, �ߺ��� ������� �ʴ´�. �ߺ��� ���� ������ �������� ���� ������ ������.
	    �ַ� ���ø����̼��� ȯ�漳���� ���õ� �Ӽ�(property)�� �����ϴµ� ���Ǹ�, 
	    �����͸� ���Ϸ� ���� �а� ���� ���� ����� �����Ѵ�.    
*/
	
	public static void main(String[] args) {

		Properties prop = new Properties();
		
		prop.setProperty("jdk", "http://www.oracle.com/technetwork/java/javase/downloads/index.html");
        prop.setProperty("eclipse", "http://www.sist.co.kr");
        prop.setProperty("eclipse", "http://www.eclipse.org/downloads/eclipse-packages/");
        prop.setProperty("oracle", "http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html");

        String url = prop.getProperty("eclipse");
        System.out.println(url);
        // http://www.eclipse.org/downloads/eclipse-packages/
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        // === prop �� ����Ǿ��� ��� value ������ ����ϰ��� �Ѵ�. ===
        // ���� prop �� ����Ǿ��� Ű����� �˾ƿ;� �Ѵ�.
        // Ű����� �Ʒ��� ���� �ϸ� �ȴ�.
        
        // Enumeration<?> en = prop.propertyNames();
        // ���׸����� <?> �� ����?
        // �ƹ��ų��� ���ϴ� ���̹Ƿ� Object �� ���� �ǹ��̴�.
	
        // ���ǥ�� ���� ����� ����
        @SuppressWarnings("unchecked")
		Enumeration<String> en = (Enumeration<String>)prop.propertyNames();
        // Properties prop ���� Ű����� Enumeration<String> ���·� ��ȯ���� �ش�.
        
        while (en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.print(key);
			System.out.print("=");
			System.out.println(prop.getProperty(key));
			// �ش� key�� ��ġ�ϴ� ���� ���
		}
        
	}

}
