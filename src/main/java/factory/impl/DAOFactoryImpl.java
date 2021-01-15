package factory.impl;

import dao.ReportDAO;
import dao.StatusDAO;
import dao.UserDAO;
import dao.impl.ReportDAOImpl;
import dao.impl.StatusDAOImpl;
import dao.impl.UserDAOImpl;
import factory.DAOFactory;
import mapper.impl.DaoMapperImpl;

public class DAOFactoryImpl extends DAOFactory {

    @Override
    public UserDAO createUserDAO() {
        return new UserDAOImpl(new DaoMapperImpl());
    }

    @Override
    public ReportDAO createReportDAO() {
        return new ReportDAOImpl(new DaoMapperImpl());
    }

    @Override
    public StatusDAO createStatusService() {
        return new StatusDAOImpl(new DaoMapperImpl());
    }
}
