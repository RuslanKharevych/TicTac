<%@ page import="Beans.User" %>
<%@ page import="Beans.UserList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <div class="user">
        <form action="loginServlet" method="get">
            Login: <input type="text" name="login"/><br><br>
            <input type="submit" value="Submit"/>
        </form>
    </div>

</body>
</html>