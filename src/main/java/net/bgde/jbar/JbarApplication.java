package net.bgde.jbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(excludeFilters = @ComponentScan.Filter(value = Configuration.class))
public class JbarApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JbarApplication.class, args);
	}
}
