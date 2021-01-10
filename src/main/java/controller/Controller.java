package controller;

import controller.command.CommandExecutor;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Controller extends HttpServlet {

    private static final CommandExecutor executor = CommandExecutor.INSTANCE;
    private final static Logger logger = Logger.getLogger(Controller.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String execute = null;
        try {
            execute = executor.execute(req,resp);
            if(execute != null) {
                logger.info("Before forward to " + execute);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(execute);
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            logger.warn(e);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
//            req.getRequestDispatcher(new PageError().execute(req,resp)).forward(req,resp);
        }

    }
}
