package www.bugdr.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("www.bugdr.ucenter.mapper")
public class UCApp {
    public static void main(String[] args) {
        SpringApplication.run(UCApp.class, args);
    }
}
