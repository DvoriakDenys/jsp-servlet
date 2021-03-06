package controller.command;

import constant.Pages;
import controller.command.client.*;
import controller.command.inspector.*;
import entity.Role;
import entity.User;
import factory.impl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static controller.command.CommandType.*;

public enum CommandExecutor {
    INSTANCE;

    private Map<CommandType, Command> commandMap = new HashMap<>();

    {
        commandMap.put(LOGIN_PAGE, new PageLoginCommand());
        commandMap.put(LOGOUT, new LogoutCommand());
        commandMap.put(LOGIN, new LoginCommand(new ServiceFactoryImpl()));
        commandMap.put(CLIENT_REPORT_LIST, new ClientReportListCommand(new ServiceFactoryImpl().createReportService()));
        commandMap.put(LANGUAGE_CHANGE,new ChangeLanguageCommand());
        commandMap.put(REPORT_PAGE,new PageReportCreateCommand());
        commandMap.put(CREATE_REPORT, new ReportCreateCommand(new ServiceFactoryImpl().createReportService()));

        commandMap.put(REGISTRATION, new RegistrationCommand(new ServiceFactoryImpl().createUserService()));

        commandMap.put(INSPECTOR_CABINET,new PageInspectorCabinet());

        commandMap.put(CLIENT_CABINET,new PageClientCabinet());

        commandMap.put(REGISTRATION_PAGE,new RegistrationPage());

        commandMap.put(CLIENT_REPORT_EDIT,new PageClientReportEdit(new ServiceFactoryImpl().createReportService()));

        commandMap.put(INSPECTOR_REPORT_LIST,new InspectorReportListCommand(new ServiceFactoryImpl().createReportService()));

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
        User user = (User) request.getSession().getAttribute("user");


        if (command == null) {
            command = request.getParameter("command"); }

        if (command == null && user == null) {
            return Pages.LOGIN;
        }

        if (user != null && user.getRole().getRole().equals(Role.CLIENT)
                && request.getServletPath().equals("/client")) {
            return commandMap.get(CommandType.valueOf(command.toUpperCase())).execute(request, response);

        }else if (user != null && user.getRole().getRole().equals(Role.INSPECTOR)
                && request.getServletPath().equals("/inspector")) {
            return commandMap.get(CommandType.valueOf(command.toUpperCase())).execute(request, response);

        }else if (user == null){
            return commandMap.get(CommandType.valueOf(command.toUpperCase())).execute(request, response);

        } else return Pages.ERROR_PAGE;


    }

}
