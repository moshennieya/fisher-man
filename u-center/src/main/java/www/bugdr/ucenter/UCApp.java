package www.bugdr.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("www.bugdr.ucenter.mapper")
@ComponentScan("www.bugdr.common.utils")
@ComponentScan("www.bugdr.ucenter")
public class UCApp {
    public static void main(String[] args) {
        SpringApplication.run(UCApp.class, args);
    }
}
