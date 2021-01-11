package service;

import entity.Status;

import java.sql.SQLException;

public interface StatusService {
    Status findByName(String name) throws SQLException;
}
