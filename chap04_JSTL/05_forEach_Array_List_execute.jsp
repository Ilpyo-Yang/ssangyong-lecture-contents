<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*, chap04.PersonDTO"%>

<%
	String[] arrFriendName = {"김성경","채연하","한서연","박서준","박보영"};
	// "김성경","채연하","한서연","박서준","박보영"
	/* 배열도 객체이다. */

	request.setAttribute("arrFriendName", arrFriendName);

	List<PersonDTO> personList = new ArrayList<>();
	
	PersonDTO person1 = new PersonDTO();
	person1.setName("김태희");	
	person1.setSchool("대졸");
	person1.setColor("red");
	person1.setFood("초콜릿, 마이쮸, 월드콘".split(","));
	// food.split(","); 문자열을 배열로 만드는 방법
	
	PersonDTO person2 = new PersonDTO();
	person2.setName("아이유");	
	person2.setSchool("초대졸");
	person2.setColor("blue");
	person2.setFood("육회비빔밥, 광어회, 조개구이, 참이슬".split(","));
	// food.split(","); 문자열을 배열로 만드는 방법
	
	PersonDTO person3 = new PersonDTO();
	person3.setName("박보영");	
	person3.setSchool("대학원졸");
	person3.setColor("green");
	person3.setFood("라면, 떡볶이, 순대, 피자".split(","));
	// food.split(","); 문자열을 배열로 만드는 방법
	
	personList.add(person1);
	personList.add(person2);
	personList.add(person3);
	
	request.setAttribute("personList", personList);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("05forEach_view.jsp");
	dispatcher.forward(request, response);
%>




