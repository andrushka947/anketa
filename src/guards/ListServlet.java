package guards;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ListServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpSession session = req.getSession();
        if (/*session.getAttribute("userLogin").equals("Guest") || */session.getAttribute("userLogin") == null) {
            sb.append("You are not granted to see this page");
        } else {
            for (Map.Entry<String, Account> pair : LoginServlet.logs.entrySet()) {
                sb.append(pair.getValue().toString() + "</br>");
            }
        }
        resp.getWriter().println("<html><body><title>list</title></body><body><p>" + sb.toString()
                + "</p></body></html>");
    }
}
