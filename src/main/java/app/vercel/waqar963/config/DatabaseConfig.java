package app.vercel.waqar963.config;

import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;

public class DatabaseConfig {
    private static final String ACTIVE_ENV = "mysql"; //"mysql" or "h2", based on a condition or profile
    private static final Dotenv dotenv = Dotenv.configure()
            .filename(".env." + ACTIVE_ENV)
            .directory(System.getProperty("user.dir"))
            .load();

    public static DataSource getDataSource() {
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPass = dotenv.get("DB_PASS");

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPass);

        System.out.println("Connected to: " + dotenv.get("DB_TYPE").toUpperCase());
        return ds;
    }
}