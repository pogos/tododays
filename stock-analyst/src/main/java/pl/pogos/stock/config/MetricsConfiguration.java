package pl.pogos.stock.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableMetrics
public class MetricsConfiguration extends MetricsConfigurerAdapter {

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        registerReporter(
                Slf4jReporter
                //ConsoleReporter
                        .forRegistry(metricRegistry)
                        .convertDurationsTo(TimeUnit.SECONDS)
                .build())
            .start(1, TimeUnit.MINUTES);
    }
}
