package dao;

import entity.Status;

import java.sql.SQLException;

public interface StatusDAO {

    Status findByName(String name) throws SQLException;

}
