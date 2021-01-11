package controller.command;

import constant.Pages;
import entity.Report;
import entity.User;
import lombok.RequiredArgsConstructor;
import service.StatusService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class StatusCommand implements Command{

    private final StatusService statusService;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String report = request.getParameter("report");

        final User user = (User) request.getSession().getAttribute("user");

//        Report reports = Report.builder()
//                .report(report)
//                .nameOfReport(nameOfReport)
//                .comment(comment)
//                .user(user)
//                .build();
//
//        reportService.save(reports);
        return Pages.CLIENT_CABINET;
    }
}
