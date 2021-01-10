package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDAO {

    User findUserByEmail (String email) throws SQLException;
}
