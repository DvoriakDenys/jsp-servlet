package mapper.impl;

import entity.Report;
import entity.Role;
import entity.User;
import mapper.DaoMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoMapperImpl implements DaoMapper {
    @Override
    public User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        final User user = User.builder()
                .id(resultSet.getLong("id"))
                .email(resultSet.getString("email"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .middleName(resultSet.getString("middle_name"))
                .role(Role.builder()
                        .role(resultSet.getString("role"))
                        .id(resultSet.getLong("role_id"))
                        .build())
                .password(resultSet.getString("password"))
                .build();
        return user;
    }

    @Override
    public Report mapResultSetToReport(ResultSet resultSet) throws SQLException {
        return Report.builder()
                .id(resultSet.getLong("id"))
                .report(resultSet.getString("report"))
                .comment(resultSet.getString("comment"))
                .nameOfReport(resultSet.getString("name_of_report"))
                .build();
    }
}
