package org.wfq.odo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("org.wfq.odo.dao")
public class WFQAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WFQAppApplication.class, args);
	}
	
}
