package service;

import entity.Report;

import java.sql.SQLException;
import java.util.List;

public interface ReportService {

    List<Report> findAll() throws SQLException;

    List<Report> findAllReportsByUserId(final Long id, final int currentPage, final int quantityReportOnPage,
                                        final String sorting, final String status) throws SQLException;

    void save(final Report report) throws SQLException;

    void updateComment(final Report report) throws SQLException;

    void updateReport (final Report report) throws SQLException;

    Report findById(final int id) throws SQLException;

    List<Report> sortReportsByStatus (final int currentPage, final int quantityReportOnPage,
                                      final int id) throws SQLException;

    List<Report> paginationReport (final int pageNumber, final int pageSize, final String sorting,
                                   final String status) throws SQLException;
}
