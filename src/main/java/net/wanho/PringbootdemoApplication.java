package net.wanho;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.wanho.mapper")
public class PringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PringbootdemoApplication.class, args);
    }

}
