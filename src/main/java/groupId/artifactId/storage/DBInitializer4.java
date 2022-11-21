package by.it_academy.jd2.hw.example.crm.storage;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer4 {
    private static final ComboPooledDataSource cpds;

    static {
        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Ошибка загрузки драйвера" ,e);
        }
        cpds.setJdbcUrl( "jdbc:postgresql://localhost:5432/crm" );
        cpds.setUser("postgres");
        cpds.setPassword("postgres");
    }

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }
}
