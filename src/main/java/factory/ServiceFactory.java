package factory;

import service.ReportService;
import service.StatusService;
import service.UserService;

/**
 * Abstract factory for creation a dao-entity
 */
public abstract class ServiceFactory {

    public abstract UserService createUserService();

    public abstract ReportService createReportService();

    public abstract StatusService createStatusService();
}
