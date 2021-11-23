<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html >
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
     input[type=text]  {
    width: 30%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid red;
    border-radius: 4px;
 }
 input[type=button], input[type=submit], input[type=reset] {
     background-color: #4CAF50;
    border: none;
    color: white;
    padding: 16px 32px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
 }

</style>

</head>
<body>

 <%  String url=request.getContextPath(); %>

<form action="<%=url%>/input" method="get">


 id : <input type="text" name="userID" /><br>
 <br>
 <br>
 pw : <input type="text" name="userPassword" /><br>
 <br>
 <br>

       <input type="submit" value="확인 "/>

</form>


</body>
</html>