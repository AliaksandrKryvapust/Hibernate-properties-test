package by.it_academy.jd2.hw.example.crm.service;

import by.it_academy.jd2.hw.example.crm.storage.DBInitializer4;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTest {

    public static void main(String[] args) throws SQLException {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 500; i++) {
            long startIterationTime = System.currentTimeMillis();
            try (Connection con = DBInitializer4.getConnection();
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
