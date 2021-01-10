package service;

import entity.Report;

import java.sql.SQLException;
import java.util.List;

public interface ReportService {

    List<Report> findAll() throws SQLException;

    void save(Report report) throws SQLException;

    Report findById(int id) throws SQLException;
}
