<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title >Funtube</title>
</head>
<style>
    .login {
       margin:100px auto;
        width:500px;
        height: 400px;
        background-color: aliceblue;
        border-radius: 5px;

    }

    input[type="text"],input[type="password"]
    {
        outline: none;
        padding: 0px 10px;
        width: 280px;
    }

p{
    margin-left:30px;

}
   h1{
       text-align: center;
       background-color: darkcyan;
   }
    body{
        background-color: cornflowerblue;
    }
    h2
    {
        background-color: blueviolet;
        text-align: center;
    }
    </style>
<body>
<h1>Funtube</h1>

<div class="login">
    <h2>Login</h2>
    <p>please enter your username and password to sign in.</p>
<form:form action="dologin" commandName="userBean" method="get">
    <p>
    <label >username</label></br>
    <input type="text" name="userId">  <!--  you forgot to include attribute 'name' inside tag -> <input>  -->
</p>
    <p>
    <label>password</label></br>
    <input type="password" name="password">
    </p>

   <p> <label><input type="checkbox" name="checkbox">keep me logged in</label></p>
    </br>
<p>
    <button type="submit" class="btn btn-primary">sign in</button>  or Sign Up for Funtube
</p>
        <p><a href="#">Forget your password?</a></p>
    <p>
    </div>

</form:form>
</body>
</html>
