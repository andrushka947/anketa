<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <%String userLogin = (String) session.getAttribute("userLogin"); %>
    <%if (userLogin.equals("Guest")) {%>
        <p>You are not granted to see this page</p>
    <% } else { %>
        <form action = "/list" method = "get">
            <input type = "submit">show all users
    <% } %>
    </form>
</body>
</html>