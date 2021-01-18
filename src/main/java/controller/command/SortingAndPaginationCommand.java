package controller.command;

import constant.Pages;
import entity.Report;
import entity.User;
import service.ReportService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SortingAndPaginationCommand implements Command{
    private final ReportService reportService;

    public SortingAndPaginationCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageNumber = 0;
        int quantityReportOnPage = 5;
        int currentPage = 1;
        int quantityPage = (int)Math.ceil((double)reportService.findAll().size() / (double) quantityReportOnPage);

        if (request.getParameter("currentPage") != null) {
            pageNumber = (Integer.parseInt(request.getParameter("currentPage")) - 1) * quantityReportOnPage;
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        List<Report> reports = reportService.paginationReport(pageNumber, quantityReportOnPage);

        request.setAttribute("reports", reports);
        request.setAttribute("quantityPage", quantityPage);
        request.setAttribute("currentPage", currentPage);


        return Pages.INSPECTOR_REPORT_LIST;
    }
}
