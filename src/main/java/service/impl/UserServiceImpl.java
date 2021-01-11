package service.impl;

import dao.UserDAO;
import entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import service.UserService;

import java.sql.SQLException;

@RequiredArgsConstructor
@Log4j
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public User findUserByEmail(String email) throws SQLException {
        log.info("Start findUserByEmail method, email=" + email);
        final User userByEmail = userDAO.findUserByEmail(email);
        log.info("End findUserByEmail method, user=" + userByEmail);
        return userByEmail;
    }

    @Override
    public void saveUser(User user) throws SQLException {
    }

    @Override
    public User findById(int id) throws SQLException {
        return userDAO.findById(id);
    }
}
