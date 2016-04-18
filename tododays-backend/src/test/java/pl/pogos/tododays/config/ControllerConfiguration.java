package pl.pogos.tododays.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by SG0952928 on 2016-04-15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.pogos.tododays.controller")
public class ControllerConfiguration {
}
