package controller.command;

import constant.Pages;
import entity.Report;
import lombok.RequiredArgsConstructor;
import service.ReportService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RequiredArgsConstructor
public class PageReportViewCommand implements Command {

    private final ReportService reportService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("reportId"));
        Report report = reportService.findById(id);

        request.getSession().setAttribute("report",report);
        return Pages.VIEW;
    }
}
