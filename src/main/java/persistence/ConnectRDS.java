package persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectRDS {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private static ConnectRDS instance = new ConnectRDS();

    private static Properties properties;

    private Connection connection;

    private ConnectRDS() {
        loadProperties();

    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/hibernate.cfg.xml"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file", ioe);
        } catch (Exception e) {
            logger.error("Database.loadProperties()...", e);
        }
    }

    public Connection getRemoteConnection() {
        if (System.getProperty("RDS_HOSTNAME") != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbName = System.getProperty("RDS_DB_NAME");
                String userName = System.getProperty("RDS_USERNAME");
                String password = System.getProperty("RDS_PASSWORD");
                String hostname = System.getProperty("RDS_HOSTNAME");
                String port = System.getProperty("RDS_PORT");
                String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
                logger.trace("Getting remote connection with connection string from environment variables.");
                Connection con = DriverManager.getConnection(jdbcUrl);
                logger.info("Remote connection successful.");
                return con;
            }
            catch (ClassNotFoundException e) { logger.warn(e.toString());}
            catch (SQLException e) { logger.warn(e.toString());}
        }
        return null;
    }

    public static ConnectRDS getInstance() {
        return instance;
    }


}
