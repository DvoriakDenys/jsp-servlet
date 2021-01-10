package dao;
import entity.Report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface ReportDAO {

    List<Report> findAll() throws SQLException;

    boolean save(Report report) throws SQLException;

    Report findById(int id) throws SQLException;
}
