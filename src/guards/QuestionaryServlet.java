package guards;


import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class QuestionaryServlet extends HttpServlet {
    static final Map<String, Integer> java = new HashMap<String, Integer>();
    static final Map<Integer, Integer> age = new HashMap<Integer, Integer>();

    static final String BEFORE = "<html><head><title>Statistics</title></head><body>";
    static final String AFTER = "</body></html>";
    static {
        java.put("yes", 0);
        java.put("no", 0);
        age.put(20, 0);
        age.put(30, 0);
        age.put(40, 0);
    }//hardcode for the default maps values

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String ans1 = req.getParameter("java");
            String ans2 = req.getParameter("age");

            if (ans1.equals("yes"))
                java.put("yes", java.get("yes") + 1);
            else if (ans1.equals("no"))
                java.put("no", java.get("no") + 1);

            if (Integer.parseInt(ans2) == 20)
                age.put(20, age.get(20) + 1);
            else if (Integer.parseInt(ans2) == 30)
                age.put(30, age.get(30) + 1);
            else if (Integer.parseInt(ans2) == 40)
                age.put(40, age.get(40) + 1);


            resp.getWriter().println(BEFORE + "<p>You are - " + req.getSession().getAttribute("userLogin")
                    +"</p>"+ AFTER);
            resp.getWriter().println(BEFORE +
                    "<p> Do u like java:</p>" +
                    "<p>yes - </p>" + java.get("yes") +
                    "<p>no - </p>" + java.get("no") +
                    "<p>How old are u:</p>" +
                    "<p><20 - " + age.get(20) + "</p>" +
                    "<p><30 - " + age.get(30) + "</p>" +
                    "<p><40 - " + age.get(40) + "</p>" +
                    "</br><a href = \"/list.jsp\"> Click here to watch user's list</a>" + AFTER);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println(BEFORE +
                "<p> Do u like java:</p>" +
                "<p>yes - </p>" + java.get("yes") +
                "<p>no - </p>" + java.get("no") +
                "<p>How old are u:</p>" +
                "<p><20 - " + age.get(20) + "</p>" +
                "<p><30 - " + age.get(30) + "</p>" +
                "<p><40 - " + age.get(40) + "</p>" +
                "</br><a href = \"/list.jsp\"> Click here to watch user's list</a>" + AFTER);
    }
}
