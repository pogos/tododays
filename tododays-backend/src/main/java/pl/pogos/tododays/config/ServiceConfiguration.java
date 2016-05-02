package pl.pogos.tododays.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "pl.pogos.tododays.service")
public class ServiceConfiguration {

    @Bean
    public Mapper getMapper() {
        return new DozerBeanMapper();
    }

}
