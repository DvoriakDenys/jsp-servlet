package factory.impl;

import factory.ServiceFactory;
import service.ReportService;
import service.StatusService;
import service.UserService;
import service.impl.ReportServiceImpl;
import service.impl.StatusServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactoryImpl extends ServiceFactory {
    @Override
    public UserService createUserService() {
        return new UserServiceImpl(new DAOFactoryImpl().createUserDAO());
    }

    @Override
    public ReportService createReportService() {
        return new ReportServiceImpl(new DAOFactoryImpl().createReportDAO());
    }

    @Override
    public StatusService createStatusService() {
        return new StatusServiceImpl(new DAOFactoryImpl().createStatusService());
    }
}
