package dao.impl;

import config.pool.ConnectionPool;
import dao.ReportDAO;
import entity.Report;
import lombok.extern.log4j.Log4j;
import mapper.DaoMapper;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

@Log4j
public class ReportDAOImpl implements ReportDAO {

    private ConnectionPool pool = ConnectionPool.getInstance();
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");

    private final DaoMapper daoMapper;

    public ReportDAOImpl(DaoMapper daoMapper) {
        this.daoMapper = daoMapper;
    }

    @Override
    public List<Report> findAll() throws SQLException {
        List<Report> reports = new ArrayList<>();
        final String query = bundle.getString("sql.user.findAll");
        log.info("Execute query=" + query);
        ResultSet resultSet = null;

        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reports.add(daoMapper.mapResultSetToReport(resultSet));
            }
            return reports;
        } catch (SQLException e) {
            log.error("Database error " + e);
            throw e;
        } finally {
            Objects.requireNonNull(resultSet).close();
        }
    }

    @Override
    public boolean save(Report report) throws SQLException {

        try (final Connection connection = pool.getConnection();
             PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.report.save"))) {
            ps.setString(1, report.getComment());
            ps.setDate(2, new Date(new java.util.Date().getTime()));
            ps.setString(3, report.getNameOfReport());
            ps.setString(4, report.getReport());
            ps.setInt(5, 2);
            ps.setLong(6, report.getUser().getId());

            return ps.execute();

        } catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e;
        }
    }

    @Override
    public Report findById(int id) throws SQLException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.report.findById"))) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return daoMapper.mapResultSetToReport(rs);
            }
        } catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e;
        }

        return null;
    }

    @Override
    public List<Report> findAllReportsByUserId(final Long id, final int currentPage, final int quantityReportOnPage,
                                               final String sorting, final String status) throws SQLException{
        List <Report> reports = new ArrayList<>();
        String resultQuery;

        try (Connection connection = pool.getConnection()){

            if (status == null) {
                String query = bundle.getString("sql.report.findReportsByUserId");
                resultQuery = MessageFormat.format(query, id, sorting, quantityReportOnPage, currentPage);
            } else {
                String query = bundle.getString("sql.report.sort.user.status");
                resultQuery = MessageFormat.format(query, status, id, quantityReportOnPage, currentPage);
            }

            PreparedStatement preparedStatement = connection.prepareStatement(resultQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                reports.add(daoMapper.mapResultSetToReport(resultSet));
            }

        } catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e;
        }
        return reports;
    }

    @Override
    public List<Report> paginationReport ( final int currentPage, final int quantityReportOnPage,
                                           final String sorting, final String status) throws SQLException{
        List <Report> reports = new ArrayList<>();
        String resultQuery;

        try (Connection connection = pool.getConnection()) {

            if (status == null) {
                String query = bundle.getString("sql.report.paginationReport");
                resultQuery = MessageFormat.format(query, sorting, quantityReportOnPage, currentPage);
            } else {
                String query = bundle.getString("sql.report.sort.status");
                resultQuery = MessageFormat.format(query, status, quantityReportOnPage, currentPage);
            }

            PreparedStatement preparedStatement = connection.prepareStatement(resultQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                reports.add(daoMapper.mapResultSetToReport(resultSet));
            }

        } catch (SQLException e){
            log.error("Database error (dao level): " + e);
            throw e;
        }

        return reports;
    }



    @Override
    public List<Report> sortReportsByStatus (final int currentPage, final int quantityReportOnPage,
                                             final int id) throws SQLException{
        List <Report> reports = new ArrayList<>();
        try (Connection connection = pool.getConnection()){
            String query = bundle.getString("sql.report.sort.status");
            String query2 = MessageFormat.format(query, id, quantityReportOnPage, currentPage);
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                reports.add(daoMapper.mapResultSetToReport(resultSet)); }
        }catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e; }
        return reports;
    }


    @Override
    public void updateReport (Report report) throws SQLException{
        final String query = bundle.getString("sql.report.updateReport");

        try (final Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, report.getReport());
            statement.setString(2, report.getNameOfReport());
            statement.setString(3, report.getComment());
            statement.setInt(4, 2);
            statement.setLong(5, report.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e;
        }
    }

    @Override
    public void updateComment(Report report) throws SQLException {
        final String query = bundle.getString("sql.report.updateComment");
        try (final Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, report.getComment());
            statement.setInt(2, report.getStatus().getId().intValue());
            statement.setLong(3, report.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e;
        }
    }

}
