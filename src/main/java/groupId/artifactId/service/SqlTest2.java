package by.it_academy.jd2.hw.example.crm.service;

import by.it_academy.jd2.hw.example.crm.storage.DBInitializer4;

import java.sql.*;

public class SqlTest2 {

    public static void main(String[] args) throws SQLException {
        try (Connection con = DBInitializer4.getConnection();
             PreparedStatement statement = con.prepareStatement(
                     "SELECT id, name, salary " +
                             "FROM application.employers " +
                             "ORDER BY id ASC " +
                             "LIMIT ? OFFSET ?"
             );){

            statement.setLong(1, 10);
            statement.setLong(2, 20);

            try(ResultSet resultSet = statement.executeQuery();){
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
    }
}
