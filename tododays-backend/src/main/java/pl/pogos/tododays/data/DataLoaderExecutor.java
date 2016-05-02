package pl.pogos.tododays.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Component
@Profile("loadData")
public class DataLoaderExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoaderExecutor.class);

    @Inject
    private List<DataLoader> loaderList;

    @PostConstruct
    public void loadSampleData() {
        LOGGER.info("\nLoad Sample data\n");
        for (DataLoader dataLoader : loaderList) {
            LOGGER.info("Start loading: " + dataLoader.getName());
            dataLoader.loadData();
            LOGGER.info("Finished loading: " + dataLoader.getName());
        }

    }

}
