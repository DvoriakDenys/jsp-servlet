package config.pool;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private final static Logger logger = Logger.getLogger(ConnectionPool.class);
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
            logger.error("Getting context error " + e);
        }
    }

    /**
     * Method for getting a connection
     *
     * @return {@link Connection}
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Getting connection error :" + e);
            throw e;
        }
    }

}
