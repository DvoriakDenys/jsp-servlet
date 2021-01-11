package service.impl;

import dao.StatusDAO;
import entity.Status;
import lombok.RequiredArgsConstructor;
import service.StatusService;

import java.sql.SQLException;

@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusDAO statusDAO;

    @Override
    public Status findByName(String name) throws SQLException {
        return statusDAO.findByName(name);
    }
}
