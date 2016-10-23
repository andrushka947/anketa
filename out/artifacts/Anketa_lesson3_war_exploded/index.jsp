<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Log in </title>
</head>
<body>
    <%
        String userLogin = (String) session.getAttribute("userLogin");
    %>
    <% if (userLogin == null) {%>
            <%--<%session.setAttribute(userLogin, "Guest");%>--%>
            <p>You are not authorized, sir(You are guest)</p>
            <p> Are u signed up?</p>
            <a href="/login.html">yes</a></br>
            <a href="/signUP.html">no</a></br>
    <% } else {%>
            <p>You are authorized as <% session.getAttribute("userLogin");%></p>
            <a href = questionary>Press here see the results</a>
    <% } %>
</body>
</html>