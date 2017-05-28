package jd.jdbc;

import java.sql.*;

/**
 * Created by jdev on 28.05.2017.
 */
public class JdbcMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver"); // подключение драйвера
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
        createTable(connection);
        create(1, "Soyuz", connection);
        create(2, "Falcon", connection);
        create(3, "Angara", connection);
        System.out.println("=========== after create");
        read(connection);

        update(1, "Soyuz 2", connection);
        update(2, "Falcon 9", connection);
        update(3, "Angara A5", connection);
        System.out.println("\n=========== after update");
        read(connection);

        delete("Soyuz 2", connection);
        System.out.println("\n=========== after delete 1");
        read(connection);

        delete("Falcon 9", connection);
        System.out.println("\n=========== after delete 2");
        read(connection);

        delete("Angara", connection);
        System.out.println("\n=========== after delete 3");
        read(connection);

        delete("Angara A5", connection);
        System.out.println("\n=========== after delete 4");
        read(connection);
    }

    private static void createTable(Connection connection) throws SQLException {
        //создание таблицы
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE ROCKETS" +
                "(" +
                "    ID integer PRIMARY KEY NOT NULL," +
                "    MODEL varchar(32) NOT NULL" +
                ")";
        //исполнение запроса создания схемы
        statement.execute(sql);
    }

    private static void create(int id, String model, Connection connection) throws SQLException {
        String sql = "INSERT INTO ROCKETS " +
                "VALUES ( " + id +",'" + model +"' )";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    private static void read(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM ROCKETS";
        ResultSet rs = statement.executeQuery(sql);
        int records = 0;
        while(rs.next()){
            records++;
            //извлечение по имени столбца
            int id  = rs.getInt("id");
            String model = rs.getString("model");
            System.out.println("id = > " + id + "; model => " + model);
        }
        if (records == 0) {
            System.out.println("NO RECORDS...");
        }
    }

    private static void update(int id, String model, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "UPDATE ROCKETS SET model='" + model + "' WHERE id = " + id;
        statement.executeUpdate(sql);
    }

    private static void delete(String model, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM ROCKETS WHERE model='" + model + "'";
        statement.executeUpdate(sql);
    }
}
