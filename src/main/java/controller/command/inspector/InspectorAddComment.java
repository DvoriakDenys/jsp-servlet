package controller.command.inspector;

import constant.Pages;
import controller.command.Command;
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

public class InspectorAddComment implements Command {
    private final ReportService reportService;
    private final StatusService statusService;

    public InspectorAddComment(ReportService reportService, StatusService statusService) {
        this.reportService = reportService;
        this.statusService = statusService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id = Integer.parseInt(request.getParameter("reportId"));
        String comment = request.getParameter("comment");
        String st = request.getParameter("status");

        Status status = statusService.findByName(st);
        Report reports = reportService.findById(id);

        reports.setComment(comment);
        reports.setStatus(status);

        reportService.updateComment(reports);
        return Pages.INSPECTOR_CABINET;
    }
}
