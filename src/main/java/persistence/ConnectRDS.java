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
                Class.forName(properties.getProperty("connection.driver_class"));
                String jdbcUrl = properties.getProperty("connection.url");
                logger.error("Getting remote connection with connection string from environment variables.");
                connection = DriverManager.getConnection(jdbcUrl);
                logger.info("Remote connection successful.");
                return connection;
            }
            catch (ClassNotFoundException e) { logger.warn(e.toString());}
            catch (SQLException e) { logger.warn(e.toString());}
        }
        return null;
    }


}
