package service.impl;

import dao.ReportDAO;
import entity.Report;
import lombok.RequiredArgsConstructor;
import service.ReportService;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportDAO reportDAO;

    public List<Report> findAll() throws SQLException {
        return reportDAO.findAll();
    }

    public void save(Report report) throws SQLException {
        reportDAO.save(report);
    }

    @Override
    public Report findById(int id) throws SQLException {
        return reportDAO.findById(id);
    }
}
