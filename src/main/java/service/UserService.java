package service;

import entity.Report;
import entity.User;

import java.sql.SQLException;

public interface UserService {

    User findUserByEmail(String email) throws SQLException;

    void saveUser(User user) throws SQLException;

    User findById(int id) throws SQLException;

}
