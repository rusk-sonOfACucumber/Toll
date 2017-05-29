package jd.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class JdbcTemplateApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("создание таблиц");
        createTable();
        read();

        create(1, "Soyuz");
        create(2, "Falcon");
        create(3, "Angara");
        log.info("=========== after create");
        read();

        update(1, "Soyuz 2");
        update(2, "Falcon 9");
        update(3, "Angara A5");
        log.info("=========== after update");
        read();

        delete("Soyuz 2");
        log.info("=========== after delete 1");
        read();

        delete("Falcon 9");
        log.info("=========== after delete 2");
        read();

        delete("Angara");
        log.info("=========== after delete 3");
        read();

        delete("Angara A5");
        log.info("=========== after delete 4");
        read();
    }

    private void delete(String model) {
//        jdbcTemplate.update("DELETE FROM ROCKETS WHERE model='" + model + "'");
        jdbcTemplate.update("DELETE FROM ROCKETS WHERE model=?", model);
    }

    private void update(int id, String model) {
//        jdbcTemplate.update("UPDATE ROCKETS SET model='" + model + "' WHERE id = " + id);
        jdbcTemplate.update("UPDATE ROCKETS SET model=? WHERE id = ?", model, id);
    }

    private void read() {
        List<Rocket> result = jdbcTemplate.query(
                "SELECT * FROM ROCKETS",
                new RowMapper<Rocket>() {
                    @Override
                    public Rocket mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Rocket(
                                rs.getInt("id"),
                                rs.getString("model")
                        );
                    }
                }
        );
        if (result.size() == 0) {
            log.info("NO RECORDS");
        }
        for (Rocket rocket : result) {
            log.info(rocket.toString());
        }
        // вывод с использованием lambda
        //result.stream().forEach(rocket -> log.info(rocket.toString()));
    }

    private void create(int id, String model) {
        jdbcTemplate.update("INSERT INTO ROCKETS " +
                "VALUES ( " + id +",'" + model +"' )");
    }

    private void createTable() {
        jdbcTemplate.execute("CREATE TABLE ROCKETS" +
                "(" +
                "    ID integer PRIMARY KEY NOT NULL," +
                "    MODEL varchar(32) NOT NULL" +
                ")");
    }
}