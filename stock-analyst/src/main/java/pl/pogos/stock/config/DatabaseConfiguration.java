package pl.pogos.stock.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.pogos.stock.data.InitDataLoader;
import pl.pogos.stock.data.SampleInitDataLoader;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"pl.pogos.stock.repository"})
@EntityScan(basePackages = {"pl.pogos.stock.model"})
public class DatabaseConfiguration {

    public InitDataLoader getInitDataLoader() {
        return new SampleInitDataLoader();
    }

}
