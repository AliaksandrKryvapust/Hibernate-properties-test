package by.it_academy.jd2.hw.example.crm.service;

import java.sql.*;

public class DBInitializer {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Ошибка загрузки драйвера", e);
        }
    }

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "postgres"
        );
             Statement statement = con.createStatement();){

            String name = "Антон";
            Double salary = -1.0;

            try(PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO application.employers(\n" +
                    "                    name, salary)\n" +
                    "            VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS)
            ){
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, salary);

                preparedStatement.executeUpdate();

                try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys();){
                    while (generatedKeys.next()){
                        System.out.println("Сгенерированный ключ " + generatedKeys.getLong(1));
                    }
                }
            }

//            statement.executeUpdate("INSERT INTO application.employers(\n" +
//                    "\tname, salary)\n" +
//                    "\tVALUES ('" + name + "', " + salary + ");");

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
    }

    public static void mainOld(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "postgres"
            );
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM application.employers ORDER BY id ASC");){
            System.out.printf("id\tИмя\tЗарпалата\n");
            while (resultSet.next()){
                System.out.printf("%d\t%s\t%,.2f",
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)
                );
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }
    }
}
