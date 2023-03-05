<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <title>52000655_Lab04</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
  <a class="navbar-brand" href="/welcome">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <!-- Left -->
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="contact.jsp">Contact</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="about.jsp">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Help.jsp">Help</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/upload">Upload</a>
      </li>
    </ul>

    <!-- Right -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/register">Register</a>
      </li>
    </ul>
  </div>

</nav>
<div>
  <h1><%= "Chọn bài tập cần chạy" %>
  </h1>
  <br/>
  <a href="login">Login - Exercise 1</a>
  <br>
  <a href="image1">Image 1 - Exercise 2</a>
  <a href="image2">Image 2 - Exercise 2</a>
  <a href="download">Download - Exercise 2</a>
  <br>
  <a href="ProductServlet">Get Product - Exercise 3</a>
  <a href="product.jsp">Add Product - Exercise 3</a>
  <br>
  <a href="upload">Upload - Exercise 4</a>
  <br>
  <a href="welcome">Welcome - Exercise 5</a>
  <br>
  <a href="register">Register - Exercise 6</a>
</div>
</body>
</html>