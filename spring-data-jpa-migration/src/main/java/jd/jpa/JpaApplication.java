package jd.jpa;

import jd.dao.Rocket;
import jd.dao.repo.RocketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("jd.dao")
@EntityScan(basePackageClasses = jd.dao.Rocket.class)
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<Rocket> all;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    RocketRepository rocketRepository;

    @Override
    public void run(String... args) throws Exception {
        read();

        Rocket soyuz = create( "Soyuz");
        Rocket falcon = create( "Falcon");
        Rocket angara = create("Angara");
        log.info("=========== after create");
        read();

        update(soyuz, "Soyuz 2");
        update(falcon, "Falcon 9");
        update(angara, "Angara A5");

        log.info("=========== after update");
        read();

        delete(soyuz);
        log.info("=========== after delete 1");
        read();

        delete(falcon);
        log.info("=========== after delete 2");
        read();

        delete(angara);
        log.info("=========== after delete 3");
        read();

        delete(angara);
        log.info("=========== after delete 4");
        read();
    }

    private void delete(Rocket rocket) {
        rocketRepository.delete(rocket);
    }

    private void update(Rocket rocket, String model) {
        rocket.setModel(model);
        rocketRepository.save(rocket);
    }

    private void read() {
         all = (List<Rocket>) rocketRepository.findAll();

         if (all.size() == 0) {
             log.info("NO RECORDS");
         }

         all.stream().forEach(rocket -> log.info(rocket.toString()));
    }

    private Rocket create(String model) {
        Rocket rocket = new Rocket();
        rocket.setModel(model);
        return rocketRepository.save(rocket);
    }
}
