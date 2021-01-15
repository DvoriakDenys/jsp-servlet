package controller.command.client;

import constant.Pages;
import controller.command.Command;
import entity.Report;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUpdateClientReport implements Command {

    private final ReportService reportService;

    public CommandUpdateClientReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rep = request.getParameter("report");
        String topic = request.getParameter("name_of_report");
        int id = Integer.parseInt(request.getParameter("reportId"));

        Report report = reportService.findById(id);

        report.setReport(rep);
        report.setNameOfReport(topic);
        report.setComment(null);

        reportService.updateReport(report);

        return Pages.CLIENT_CABINET;
    }
}
