<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String ctxPath = request.getContextPath();
	//     /MyMVC
%>
<jsp:include page="../header.jsp" />

<style>
   table#tblMemberRegister {
          width: 93%;
          
          /* 선을 숨기는 것 */
          border: hidden;
          
          margin: 10px;
   }  
   
   table#tblMemberRegister #th {
         height: 40px;
         text-align: center;
         background-color: silver;
         font-size: 14pt;
   }
   
   table#tblMemberRegister td {
         /* border: solid 1px gray;  */
         line-height: 30px;
         padding-top: 8px;
         padding-bottom: 8px;
   }
   
   .star { color: red;
           font-weight: bold;
           font-size: 13pt;
   }
   
</style>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	
	var b_flagIdDuplicateClick= false;
	// 가입하기 버튼을 클릭시 "아이디중복 확인" 을 클릭했는지 안했는지를 알아보기 위한 용도 
	// 위에 나와있는 이유는 $(document).ready(function){})과 그 밖에 함수 선언식에서 쓰이기 때문이다.
	
	var b_flagEmailDuplicateClick = false;
   // 가입하기 버튼을 클릭시 "이메일중복확인" 을 클릭했는지 클릭안했는지를 알아보기 위한 용도임.
   
	$(document).ready(function(){
		
		$("span.error").hide();	// 유효성 검사 에러메시지 감추기
		$("input#name").focus(); //성명에 자동포커스
		
		
		
		$("input#name").blur(function(){
			
			var name = $(this).val().trim();
			
			if(name == ""){
				// 입력하지 않거나 공백만 입력했을 경우
				$(":table#tblMemberRegister :input").prop("disabled",true); //모든 input태그를 비활성화
				$(this).prop("disabled",false); // 성명 input 태그는 활성화 시켜야 한다
				
				$(this).next().show();
			//  또는	
			//	$(this).parent().find(".error").show(); // 성명 에러메시지가 보여야 한다.
				$(this).focus();
			}
			else{
				// 공백이 아닌 글자를 입력했을 경우
				$(":table#tblMemberRegister :input").prop("disabled",false); 
				$(this).next().hide();
			//  또는	
			//	$(this).parent().find(".error").hide();
				
			}
		}); // 아이디가 name 인 것은 포커스를 잃어버렸을 경우(blur) 이벤트를 처리해주는 것이다.
		

		$("input#userid").blur(function(){
			
			var userid = $(this).val().trim();
			
			if(userid == ""){
				// 입력하지 않거나 공백만 입력했을 경우
				$(":table#tblMemberRegister :input").prop("disabled",true); //모든 input태그를 비활성화
				$(this).prop("disabled",false); // 아이디 input 태그는 활성화 시켜야 한다
				
				$(this).parent().find(".error").show(); // 아이디 에러메시지가 보여야 한다.
				$(this).focus();
			}
			else{
				// 공백이 아닌 글자를 입력했을 경우
				$(":table#tblMemberRegister :input").prop("disabled",false); 

				$(this).parent().find(".error").hide();
				
			}
		}); // 아이디가 userid 인 것은 포커스를 잃어버렸을 경우(blur) 이벤트를 처리해주는 것이다.
		
		

		$("input#pwd").blur(function(){
			
		//	var regExp= /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).*$/g;
		//  또는
		 	var regExp= new RegExp(/^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).*$/g);
			// 숫자/문자/특수문자/ 포함 형태의 8~15자리 이내의 암호 정규표현식 객체 생성
			
			var bool = regExp.test($(this).val());
			
			if(!bool){
				// 암호가 정규표현식에 위배된 경우
				$(":table#tblMemberRegister :input").prop("disabled",true); //모든 input태그를 비활성화
				$(this).prop("disabled",false); // 비밀번호 input 태그는 활성화 시켜야 한다
				
				$(this).parent().find(".error").show(); // 비밀번호  에러메시지가 보여야 한다.
				$(this).focus();	
			}
			else{
				// 암호가 정규표현식에 맞는 경우
				$(":table#tblMemberRegister :input").prop("disabled",false); 
				$(this).parent().find(".error").hide();
			}
		}); // 아이디가 pwd 인 것은 포커스를 잃어버렸을 경우(blur) 이벤트를 처리해주는 것이다.
		
		
		$("input#pwdcheck").blur(function(){
			
			var pwd = $("input#pwd").val();
			var pwdcheck = $(this).val();
			
			if(pwd != pwdcheck){
				// 입력한 비밀번호와 비밀번호 확인 값이 일치하지 않는 경우
				$(":table#tblMemberRegister :input").prop("disabled",true); //모든 input태그를 비활성화
				$(this).prop("disabled",false); // 비밀번호 확인 input 태그는 활성화 시켜야 한다
				$("input#pwd").prop("disabled",false);
				
				$(this).parent().find(".error").show(); // 비밀번호 확인 에러메시지가 보여야 한다.
				$("input#pwd").focus();
			}
			else{
				// 일치하는 경우
				$(":table#tblMemberRegister :input").prop("disabled",false); 
				$(this).parent().find(".error").hide();	
			}
		}); // 아이디가 pwdcheck 인 것은 포커스를 잃어버렸을 경우(blur) 이벤트를 처리해주는 것이다.
		
		
		$("input#email").blur(function(){
			
				var regExp= /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			//  또는
			// 	var regExp= new RegExp(/^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).*$/g);
				// 이메일 정규표현식 객체 생성
				
				var bool = regExp.test($(this).val());
				
				if(!bool){
					// 이메일이 정규표현식에 위배된 경우
					$(":table#tblMemberRegister :input").prop("disabled",true); //모든 input태그를 비활성화
					$(this).prop("disabled",false); // 이메일 input 태그는 활성화 시켜야 한다
					
					$(this).parent().find(".error").show(); // 이메일  에러메시지가 보여야 한다.
					$(this).focus();	
				}
				else{
					// 이메일이 정규표현식에 맞는 경우
					$(":table#tblMemberRegister :input").prop("disabled",false); 
					$(this).parent().find(".error").hide();
				}
			}); // 아이디가 email 인 것은 포커스를 잃어버렸을 경우(blur) 이벤트를 처리해주는 것이다.
			
		
		$("input#hp2").blur(function(){
			
			var regExp= /^[1-9][0-9]{3}$/i;
		//  첫번째 숫자는 0을 제외하고 나머지 3개는 0을 포함한 숫자만 오도록 검사하는 정규표현식 객체 생성
			
			var bool = regExp.test($(this).val());
			
			if(!bool){
				// 국번이 정규표현식에 위배된 경우
				$(":table#tblMemberRegister :input").prop("disabled",true); //모든 input태그를 비활성화
				$(this).prop("disabled",false); // 이메일 input 태그는 활성화 시켜야 한다
				
				$(this).parent().find(".error").show(); // 이메일  에러메시지가 보여야 한다.
				$(this).focus();	
			}
			else{
				// 이메일이 정규표현식에 맞는 경우
				$(":table#tblMemberRegister :input").prop("disabled",false); 
				$(this).parent().find(".error").hide();
			}
		}); // 아이디가 hp2 인 것은 포커스를 잃어버렸을 경우(blur) 이벤트를 처리해주는 것이다.
		
		
		
		$("input#hp3").blur(function(){
			
			var regExp= /^\d{4}$/i;
		//  \d: 숫자 4개만 오도록 검사해주는 정규표현식 객체 생성
			
			var bool = regExp.test($(this).val());
			
			if(!bool){
				// 마지막 전화번호 4자리가 정규표현식에 위배된 경우
				$(":table#tblMemberRegister :input").prop("disabled",true); //모든 input태그를 비활성화
				$(this).prop("disabled",false); // 전화번호 input 태그는 활성화 시켜야 한다
				
				$(this).parent().find(".error").show(); // 전화번호  에러메시지가 보여야 한다.
				$(this).focus();	
			}
			else{
				// 전화번호가 정규표현식에 맞는 경우
				$(":table#tblMemberRegister :input").prop("disabled",false); 
				$(this).parent().find(".error").hide();
			}
		}); // 아이디가 hp3 인 것은 포커스를 잃어버렸을 경우(blur) 이벤트를 처리해주는 것이다.
		
		
		
		$("img#zipcodeSearch").click(function(){
			
			new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("extraAddress").value = '';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postcode').value = data.zonecode;
	                document.getElementById("address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("detailAddress").focus();
	            }
	        }).open();  
			
		});
		
		
		//////////////////////////////////////////////

		var mmhtml = "";
		for(var i=1;i<=12;i++){
			
			if(i<10){
				mmhtml += "<option value = '0"+i+"'>0"+i+"</option>";
			}	
			else{
				mmhtml += "<option value = '"+i+"'>"+i+"</option>";
			}
		}
		
		$("select#birthmm").html(mmhtml);
		
		var ddhtml = "";
		for(var i=1;i<=31;i++){
			
			if(i<10){
				ddhtml += "<option value = '0"+i+"'>0"+i+"</option>";
			}	
			else{
				ddhtml += "<option value = '"+i+"'>"+i+"</option>";
			}
		}
		
		$("select#birthdd").html(ddhtml);
	
	
		// === jQuery UI 의 datepicker === //
		$("input#datepicker").datepicker({
                 dateFormat: 'yy-mm-dd'  //Input Display Format 변경
                ,showOtherMonths: true   //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true        //콤보박스에서 년 선택 가능
                ,changeMonth: true       //콤보박스에서 월 선택 가능                
                ,showOn: "both"          //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                ,buttonImageOnly: true   //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택"       //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
                ,yearSuffix: "년"         //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
              //,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
              //,maxDate: "+1M" //최대 선택일자(+1D:하루후, +1M:한달후, +1Y:일년후)                
            });
		
		//초기값을 오늘 날짜로 설정
        $("input#datepicker").datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, +1M:한달후, +1Y:일년후) 

        
        /////////////////////////////////////////////////////////////////////////
        
        
     // === 전체 datepicker 옵션 일괄 설정하기 ===  
     //     한번의 설정으로 $("input#fromDate"), $('input#toDate')의 옵션을 모두 설정할 수 있다.
          $(function() {
              //모든 datepicker에 대한 공통 옵션 설정
              $.datepicker.setDefaults({
                  dateFormat: 'yy-mm-dd' //Input Display Format 변경
                  ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                  ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                  ,changeYear: true //콤보박스에서 년 선택 가능
                  ,changeMonth: true //콤보박스에서 월 선택 가능                
              //  ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
              //  ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
              //  ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
              //  ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
                  ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                  ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                  ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                  ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                  ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
               // ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
               // ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
              });
   
              //input을 datepicker로 선언
              $("input#fromDate").datepicker();                    
              $("input#toDate").datepicker();
              
              //From의 초기값을 오늘 날짜로 설정
              $('input#fromDate').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, +1M:한달후, +1Y:일년후)
              
              //To의 초기값을 3일후로 설정
              $('input#toDate').datepicker('setDate', '+3D'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, +1M:한달후, +1Y:일년후)
          });
        
        
 			///// === 아이디 중복 검사하기 === /////
 			$("img#idcheck").click(function(){
 				 b_flagIdDuplicateClick = true;
 				 // "아이디중복확인"을 클릭했다고 표기를 해주는 것이다.
 				 
 				 // 입력하고자 하는 아이디가 데이터베이스 테이블에 존재하는지 존재하지 않는지를 알아와야 한다.
 				 // 데이터베이스를 연결할 수 있는 건 서블릿이나 jsp인데 현재 작성하는 곳은 자바스크립트 부분이므로 에이잭스를 이용해야한다.
 				 
 				
	 	<%-- 
	 			// === jQuery 를 이용한 Ajax(JSON 을 사용함) 첫번째 방법 === //
	 			$.ajax({
	 				url:"<%= ctxPath%>/member/idDuplicateCheck.up",
	 				type:"post",	// "get" 또는 "post" 를 지정할 때는 method 가 아니라 type 이다.
	 								// type 을 생략하면 "get" 이다.
	 				data:{"userid":$("input#userid").val()},
	 		    //  async:false,   // 동기처리
			    //  async:true,    // 비동기처리(기본값임) 
	 				success:function(text){	// 콜백함수
	 				
	 					//text는 <%= ctxPath%>/member/idDuplicateCheck.up 을 했을 때 웹브라우저 화면에 보여지는 결과물이다.
	 					//console.log(typeof(text));	 String
	 					//console.log(text);	         {"isExists":true}
	 				
		 				var json = JSON.parse(text);
		 				// JSON.parse(text); 은 JSON 형식으로 되어진 문자열을 자바스크립트 객체로 변환해주는 것이다.
		                // 조심할 것은 text 는 반드시 JSON 형식으로 되어진 문자열이어야 한다.
		 				 
		 				//	console.log(typeof(json));	 object
		 				
		 				
		 				if(json.isExists) {
		 					// 입력한 userid 가 이미 사용중이라면
		 					$("span#idcheckResult").html($("input#userid").val()+" 은 중복된 ID 이므로 사용불가 합니다.").css("color","orange");
		 					$("input#userid").val("");
		 				} else {
		 					// 입력한 userid 가 DB 테이블에 존재하지 않는 경우라면
		 					$("span#idcheckResult").html("사용가능 합니다.").css("color","green");
		 				}            
	 				},
	 				
	 				error: function(request, status, error){
	                    alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	                }    				
	 			}); // end of $.ajax ----------------------------------------------
	 	--%>
	 			
	 			
	 			// === jQuery 를 이용한 Ajax(JSON 을 사용함) 두번째 방법 === //
	 			$.ajax({
	 				url:"<%= ctxPath%>/member/idDuplicateCheck.up",
	 				type:"post", // "get" 또는 "post" 를 지정할 때는 method 가 아니라 type 이다.
	 							 // type 을 생략하면 "get" 이다.
	 				data:{"userid":$("input#userid").val()},
	 			//  async:false,   // 동기처리(지도)
				//  async:true,    // 비동기처리(기본값임)
	 				dataType:"json",	// !!! 주의사항 dataType 이지 datatype 이 아니다.
	 				success:function(json){	// 콜백함수
	 					<%-- json은 <%= ctxPath%>/member/idDuplicateCheck.up 을 했을 때 웹브라우저에서 보여지는 결과물을 자바스크립트 객체(object)로 되어진 것이다.  --%> 
	 					//console.log();
	 				
		 				if(json.isExists) {
		 					// 입력한 userid 가 이미 사용중이라면
		 					$("span#idcheckResult").html($("input#userid").val()+" 은 중복된 ID 이므로 사용불가 합니다.").css("color","orange");
		 					$("input#userid").val("");
		 				} else {
		 					// 입력한 userid 가 DB 테이블에 존재하지 않는 경우라면
		 					$("span#idcheckResult").html("사용가능 합니다.").css("color","green");
		 				}            
	 				},
	 				
	 				error: function(request, status, error){
	                    alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	                }    				
	 			}); // end of $.ajax ----------------------------------------------
	 			
 			});
 			
	}); // end of $(document).ready(function(){})------------

	
	 // Function declaration
	 function isExistEmailCheck() {
		      
	      b_flagEmailDuplicateClick = true;
	       // "이메일중복확인" 을  클릭을 했다라고 표기를 해주는 것이다.
	       
	      $.ajax({
	          url:"<%= ctxPath%>/member/emailDuplicateCheck.up",
	          data:{"email":$("input#email").val()}, // data 는 /MyMVC/member/emailDuplicateCheck.up 로 전송해야할 데이터를 말한다. 
	          type:"post",
	          dataType:"json",   // Javascript Standard Object Notation.  dataType은  /MyMVC/member/emailDuplicateCheck.up 로 부터 실행되어진 결과물을 받아오는 데이터타입을 말한다. 
	          success:function(json){
	             if(json.isExists) {
	                // 입력한 email 이 이미 사용중이라면 
	                $("span#emailCheckResult").html($("input#email").val()+" 은 중복된 email 이므로 사용불가 합니다.").css("color","red");
	                $("input#email").val("");
	             }
	             else {
	                // 입력한 email 이 DB 테이블에 존재하지 않는 경우라면 
	                 $("span#emailCheckResult").html("사용가능합니다").css("color","navy");
	             }
	          },
	          error: function(request, status, error){
	            alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	         }
	       });   
		       
	}// end of function isExistEmailCheck()---------------------------
 	
	
	 function goRegister(){

		var radioCheckedLength = $("input:radio[name=gender]:checked").length;
		
		if(radioCheckedLength==0){
			alert("성별에 체크해주세요.");
			return; // 종료
		}
		var checkboxCheckedLength = $("input:checkbox[id=agree]:checked").length;
		
		if(checkboxCheckedLength==0){
			alert("이용약관에 동의하셔야 합니다.");
			return; // 종료
		}
		
		//// 최종적으로 필수 입력사항에 모두 입력이 되었는지 검사한다. ////
		
		
		
		var bFlagRequiredInfo = false;
		
		$(".requiredInfo").each(function(index,item){ // 클래스명이 requiredInfo인 것이 복수개이므로 each 사용
			var data = $(item).val();
			if(data == ""){
				bFlagRequiredInfo = true;
				alert("*표시된 필수 입력사항은 모두 입력하셔야 합니다.");
				return false; // break 라는 뜻이다.
			}
		});
		
		
		if (!b_flagIdDuplicateClick){
			// "아이디중복확인" 버튼을 클릭하지 않은 경우
			alert("아이디중복확인 클릭하여 ID 중복 검사를 하세요!!");
			return; // 종료
		}	
		
		
		if (!b_flagEmailDuplicateClick){
			// "아이디중복확인" 버튼을 클릭하지 않은 경우
			alert("이메일중복확인 클릭하여 Email 중복 검사를 하세요!!");
			return; // 종료
		}	
		
		
		if(!bFlagRequiredInfo){
			var frm = document.registerFrm;
			frm.action = "memberRegister.up";
			frm.method="post";
			frm.submit();
		}
		
		
		
	}
