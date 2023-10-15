package ie.nci.journey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ie.nci.journey.mapper")
public class JourneyApplication {
    public static void main(String[] args) {
        SpringApplication.run(JourneyApplication.class, args);
    }

}
