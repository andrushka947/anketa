package guards;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


public class LoginServlet extends HttpServlet {

    public static final Map<String, Account> logs = Collections.synchronizedMap(new HashMap<String, Account>());

    static { logs.put("star", new Account("star","pass", "and", "ale", 19, true));}

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (logs.containsKey(login) && logs.get(login).getPassword().equals(password)) {
            logs.get(login).setFlag(true);
            HttpSession session = req.getSession(true);
            session.setAttribute("userLogin", login);
            session.setAttribute("flag", "yes");
            Thread thread = new Thread();
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //resp.getWriter().println("<html><head></head><body><p>You are authorized as " + session.getAttribute("userLogin") +  " </p></bt><a href = \"/questionary.jsp\">press it</a></body></html>");
            resp.sendRedirect("/questionary.jsp");
        } else {
            HttpSession session = req.getSession(true);
            session.setAttribute("userLogin", "Guest");
            resp.getWriter().println("<html><head></head><body>" + "<p> You are authorized as " + session.getAttribute("userLogin") +
                    "<p/><p>Something went wrong.</p></br><a href = \"/login.html\">try again</a></body></html>");
        }
    }

/*    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("get method");
    }*/

    public static Account getUser(String log) {
        Account acc ;
        if (logs.containsKey(log)) {
            acc = logs.get(log);
        } else {
            acc = null;
        }
        return acc;
    }
}
