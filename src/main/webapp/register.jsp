<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Register</title>
  <style>
    input, select, textarea {
      box-sizing: border-box;
    }

    input[type="text"], select {
      height: 24px;
    }

    td {
      padding: 4px;
    }
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
  <form class="needs-validation" novalidate method="post"
        action="register">
    <table>
      <tr>
        <td>Your Name</td>
        <td>
          <div class="input-group">
            <input required name="name" type="text" style="width: 200px" placeholder="Full Name">
            <div class="invalid-feedback">
              Please enter your fullname.
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td>Email Address</td>
        <td>
          <div class="input-group">
            <input required name="email" type="text" style="width: 200px" placeholder="Email">
            <div class="invalid-feedback">
              Please enter your email.
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td>Birthday</td>
        <td>
          <div class="input-group">
            <input required name="birthday" type="date" style="width: 200px">
            <div class="invalid-feedback">
              Please select your birthday.
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td>Birthtime</td>
        <td>
          <div class="input-group">
            <input required name="birthtime" type="time" style="width: 200px">
            <div class="invalid-feedback">
              Please select your birthtime.
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td>Gender</td>
        <td>
          <input type="radio" value="male" name="gender" checked> Male
          <input type="radio" value="female" name="gender"> Female
        </td>
      </tr>
      <tr>
        <td>From</td>
        <td>
          <div class="input-group">
            <select required name="country" style="width: 200px">
              <option value="">Select a country</option>
              <optgroup label="Asia">
                <option value="Vietnam">Vietnam</option>
                <option value="Laos">Laos</option>
                <option value="Cambodia">Cambodia</option>
                <option value="Singapore">Singapore</option>
              </optgroup>
              <optgroup label="Europe">
                <option value="France">France</option>
                <option value="Belgium">Belgium</option>
                <option value="Italy">Italy</option>
                <option value="Finland">Finland</option>
                <option value="Ireland">Ireland</option>
              </optgroup>
            </select>
            <div class="invalid-feedback">
              Please select your country.
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td style="vertical-align: text-top">Favorite IDE</td>
        <td>
          <div>
            <input type="checkbox" name="favorite_ide[]" value="Visual Studio Code"> Visual Studio Code
          </div>
          <div>
            <input type="checkbox" name="favorite_ide[]" value="Sublime Text"> Sublime Text
          </div>
          <div>
            <input type="checkbox" name="favorite_ide[]" value="Eclipse"> Eclipse
          </div>
          <div>
            <input type="checkbox" name="favorite_ide[]" value="Atom"> Atom
          </div>
          <div>
            <input type="checkbox" name="favorite_ide[]" value="Intelij Idea"> Intelij Idea
          </div>
        </td>
      </tr>
      <tr>
        <td>TOEIC Score</td>
        <td><input name="toeic" type="range" style="width: 200px"
                   min="5" max="990" step="5"></td>
      </tr>
      <tr>
        <td style="vertical-align: text-top">Message</td>
        <td>
          <div class="input-group">
            <textarea name="message" rows="5" style="width: 200px"></textarea>
            <div class="invalid-feedback">
              Please say something about you.
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button>Register</button>
          <button>Again</button>
        </td>
      </tr>


    </table>
  </form>
</div>

<script>
  (function() {
    'use strict';
    window.addEventListener('load', function() {
      var forms = document.getElementsByClassName('needs-validation');
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  })();
</script>
</body>
</html>