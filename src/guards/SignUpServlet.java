package guards;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUpServlet extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname  = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));

        Account acc = new Account(login, password, name, surname, age, true);

        if (LoginServlet.logs.containsKey(login)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("userLogin", "guest");
            resp.getWriter().println("<html><head></head><body><p>Try to use another login</p></br><p><abbr title = \" " + session.getAttribute("userLogin") + "\" >Place your cursor here</abbr></p></br>" +
                    "<a href = \"/signUP.html\">try again</a>" + "</body></html>");
            /*RequestDispatcher dispatcher = req.getRequestDispatcher("signUp.html");
            dispatcher.forward(req, resp);*/
            //resp.sendRedirect("signUp.html");
        } else {
            LoginServlet.logs.put(login, acc);
            HttpSession session = req.getSession(true);
            //session.setAttribute("userLogin", login);
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
            dispatcher.forward(req, resp);
            //resp.sendRedirect("login");
            /*


            resp.getWriter().println("<html><head></head><body>" + "<p> U are signed up as " + session.getAttribute("userLogin") + " now!</p>" +
                    "<a href = \"/questionary.jsp\">fill the questionary</a>" + "</body></html>");*/
        }
    }

}
