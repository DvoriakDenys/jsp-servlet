package controller.command;

import constant.Pages;
import entity.Report;
import entity.Status;
import entity.User;
import lombok.RequiredArgsConstructor;
import service.ReportService;
import service.StatusService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class InspectorAddComment implements Command{
    private final ReportService reportService;
    private final StatusService statusService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id = Integer.parseInt(request.getParameter("reportId"));
        String comment = request.getParameter("comment");

        Report reports = reportService.findById(id);
        reports.setComment(comment);
//        reports.setStatus(status1);

        reportService.updateComment(reports);
        return Pages.INSPECTOR_CABINET;
    }
}
