package controller.command.client;


import constant.Pages;
import controller.command.Command;
import entity.Report;
import entity.User;
import lombok.RequiredArgsConstructor;
import service.ReportService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class ClientReportListCommand implements Command {

    private final ReportService reportService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        final User user = (User) request.getSession().getAttribute("user");
        int pageNumber = 0;
        int quantityReportOnPage = 5;
        int currentPage = 1;
        String status = request.getParameter("status");
        String sorting = request.getParameter("sorting");

        if (request.getParameter("currentPage") != null) {
            pageNumber = (Integer.parseInt(request.getParameter("currentPage")) - 1) * quantityReportOnPage;
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        List<Report> reports = reportService.findAllReportsByUserId(user.getId(), pageNumber, quantityReportOnPage,
                sorting, status);

        int quantityPage = (int)Math.ceil((double)reportService.findAll().size() / (double) quantityReportOnPage);

        request.setAttribute("reports", reports);
        request.setAttribute("quantityPage", quantityPage);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("sorting", sorting);
        request.setAttribute("status", status);

        return Pages.CLIENT_REPORT_LIST;
    }
}
