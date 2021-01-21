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
    public void save (User user) throws SQLException{
        final String query = bundle.getString("sql.add.new.user");
        try (Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getMiddleName());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, 2);

            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
