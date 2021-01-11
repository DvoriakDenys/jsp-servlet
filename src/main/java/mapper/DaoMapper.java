package mapper;

import entity.Report;
import entity.Status;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DaoMapper {

    User mapResultSetToUser(ResultSet resultSet) throws SQLException;

    Report mapResultSetToReport(ResultSet resultSet) throws SQLException;

    Status mapResultSetToStatus(ResultSet resultSet) throws SQLException;

}