</script>

<div class="row" id="divRegisterFrm">
   <div class="col-md-12" align="center">
   <form name="registerFrm">
   
   <table id="tblMemberRegister">
      <thead>
      <tr>
         <th colspan="2" id="th">::: 회원가입 (<span style="font-size: 10pt; font-style: italic;"><span class="star">*</span>표시는 필수입력사항</span>) :::</th>
      </tr>
      </thead>
      <tbody>
      <tr>
         <td style="width: 20%; font-weight: bold;">성명&nbsp;<span class="star">*</span></td>
         <td style="width: 80%; text-align: left;">
             <input type="text" name="name" id="name" class="requiredInfo" /> 
            <span class="error">성명은 필수입력 사항입니다.</span>
         </td>
      </tr>
      <tr>
         <td style="width: 20%; font-weight: bold;">아이디&nbsp;<span class="star">*</span></td>
         <td style="width: 80%; text-align: left;">
             <input type="text" name="userid" id="userid" class="requiredInfo" />&nbsp;&nbsp;
             <!-- 아이디중복체크 -->
             <img id="idcheck" src="../images/b_id_check.gif" style="vertical-align: middle;" />
             <span id="idcheckResult"></span>
             <span class="error">아이디는 필수입력 사항입니다.</span>
         </td> 
      </tr>
      <tr>
         <td style="width: 20%; font-weight: bold;">비밀번호&nbsp;<span class="star">*</span></td>
         <td style="width: 80%; text-align: left;">
         	<input type="password" name="pwd" id="pwd" class="requiredInfo" />
            <span class="error">암호는 영문자,숫자,특수기호가 혼합된 8~15 글자로 입력하세요.</span>
         </td>
      </tr>
      <tr>
         <td style="width: 20%; font-weight: bold;">비밀번호확인&nbsp;<span class="star">*</span></td>
         <td style="width: 80%; text-align: left;">
         	<input type="password" id="pwdcheck" class="requiredInfo" /> 
            <span class="error">암호가 일치하지 않습니다.</span>
         </td>
      </tr>
      <tr>
         <td style="width: 20%; font-weight: bold;">이메일&nbsp;<span class="star">*</span></td>
         <td style="width: 80%; text-align: left;">
         	 <input type="text" name="email" id="email" class="requiredInfo" placeholder="abc@def.com" /> 
             <span class="error">이메일 형식에 맞지 않습니다.</span>
             
             <%-- ==== 퀴즈 시작 ==== --%>
             <span style="display: inline-block; width: 80px; height: 30px; border: solid 1px gray; border-radius: 5px; font-size: 8pt; text-align: center; margin-left: 10px; cursor: pointer;" onclick="isExistEmailCheck();">이메일중복확인</span> 
             <span id="emailCheckResult"></span>
             <%-- ==== 퀴즈 끝 ==== --%>
         </td>
      </tr>
      <tr>
         <td style="width: 20%; font-weight: bold;">연락처</td>
         <td style="width: 80%; text-align: left;">
             <input type="text" id="hp1" name="hp1" size="6" maxlength="3" value="010" readonly />&nbsp;-&nbsp;
             <input type="text" id="hp2" name="hp2" size="6" maxlength="4" />&nbsp;-&nbsp;
             <input type="text" id="hp3" name="hp3" size="6" maxlength="4" />
             <span class="error">휴대폰 형식이 아닙니다.</span>
         </td>
      </tr>
      <tr>
         <td style="width: 20%; font-weight: bold;">우편번호</td>
         <td style="width: 80%; text-align: left;">
            <input type="text" id="postcode" name="postcode" size="6" maxlength="5" />&nbsp;&nbsp;
            <%-- 우편번호 찾기 --%>
            <img id="zipcodeSearch" src="../images/b_zipcode.gif" style="vertical-align: middle;" />
            <span class="error">우편번호 형식이 아닙니다.</span>
         </td>
      </tr>
      <tr>
         <td style="width: 20%; font-weight: bold;">주소</td>
         <td style="width: 80%; text-align: left;">
            <input type="text" id="address" name="address" size="40" placeholder="주소" /><br/>
            <input type="text" id="detailAddress" name="detailAddress" size="40" placeholder="상세주소" />&nbsp;<input type="text" id="extraAddress" name="extraAddress" size="40" placeholder="참고항목" /> 
            <span class="error">주소를 입력하세요</span>
         </td>
      </tr>
      
      <tr>
         <td style="width: 20%; font-weight: bold;">성별</td>
         <td style="width: 80%; text-align: left;">
            <input type="radio" id="male" name="gender" value="1" /><label for="male" style="margin-left: 2%;">남자</label>
            <input type="radio" id="female" name="gender" value="2" style="margin-left: 10%;" /><label for="female" style="margin-left: 2%;">여자</label>
         </td>
      </tr>
      
      <tr>
         <td style="width: 20%; font-weight: bold;">생년월일</td>
         <td style="width: 80%; text-align: left;">
            <input type="number" id="birthyyyy" name="birthyyyy" min="1950" max="2050" step="1" value="1995" style="width: 80px;" required />
            
            <select id="birthmm" name="birthmm" style="margin-left: 2%; width: 60px; padding: 8px;">
               <%-- 
               <option value ="01">01</option>
               <option value ="02">02</option>
               <option value ="03">03</option>
               <option value ="04">04</option>
               <option value ="05">05</option>
               <option value ="06">06</option>
               <option value ="07">07</option>
               <option value ="08">08</option>
               <option value ="09">09</option>
               <option value ="10">10</option>
               <option value ="11">11</option>
               <option value ="12">12</option>
               --%>
            </select> 
            
            <select id="birthdd" name="birthdd" style="margin-left: 2%; width: 60px; padding: 8px;">
             <%-- 
               <option value ="01">01</option>
               <option value ="02">02</option>
               <option value ="03">03</option>
               <option value ="04">04</option>
               <option value ="05">05</option>
               <option value ="06">06</option>
               <option value ="07">07</option>
               <option value ="08">08</option>
               <option value ="09">09</option>
               <option value ="10">10</option>
               <option value ="11">11</option>
               <option value ="12">12</option>
               <option value ="13">13</option>
               <option value ="14">14</option>
               <option value ="15">15</option>
               <option value ="16">16</option>
               <option value ="17">17</option>
               <option value ="18">18</option>
               <option value ="19">19</option>
               <option value ="20">20</option>
               <option value ="21">21</option>
               <option value ="22">22</option>
               <option value ="23">23</option>
               <option value ="24">24</option>
               <option value ="25">25</option>
               <option value ="26">26</option>
               <option value ="27">27</option>
               <option value ="28">28</option>
               <option value ="29">29</option>
               <option value ="30">30</option>
               <option value ="31">31</option>
              --%> 
            </select> 
         </td>
      </tr>
      
      <tr>
         <td style="width: 20%; font-weight: bold;">생년월일</td>
         <td style="width: 80%; text-align: left;">
            <input type="text" id="datepicker">
         </td>
      </tr>
      
      <tr>
         <td style="width: 20%; font-weight: bold;">재직기간</td>
         <td style="width: 80%; text-align: left;">
            From: <input type="text" id="fromDate">&nbsp;&nbsp; 
            To: <input type="text" id="toDate">
         </td>
      </tr>
         
      <tr>
         <td colspan="2">
            <label for="agree">이용약관에 동의합니다</label>&nbsp;&nbsp;<input type="checkbox" id="agree" />
         </td>
      </tr>
      <tr>
         <td colspan="2" style="text-align: center; vertical-align: middle;">
            <iframe src="../iframeAgree/agree.html" width="85%" height="150px" class="box" ></iframe>
         </td>
      </tr>
      <tr>
         <td colspan="2" style="line-height: 90px;">
            <button type="button" id="btnRegister" style="background-image:url('/MyMVC/images/join.png'); border:none; width: 135px; height: 34px; margin-left: 30%;" onClick="goRegister();"></button> 
         </td>
      </tr>
      </tbody>
   </table>
   </form>
   </div>
</div>



<jsp:include page="../footer.jsp" />