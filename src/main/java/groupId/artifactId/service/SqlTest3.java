package by.it_academy.jd2.hw.example.crm.service;

import by.it_academy.jd2.hw.example.crm.storage.DBInitializer4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SqlTest3 {

    public static void main(String[] args) throws SQLException {
        try (Connection con = DBInitializer4.getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO application.employers (name, salary) VALUES (?, ?)")
        ){
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            String[] names = {"Илья","Антон","Иван","Дарья","Настя","Лера","Вася","Лиза","Дима","Артём","Саша"};
            for (int i = 1; i <= 10_000; i++) {
                statement.setString(1, names[rand.nextInt(0, names.length)]);
                BigDecimal salary = BigDecimal.valueOf(rand.nextDouble(99999999));
                salary.setScale(2, RoundingMode.HALF_UP);
                statement.setBigDecimal(2, salary);
                statement.addBatch();
                if(i % 1_000 == 0){
                    statement.executeBatch();
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }
    }
}
