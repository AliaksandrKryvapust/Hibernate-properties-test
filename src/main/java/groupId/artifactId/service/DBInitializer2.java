package by.it_academy.jd2.hw.example.crm.service;

import java.sql.*;

public class DBInitializer2 {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Ошибка загрузки драйвера", e);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            long startIterationTime = System.currentTimeMillis();
            try (Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/crm",
                    "postgres", "postgres"
            );
                 Statement statement = con.createStatement();){

                try(ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM application.employers ORDER BY id ASC");){

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
