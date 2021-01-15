package factory;

import dao.ReportDAO;
import dao.StatusDAO;
import dao.UserDAO;

/**
 * Abstract factory for creation a dao-entity
 */
public abstract class DAOFactory {

    public abstract UserDAO createUserDAO();

    public abstract ReportDAO createReportDAO();

    public abstract StatusDAO createStatusService();
}
