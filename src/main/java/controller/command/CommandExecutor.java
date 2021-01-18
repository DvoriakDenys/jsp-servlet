package controller.command;

import constant.Pages;
import controller.command.client.*;
import controller.command.inspector.CommandInspectorViewReport;
import controller.command.inspector.InspectorAddComment;
import controller.command.inspector.InspectorReportListCommand;
import controller.command.inspector.PageInspectorCabinet;
import factory.impl.ServiceFactoryImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static controller.command.CommandType.*;

public enum CommandExecutor {
    INSTANCE;

    private Map<CommandType, Command> commandMap = new HashMap<>();

    {
        commandMap.put(LOGIN_PAGE, new PageLoginCommand());
        commandMap.put(LOGOUT, new LogoutCommand());
        commandMap.put(LOGIN, new LoginCommand(new ServiceFactoryImpl()));
        commandMap.put(INSPECTOR_REPORT_LIST, new InspectorReportListCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(CLIENT_REPORT_LIST, new ClientReportListCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(LANGUAGE_CHANGE,new ChangeLanguageCommand());
        commandMap.put(REPORT_PAGE,new PageReportCreateCommand());
        commandMap.put(CREATE_REPORT, new ReportCreateCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(VIEW_PAGE,new PageReportViewCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(INSPECTOR_CABINET,new PageInspectorCabinet());
        commandMap.put(CLIENT_CABINET,new PageClientCabinet());
        commandMap.put(CLIENT_REPORT_EDIT,new PageClientReportView(new ServiceFactoryImpl().createReportService()));

        commandMap.put(SORT_AND_PAGINATION_REPORT,new SortingAndPaginationCommand(new ServiceFactoryImpl().createReportService()));

        commandMap.put(UPDATE_CLIENT_REPORT,new CommandUpdateClientReport(new ServiceFactoryImpl().createReportService()));

        commandMap.put(CLIENT_REPORT_VIEW,new CommandClientViewReport(new ServiceFactoryImpl().createReportService(),
                new ServiceFactoryImpl().createUserService()));

        commandMap.put(INSPECTOR_REPORT_VIEW,new CommandInspectorViewReport(new ServiceFactoryImpl().createReportService(),
                new ServiceFactoryImpl().createUserService()));

        commandMap.put(ADD_COMMENT_AND_STATUS,new InspectorAddComment(new ServiceFactoryImpl().createReportService(),
                new ServiceFactoryImpl().createStatusService()));


    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String command = (String) request.getAttribute("command");

        if (command == null) {
            command = request.getParameter("command");
        }

        if (command == null) return Pages.LOGIN;
        return commandMap.get(CommandType.valueOf(command.toUpperCase())).execute(request, response);
    }
}
