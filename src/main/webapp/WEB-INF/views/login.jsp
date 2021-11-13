<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link href="image/favicon.png" rel="shortcut icon">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>SupplementsWeb</title>
</head>
<body>

	<%
		String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main"><img alt="logo" src="image/logo.png" style= "margin-top: -30px; height: 80px"></a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main">메인</a></li>

				<li><a href="infoENS">영양제 소개</a>
					<ul class="sub-menu1">
						<li><a href="infoENS">현대인 필수 영양제</a></li>
						<li><a href="infoCNS">증상별 영양제 추천</a></li>
						<li><a href="infoNGNS">같이 섭취하면 좋지 않은 영양제</a></li>
					</ul>
					</li>
				
					
				<li><a href="bbs2">Q&A 게시판</a>
					</li>
					
					<li><a href="bbs">후기 게시판</a>
					</li>
					
				<li><a href="newsVideo">NEWS & VIDEO</a>
					</li>
				
				<li><a href="myPage">마이페이지</a>
				<ul class="sub-menu2">
					<li><a href="#">회원 정보 수정</a></li>
					</ul>
					</li>
		</ul>

		
			<%
				if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login">로그인</a></li>
						<!-- active : 선택이 됨을 알려줌 -->
						<li><a href="join">회원가입</a></li>
					</ul></li>
			</ul>

			<%
				} else {
			%>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction">로그아웃</a></li>

					</ul>
					</li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>
<%  String url=request.getContextPath(); %>

 <section class="container-1">
 <div class="container">
  <div class="col-lg-4"></div>
  <div class="col-lg-4">
   <form name="login_form" method="post" action="<%=url%>/LoginConfirm">
    <h3 class="welcom">로그인</h3>
    <div class="form-group">
   		<label for="userID">아이디 </label> 
     	<input type="text" class="form-control" placeholder="4~10자, 영문, 숫자" name="userID" maxlength="20">  
     <div id="alert_userID" class="form_text_alert"></div>
    </div>
    <div class="form-group">
    	<label for="userPassword">비밀번호 </label>
     	<input type="password" class="form-control" placeholder="8~12자리 숫자, 영문자, 특수문자 중 2개 조합" name="userPassword" maxlength="20">   
     <div id="alert_userPassword" class="form_text_alert"></div>
    </div>
    <div id="alert_user" class="form_text_alert"></div>
    <input type="submit" class="btn btn-enter" value="로그인"> 
   </form>
  </div>
 </div> 
  <div class="col-lg-4"></div>
  </section>
  
  <br><br><br><br><br><br>

	<%-- 여기부터 footer --%>
	<div id="footer">
		<div class="foot">
			<div class="foot_top">
				<h1>
					<img src="image/logo.png" alt="3조 게시판 로고" />
				</h1>
			</div>
			<div class="foot_btm">
				<div class="info">
					<div class="tit">INFO</div>
					<address>
						ADDRESS: 서울특별시 서초구 서초대로46길 42 <span>┃</span> TEL : 012-3456-7890
					</address>
					<p class="copy">COPYRIGHT(C) TEAM M.B.T.I.CO.,LTD. ALL RIGHTS
						RESERVED.</p>
				</div>
				<div class="cc">
					<div class="tit">CUSTOMER CENTER</div>
					<div class="cc_tel">021-1334-5555</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- //footer -->
	<script src="https://cdn.jsdelivr.net/npm/darkmode-js@1.5.7/lib/darkmode-js.min.js"></script><!--다크모드 설정 -->
	<script src="js/widget.js"></script><!--다크모드 설정 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/dropdown.js"></script>
</body>
</html>