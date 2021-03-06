package dao;

import entity.Report;
import entity.User;

import java.sql.SQLException;

public interface UserDAO {

    User findUserByEmail (String email) throws SQLException;

    User findById(int id) throws SQLException;

    void save (User user) throws SQLException;
}
