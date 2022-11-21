package by.it_academy.jd2.hw.example.crm.service;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;

public class DBInitializer3 {

    public static void main(String[] args) throws SQLException {
        long startTime = System.currentTimeMillis();

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Ошибка загрузки драйвера" ,e);
        }
        cpds.setJdbcUrl( "jdbc:postgresql://localhost:5432/crm" );
        cpds.setUser("postgres");
        cpds.setPassword("postgres");

        for (int i = 0; i < 500; i++) {
            long startIterationTime = System.currentTimeMillis();
            try (Connection con = cpds.getConnection();
                 Statement statement = con.createStatement();){

                try(ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM application.employers ORDER BY id ASC");){
                    System.out.printf("id\tИмя\tЗарпалата\n");
                    while (resultSet.next()){
                        System.out.printf("%d\t%s\t%,.2f\n",
                                resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getDouble(3)
                        );
                    }
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Ошибка работы с базой данных", e);
            }
            long stopIterationTime = System.currentTimeMillis();
            System.out.printf("Время выполнения запроса {%d} - {%d}\n", i, stopIterationTime - startIterationTime);
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("Общее время " + (stopTime - startTime));
    }
}
