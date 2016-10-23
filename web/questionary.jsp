

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Questionary</title>
</head>
<body>

      <%String userLogin = (String) session.getAttribute("userLogin"); %>
      <% if (userLogin == null || userLogin.equals("Guest")) { %>
            <p>You are not granted to see this page</p>
      <% } else if (userLogin != null && !userLogin.equals("Guest") && session.getAttribute("flag").equals("yes")) { %>
            <form action = /questionary method = "POST">
                  <p>Do u like java? </p>
                  <input type="radio" name = "java" value="yes"> yes
                  <input type="radio" name = "java" value="no"> no

                  <p>How old are u?</p>
                  <input type = "radio" name = "age" value="20">10-20
                  <input type = "radio" name = "age" value="30">20-30
                  <input type = "radio" name = "age" value="40">30-40

                  <input type="submit" value="Enter"> Enter
            </form>
      <%} else if (userLogin != null && !userLogin.equals("Guest") && session.getAttribute("flag").equals("no")) {%>
            <p> <% userLogin.toString();%> - you have already voted.</p>
            <a href = "questionary">Press here to see results</a>
      <%    }
            session.setAttribute("flag", "no");
      %>
</body>
</html>
