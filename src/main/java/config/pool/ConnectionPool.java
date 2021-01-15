package config.pool;

import lombok.extern.log4j.Log4j;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j
public class ConnectionPool {

    private static ConnectionPool pool;

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }


    private DataSource dataSource;

    {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/foo");
        } catch (NamingException e) {
            log.error("Getting context error " + e);
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Getting connection error :" + e);
            throw e;
        }
    }

}
