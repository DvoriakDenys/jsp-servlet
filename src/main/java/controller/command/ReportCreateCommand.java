package controller.command;

import constant.Pages;
import entity.Report;
import entity.User;
import lombok.RequiredArgsConstructor;
import service.ReportService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RequiredArgsConstructor
public class ReportCreateCommand implements Command {

    private final ReportService reportService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String report = request.getParameter("report");
        String comment = request.getParameter("comment");
        String nameOfReport = request.getParameter("name_of_report");

        final User user = (User) request.getSession().getAttribute("user");
        Report reports = Report.builder()
                .report(report)
                .nameOfReport(nameOfReport)
                .comment(comment)
                .user(user)
                .build();

        reportService.save(reports);
        return Pages.CLIENT_CABINET;
    }
}
