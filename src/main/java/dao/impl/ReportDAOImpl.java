package dao.impl;

import config.pool.ConnectionPool;
import dao.ReportDAO;
import entity.Report;
import entity.Status;
import lombok.extern.log4j.Log4j;
import mapper.DaoMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
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
    public List<Report> findAllReportsByUserId(Long id) throws SQLException {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = pool.getConnection();

             PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.report.findReportsByUserId"))) {

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                reports.add(daoMapper.mapResultSetToReport(rs));
            }

            return reports;

        } catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e;
        }
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
