package dao;
import entity.Report;
import entity.Status;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface ReportDAO {

    void updateReport (Report report) throws SQLException;

    List<Report> findAll() throws SQLException;

    boolean save(Report report) throws SQLException;

    List<Report> sortReportsByStatus (final int currentPage, final int quantityReportOnPage,
                                      final int id) throws SQLException;

    Report findById(int id) throws SQLException;

    List<Report> findAllReportsByUserId(final Long id, final int currentPage, final int quantityReportOnPage,
                                        final String sorting, final String status) throws SQLException;

    void updateComment (Report report) throws SQLException;

    List<Report> paginationReport (int pageNumber, int pageSize, String sorting,
                                   final String status) throws SQLException;
}
