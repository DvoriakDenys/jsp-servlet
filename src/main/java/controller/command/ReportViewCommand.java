package controller.command;

import entity.Report;
import entity.User;
import factory.ServiceFactory;
import service.ReportService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ReportViewCommand implements Command {

    ServiceFactory serviceFactory;

    public ReportViewCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        ReportService reportService = serviceFactory.createReportService();
        Report report = reportService.findById(id);
        request.getSession().setAttribute("report",report);

        return null;
    }
}
