<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <!-- Brand -->
  <a class="navbar-brand" href="<%=request.getContextPath()%>/chap08/index.jsp"><img src="/jspPro/common/logo.png"  width="60%"></a>
  <ul class="navbar-nav">
<%
request.setCharacterEncoding("utf-8");
String login = (String)session.getAttribute("id");   
if(login==null){

%>
  <!-- Links -->
 
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/chap08/memberinput.jsp">회원가입</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/chap08/loginForm.jsp">로그인</a>
    </li>
<%}else{ %>
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/chap08/memberinfo.jsp">[<%=login%>]&nbsp;&nbsp;회원정보</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/chap08/logout.jsp">로그아웃</a>
    </li>
    <%} %>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        게시판
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="">공지사항</a>
        <a class="dropdown-item" href="">자유게시판</a>
        <a class="dropdown-item" href="">QnA</a>
      </div>
    </li>
  </ul>
</nav>
<br>
  


</body>
</html>