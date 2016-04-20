package pl.pogos.stock.config;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.pogos.stock.repository.ShareRepository;

/**
 * Created by SG0952928 on 2016-04-19.
 */
@Configuration
@ComponentScan("pl.pogos.stock.service")
public class ServiceConfiguration {

    @Bean
    ShareRepository getShareRepository() {
        return Mockito.mock(ShareRepository.class);
    }
}
