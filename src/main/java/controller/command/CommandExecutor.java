package controller.command;

import constant.Pages;
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
        commandMap.put(REPORT_LIST, new InspectorReportListCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(LANGUAGE_CHANGE,new ChangeLanguageCommand());
        commandMap.put(REPORT_PAGE,new PageReportCreateCommand());
        commandMap.put(CREATE_REPORT, new ReportCreateCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(VIEW_PAGE,new PageReportViewCommand(new ServiceFactoryImpl().createReportService()));

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
