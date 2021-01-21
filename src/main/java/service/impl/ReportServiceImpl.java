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

    @Override
    public List<Report> findAllReportsByUserId(final Long id, final int currentPage, final int quantityReportOnPage,
                                               final String sorting, final String status) throws SQLException{
        return reportDAO.findAllReportsByUserId(id, currentPage, quantityReportOnPage, sorting, status);
    }

    public void save(Report report) throws SQLException {
        reportDAO.save(report);
    }

    @Override
    public void updateComment(Report report) throws SQLException {
        reportDAO.updateComment(report);
    }

    @Override
    public void updateReport(Report report) throws SQLException {
        reportDAO.updateReport(report);
    }

    @Override
    public List<Report> sortReportsByStatus(final int currentPage, final int quantityReportOnPage,
                                            final int id) throws SQLException{
        return reportDAO.sortReportsByStatus(currentPage, quantityReportOnPage, id);
    }

    @Override
    public List<Report> paginationReport (int pageNumber, int pageSize, String sorting,
                                          final String status) throws SQLException{

        return reportDAO.paginationReport(pageNumber, pageSize, sorting, status);
    }

    @Override
    public Report findById(int id) throws SQLException {
        return reportDAO.findById(id);
    }
}