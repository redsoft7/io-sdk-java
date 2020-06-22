import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConfiguration {

    private Args args;
    private String jdbcUrl;

    public JdbcConfiguration(Args args) throws IOException, ClassNotFoundException {
        this.args = args;
        init();
    }

    private void init() throws IOException, ClassNotFoundException {

        try (InputStream input = this.getClass().getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            jdbcUrl = prop.getProperty("jdbc.url")
                    .replace("${host}", args.getHost())
                    .replace("${port}", args.getPort())
                    .replace("${database}", args.getDatabase());

            Class.forName(prop.getProperty("jdbc.driver"));

        } catch (IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(jdbcUrl, args.getUser(), args.getPassword());
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
