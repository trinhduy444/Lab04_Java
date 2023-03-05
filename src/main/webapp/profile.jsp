<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Đăng kí</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
  <table class="table">
    <thead class="thead-dark">
    <tr>
      <th>Danh mục</th>
      <th>Thông tin cá nhân</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>Họ tên</td>
      <td><%=request.getAttribute("name") %></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><%=request.getAttribute("email") %></td>
    </tr>
    <tr>
      <td>Ngày sinh</td>
      <td><%=request.getAttribute("birthday") %></td>
    </tr>
    <tr>
      <td>Giờ sinh</td>
      <td><%=request.getAttribute("birthtime") %></td>
    </tr>
    <tr>
      <td>Giới tính</td>
      <td><%=request.getAttribute("gender") %></td>
    </tr>
    <tr>
      <td>Quốc gia</td>
      <td><%=request.getAttribute("country") %></td>
    </tr>
    <tr>
      <td>IDE Yêu thích</td>
      <td>
        <% String[] ides = (String[]) request.getAttribute("ides");
          if (ides != null) {
            for (String ide: ides) {
        %>
        <p><%=ide %></p>
        <%
            }
          }
        %>
      </td>
    </tr>
    <tr>
      <td>Điểm toeic</td>
      <td><%=request.getAttribute("toeic") %></td>
    </tr>
    <tr>
      <td>Giới thiệu bản thân</td>
      <td><%=request.getAttribute("message") %></td>
    </tr>
    </tbody>
  </table>
</div>
</body>
</html>