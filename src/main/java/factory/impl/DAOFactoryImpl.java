package factory.impl;

import dao.ReportDAO;
import dao.UserDAO;
import dao.impl.ReportDAOImpl;
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
}
