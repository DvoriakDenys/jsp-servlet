package dao.impl;

import config.pool.ConnectionPool;
import dao.UserDAO;
import entity.Report;
import entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import mapper.DaoMapper;

import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

@Log4j
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {
    private final ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");
    private final ConnectionPool pool = ConnectionPool.getInstance();

    private final DaoMapper daoMapper;

    @Override
    public User findUserByEmail(final String email) throws SQLException {
        final String query = bundle.getString("sql.user.findByEmail");
        log.info("Execute query=" + query);
        ResultSet resultSet = null;


        try (Connection connection = pool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return daoMapper.mapResultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            log.error("Database error " + e);
            throw e;
        } finally {
            Objects.requireNonNull(resultSet).close();
        }

        return null;
    }

    @Override
    public User findById(int id) throws SQLException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.user.findById"))) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return daoMapper.mapResultSetToUser(rs);
            }

        } catch (SQLException e) {
            log.error("Database error (dao level): " + e);
            throw e;
        }

        return null;
    }
}
